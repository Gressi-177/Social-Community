package com.vietdoan.api.controller;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.entities.Document;
import com.vietdoan.api.entities.Upload;
import com.vietdoan.api.response.APIResponse;
import com.vietdoan.api.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DocumentController {

    final DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<APIResponse> uploadFiles(
            @RequestParam("files") MultipartFile[] files) {
        try {
            Collection<Upload> rs = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                Upload ent = documentService.save(file);
                rs.add(ent);
            });

            return ResponseEntity
                    .ok()
                    .body(
                            APIResponse
                                    .builder()
                                    .status(HttpStatusCode.Ok)
                                    .message("Upload ảnh thành công")
                                    .data(rs)
                                    .build()
                    );
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(
                            APIResponse
                                    .builder()
                                    .message(e.getMessage())
                                    .build()
                    );
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<Document>> getListFiles() {
        List<Document> fileInfos = documentService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(DocumentController.class, "getFile", path.getFileName().toString()).build().toString();

            return Document
                    .builder()
                    .info_01(filename)
                    .info_02(url)
                    .build();
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Path     filePath = documentService.load(filename);
        Resource resource = new FileSystemResource(filePath);
        if (resource.exists()) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
        }
        return ResponseEntity.notFound().build();

    }
}
