package com.fileupload.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class UploadService {

    ResponseMessageDTO messageResponseMessage;

    public UploadService(ResponseMessageDTO messageResponseMessage) {
        this.messageResponseMessage = messageResponseMessage;
    }

    public ResponseMessageDTO execute(MultipartFile file) throws Exception {

        try {
            Thread.sleep(2000);
            DocumentBuilder dbBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = dbBuilder.parse(file.getInputStream());
            NodeList codes = document.getElementsByTagName("codigo");
            printCodeFile(codes);
            messageResponseMessage.setContent("Uploaded successfully!");
        } catch (Exception exp) {
            messageResponseMessage.setContent("Error upload files!");
        }

        return messageResponseMessage;
    }

    private void printCodeFile(NodeList codes) {
        for (int control = 0; control < codes.getLength(); control++) {
            Node node = codes.item(control);
            System.out.println(node.getTextContent());
        }
    }

}