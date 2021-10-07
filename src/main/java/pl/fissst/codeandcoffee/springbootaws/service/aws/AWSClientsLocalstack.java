package pl.fissst.codeandcoffee.springbootaws.service.aws;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("local")
@Service("amazonClient")
public class AWSClientsLocalstack implements AWSClients {

    @Value("${cloud.aws.region.static:eu-central-1}")
    private String regionStatic;

    @Value("${cloud.localstack.url:http://localstack:4566}")
    private String localstackUrl;

    @Override
    public AmazonSQSAsync getAmazonSQS() {
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withEndpointConfiguration(getEndpointConfiguration())
                .build();
    }

    @Override
    public AmazonS3 getAmazonS3() {
        return AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(getEndpointConfiguration())
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration getEndpointConfiguration() {
        return new AwsClientBuilder.EndpointConfiguration(localstackUrl, regionStatic);
    }
}