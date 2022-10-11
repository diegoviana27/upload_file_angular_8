package com.fileupload.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.service.ResponseMessageDTO;
import com.fileupload.service.UploadService;

@Controller
@CrossOrigin("http://localhost:4200")
public class UploadController {

  private final UploadService serviceUploadService;

  private ResponseMessageDTO responseMessage;

  public UploadController(UploadService serviceUploadService, ResponseMessageDTO responseMessage) {
    this.serviceUploadService = serviceUploadService;
    this.responseMessage = responseMessage;
  }

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessageDTO> uploadFiles(@RequestParam("file") MultipartFile file) {
        
    try {      
      responseMessage = serviceUploadService.execute(file);
      return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    } catch (Exception e) {
      responseMessage.setContent(e.getMessage());
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responseMessage);
    }
    
  }

}