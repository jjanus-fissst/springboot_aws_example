package pl.fissst.codeandcoffee.springbootaws.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SQSMessageExample {

    @JsonProperty("bucket")
    private String bucket;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("text")
    private String text;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}