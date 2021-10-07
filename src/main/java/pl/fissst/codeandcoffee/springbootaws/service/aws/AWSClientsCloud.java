package pl.fissst.codeandcoffee.springbootaws.service.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!local")
public class AWSClientsCloud implements AWSClients {

    @Override
    public AmazonSQSAsync getAmazonSQS() {
        return AmazonSQSAsyncClientBuilder.defaultClient();
    }

    @Override
    public AmazonS3 getAmazonS3() {
        return AmazonS3ClientBuilder.defaultClient();
    }
}