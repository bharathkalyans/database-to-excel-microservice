package com.bharathkalyans.databasetoexcel.controller;


import com.bharathkalyans.databasetoexcel.model.UserDetails;
import com.bharathkalyans.databasetoexcel.service.ExcelService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/v1/users")
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @GetMapping("/excel")
    public ResponseEntity<Resource> getUsers() {
        String fileName = "users.xlsx";

        ByteArrayInputStream data = excelService.getData();
        InputStreamResource file = new InputStreamResource(data);

        ResponseEntity<Resource> body = ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);

        return body;

    }

    //Demo End Point!
    @GetMapping("/meet")
    public ResponseEntity<UserDetails> meetUser() {
        return new ResponseEntity<UserDetails>(
                new UserDetails(
                        "Bharath", "Kalyan", "bharath@mail.com", "MALE"
                ), HttpStatusCode.valueOf(200));
    }

}
