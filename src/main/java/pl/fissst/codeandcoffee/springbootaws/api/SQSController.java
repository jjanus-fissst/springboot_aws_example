package pl.fissst.codeandcoffee.springbootaws.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.fissst.codeandcoffee.springbootaws.service.SQSExampleService;

@RestController
public class SQSController {

    private final SQSExampleService sqsExampleService;

    public SQSController(SQSExampleService sqsExampleService) {
        this.sqsExampleService = sqsExampleService;
    }

    @GetMapping(value = "/sqs/create")
    public String putMessage(@RequestParam String queue, @RequestParam String message) {
        sqsExampleService.putMessage(queue, message);

        return "done";
    }
}
