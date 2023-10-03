package com.vietdoan.api.controller;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.entities.Document;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.response.APIResponse;
import com.vietdoan.api.service.IDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class DocumentController {

    final IDocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<APIResponse> uploadFiles(
            @RequestAttribute("userInfo") User user,
            @RequestParam("files") MultipartFile[] files) {
        try {
            List<Document> documents = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                Document document = documentService.save(file);
                document.setUser_id(user.getId());
                documents.add(document);
            });

            return ResponseEntity
                    .ok()
                    .body(
                            APIResponse
                                    .builder()
                                    .status(HttpStatusCode.Ok)
                                    .message("Upload ảnh thành công")
                                    .data(documents)
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
        Resource file = documentService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
