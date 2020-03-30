#!/bin/bash

#############################################
# Simple script to "deploy" the application #
#############################################

#mvn clean package

mkdir -p deployment
cp validation/target/labels-validation-0.0.1-SNAPSHOT-jar-with-dependencies.jar deployment/
cp label-one/target/labels-label-one-0.0.1-SNAPSHOT.jar deployment/
cp label-two/target/labels-label-two-0.0.1-SNAPSHOT.jar deployment/

java -cp "deployment/*" -Dvalidation.modules=com.lcms.labels.DocumentLabelOneModule,com.lcms.labels.DocumentLabelTwoModule com.lcms.labels.ValidationService

