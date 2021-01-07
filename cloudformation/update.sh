#!/usr/bin/env bash

KEY_NAME=tiktak-ec2-keypair
STACK_NAME=TikTak
CONFIG_STACK_NAME=TikTakConfig
BUCKET_NAME=tiktak-config

echo -e "Linting\n"
./lint.sh
if [ $? -ne 0 ]; then
    exit 1
fi

echo -e "Update Config Cloudformation Stack"
echo -e "\tConfig Stack Name: $CONFIG_STACK_NAME"
echo -e "\tBucket Name: $BUCKET_NAME"

aws cloudformation update-stack \
    --stack-name $CONFIG_STACK_NAME \
    --template-body file://config.yaml \
    --parameters ParameterKey=BucketName,ParameterValue=$BUCKET_NAME

aws cloudformation wait stack-update-complete --stack-name $CONFIG_STACK_NAME

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

echo -e "\nUpdate Cloudformation"
echo -e "\tStack Name: $STACK_NAME"

aws cloudformation update-stack \
    --stack-name $STACK_NAME \
    --template-body file://master.yaml \
    --capabilities CAPABILITY_IAM \
    --capabilities CAPABILITY_NAMED_IAM \
    --parameters ParameterKey=BucketUrl,ParameterValue=$BUCKET_URL \
    ParameterKey=KeyName,ParameterValue=$KEY_NAME
