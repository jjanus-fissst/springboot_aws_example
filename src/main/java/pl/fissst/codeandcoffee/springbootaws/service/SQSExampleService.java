package pl.fissst.codeandcoffee.springbootaws.service;

import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import org.springframework.stereotype.Service;
import pl.fissst.codeandcoffee.springbootaws.service.aws.AWSClients;

@Service
public class SQSExampleService {

    private final AWSClients awsClients;

    public SQSExampleService(AWSClients awsClients) {
        this.awsClients = awsClients;
    }

    public void putMessage(String queue, String message) {
        String queueUrl = getQueueUrl(queue);

        awsClients.getAmazonSQS().sendMessage(queueUrl, message);
    }

    private String getQueueUrl(String queue) {
        try {
            return awsClients.getAmazonSQS().getQueueUrl(queue).getQueueUrl();
        } catch (QueueDoesNotExistException e) {
            return awsClients.getAmazonSQS().createQueue(queue).getQueueUrl();
        }
    }
}