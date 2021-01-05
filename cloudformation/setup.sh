#!/usr/bin/env bash

BUCKET_NAME=tiktak-config

aws s3 cp ./config s3://$BUCKET_NAME/ --recursive
