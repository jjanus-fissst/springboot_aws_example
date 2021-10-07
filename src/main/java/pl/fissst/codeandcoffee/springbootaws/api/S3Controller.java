package pl.fissst.codeandcoffee.springbootaws.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.fissst.codeandcoffee.springbootaws.service.S3ExampleService;

@RestController
public class S3Controller {

    private final S3ExampleService s3ExampleService;

    public S3Controller(S3ExampleService s3ExampleService) {
        this.s3ExampleService = s3ExampleService;
    }

    @GetMapping(value = "/s3/create")
    public String createFile(@RequestParam String bucket, @RequestParam String fileName, @RequestParam String content) {
        s3ExampleService.createFile(bucket, fileName, content);

        return "done";
    }
}