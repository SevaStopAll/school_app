package ru.sevastopall.school_app.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ReportSender {

    public ResponseEntity<byte[]> sendReport() {
        byte[] content = new byte[0];
        try {
            content = Files.readAllBytes(Path.of("./src/main/resources/data/report.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders headers = new HttpHeaders();
        String filename = "Report.xlsx";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        headers.setContentType(MediaType.parseMediaType("application/xlsx"));
        return new ResponseEntity<>(content,headers, HttpStatus.OK);
        }
}
