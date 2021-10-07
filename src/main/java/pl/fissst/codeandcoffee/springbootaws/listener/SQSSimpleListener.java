package pl.fissst.codeandcoffee.springbootaws.listener;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import pl.fissst.codeandcoffee.springbootaws.dto.SQSMessageExample;
import pl.fissst.codeandcoffee.springbootaws.service.S3ExampleService;

@Component
public class SQSSimpleListener {

    private final S3ExampleService s3ExampleService;

    public SQSSimpleListener(S3ExampleService s3ExampleService) {
        this.s3ExampleService = s3ExampleService;
    }

    @SqsListener("sqs-example-codeAndCoffee")
    public void queueListener(SQSMessageExample sqsMessageExample) {
        s3ExampleService.createFile(sqsMessageExample.getBucket(), sqsMessageExample.getFileName(), sqsMessageExample.getText());
    }
}