package pl.fissst.codeandcoffee.springbootaws.service.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQSAsync;

public interface AWSClients {

    AmazonSQSAsync getAmazonSQS();

    AmazonS3 getAmazonS3();
}