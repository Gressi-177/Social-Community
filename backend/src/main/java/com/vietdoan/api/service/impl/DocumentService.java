package com.vietdoan.api.service.impl;

import com.vietdoan.api.entities.Document;
import com.vietdoan.api.repository.DocumentRepository;
import com.vietdoan.api.service.IDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DocumentService implements IDocumentService {
    private final Path root = Paths.get("D:\\uploads");

    private final DocumentRepository documentRepository;

    @Override
    public void init() {
        if (!Files.exists(root)) {
            try {
                Files.createDirectory(root);
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
    }

    @Override
    public Document save(MultipartFile file) {
        try {
            String currentTime = String.valueOf(System.currentTimeMillis());
            String filename    = currentTime + "_" + file.getOriginalFilename();

            Files.copy(file.getInputStream(), this.root.resolve(filename));

            Document ent = documentRepository.save(
                    Document
                            .builder()
                            .type01(Document.TYPE_DOCUMENT_POST)
                            .info_01(filename)
                            .info_02(root + "\\" + filename)
                            .build()
            );

            return ent;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
