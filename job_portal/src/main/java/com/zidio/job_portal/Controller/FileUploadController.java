package com.zidio.job_portal.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zidio.job_portal.Service.FileUploadService;

@RestController
@RequestMapping("api/uploadFiles")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/resume")
    public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file) throws IOException {
        String resumeUrl = fileUploadService.uploadFile(file, "resume");
        return ResponseEntity.ok(resumeUrl);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            fileUploadService.validateAndProcessImage(file); // validation
            String imageUrl = fileUploadService.uploadFile(file, "images"); // upload
            return ResponseEntity.ok(imageUrl); // return actual URL
        } catch (IllegalArgumentException | IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/invoice")
    public ResponseEntity<String> uploadInvoice(@RequestParam("file") MultipartFile file) throws IOException {
        String invoiceUrl = fileUploadService.uploadFile(file, "invoice");
        return ResponseEntity.ok(invoiceUrl);
    }
}
