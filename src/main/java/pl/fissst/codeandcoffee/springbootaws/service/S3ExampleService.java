package pl.fissst.codeandcoffee.springbootaws.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.stereotype.Service;
import pl.fissst.codeandcoffee.springbootaws.service.aws.AWSClients;

@Service
public class S3ExampleService {

    private final AWSClients awsClients;

    public S3ExampleService(AWSClients awsClients) {
        this.awsClients = awsClients;
    }

    public void createFile(String bucketName, String fileName, String text) {
        AmazonS3 amazonS3 = awsClients.getAmazonS3();

        if (!amazonS3.doesBucketExistV2(bucketName)) {
            amazonS3.createBucket(bucketName);
        }

        amazonS3.putObject(bucketName, fileName, text);
    }
}