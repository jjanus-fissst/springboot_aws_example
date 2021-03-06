package pl.fissst.codeandcoffee.springbootaws.config;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.fissst.codeandcoffee.springbootaws.service.aws.AWSClients;

@Profile("local")
@Configuration
public class LocalstackConfiguration {

    private final AWSClients awsClients;

    public LocalstackConfiguration(AWSClients awsClients) {
        this.awsClients = awsClients;
    }

    @Bean
    public AmazonSQSAsync amazonSQS() {
        return awsClients.getAmazonSQS();
    }
}