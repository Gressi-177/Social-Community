package com.vietdoan.api.controller;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.constants.SuccessMessage;
import com.vietdoan.api.entities.Upload;
import com.vietdoan.api.exception.InternalServerErrorException;
import com.vietdoan.api.response.ApiResponse;
import com.vietdoan.api.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DocumentController {

    final DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity uploadFiles(
            @RequestParam("files") MultipartFile[] files) {
            Collection<Upload> rs = new ArrayList<>();
        try {
            Arrays.asList(files).stream().forEach(file -> {
                Upload ent = documentService.save(file);
                rs.add(ent);
            });

            return ResponseEntity
                    .ok()
                    .body(
                            ApiResponse.success
                                    (
                                            HttpStatusCode.Ok,
                                            SuccessMessage.UPLOAD_SUCCESS.getMessage(),
                                            rs
                                    )
                    );
        } catch (Exception ex) {
            throw new InternalServerErrorException(ErrorMessage.UPLOAD_FAILED.getMessage());
        }
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws FileNotFoundException {
        Path     filePath = documentService.load(filename);
        Resource resource = new FileSystemResource(filePath);
        if (resource.exists()) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
        }
        return ResponseEntity.notFound().build();

    }
}
