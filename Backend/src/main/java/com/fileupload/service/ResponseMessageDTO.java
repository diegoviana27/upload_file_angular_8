package com.fileupload.service;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessageDTO {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}