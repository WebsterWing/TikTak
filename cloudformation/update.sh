#!/usr/bin/env bash

KEY_NAME=tiktak-ec2-keypair
STACK_NAME=TikTak
CONFIG_STACK_NAME=TikTakConfig
BUCKET_NAME=tiktak-config
BUILD_BUCKET_NAME=tiktak-build
WEBSITE_BUCKET_NAME=tiktak-website

FRONTEND_REPOSITORY=WebsterWing/tiktak-frontend
BACKEND_REPOSITORY=WebsterWing/tiktak-node
# COMMIT_ID=11e70fe014800749c639663ee675853f2b831f06

IS_UPDATE=true

set -o posix

while getopts "cu" flag

do
        case "${flag}" in
                c) IS_UPDATE=false
                    echo TEST
                        ;;
                u) IS_UPDATE=true
                         ;;
                *) echo "Invalid option: -$flag" ;;
        esac
done

echo $IS_UPDATE

if $IS_UPDATE; then
    UPDATE_CMD=update-stack
    UPDATE_TXT=Update
else
    UPDATE_CMD=create-stack
    UPDATE_TXT=Create
fi

echo -e "Linting\n"
./lint.sh
if [ $? -ne 0 ]; then
    exit 1
fi

echo "$UPDATE_TXT Config Cloudformation Stack"
echo -e "\tConfig Stack Name: $CONFIG_STACK_NAME"
echo -e "\tBucket Name: $BUCKET_NAME"

aws cloudformation $UPDATE_CMD \
    --stack-name $CONFIG_STACK_NAME \
    --template-body file://config.yaml \
    --parameters ParameterKey=BucketName,ParameterValue=$BUCKET_NAME

# if $IS_UPDATE; then
#     aws cloudformation wait stack-update-complete --stack-name $CONFIG_STACK_NAME
# else
#     aws cloudformation wait stack-create-complete --stack-name $CONFIG_STACK_NAME
# fi

BUCKET_URL=$(aws cloudformation describe-stacks \
    --stack-name $CONFIG_STACK_NAME \
    --query "Stacks[0].Outputs[?OutputKey=='S3BucketDomain'].OutputValue" \
    --output text)

if [ $? -ne 0 ]; then
    echo "\nFailed to create S3Bucket"
    exit 1
fi

echo -e "\nSyncing Cloudformation config files"
echo -e "\tBucket Url: $BUCKET_URL"

aws s3 sync ./stacks s3://$BUCKET_NAME/ --delete

echo
echo "$UPDATE_TXT Cloudformation"
echo -e "\tStack Name: $STACK_NAME"

aws cloudformation $UPDATE_CMD \
    --stack-name $STACK_NAME \
    --template-body file://master.yaml \
    --capabilities CAPABILITY_IAM \
    --capabilities CAPABILITY_NAMED_IAM \
    --parameters ParameterKey=ConfigBucketUrl,ParameterValue=$BUCKET_URL \
    ParameterKey=WebsiteBucketName,ParameterValue=$WEBSITE_BUCKET_NAME \
    ParameterKey=KeyName,ParameterValue=$KEY_NAME \
    ParameterKey=FrontendRepository,ParameterValue=$FRONTEND_REPOSITORY \
    ParameterKey=BackendRepository,ParameterValue=$BACKEND_REPOSITORY \
    ParameterKey=BuildBucketName,ParameterValue=$BUILD_BUCKET_NAME
# \ ParameterKey=CommitId,ParameterValue=$COMMIT_ID
