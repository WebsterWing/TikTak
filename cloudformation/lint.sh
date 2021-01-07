#!/usr/bin/env bash

# Make sure globstar is enabled
shopt -s globstar
for i in **/*.yaml; do # Whitespace-safe and recursive
    echo "File: $i"
    aws cloudformation validate-template --template-body "file://$i"

    if [ $? -ne 0 ]; then
        echo "\nFailure on file: $i"
        exit 1
    fi

    echo
done
