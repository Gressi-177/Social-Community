package com.vietdoan.api.service.impl;

import com.vietdoan.api.entities.Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements com.vietdoan.api.service.DocumentService {
    private final String uploadDir = "D:\\uploads";
    private final Path   root      = Paths.get(uploadDir);

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
    public Upload save(MultipartFile file) {
        try {
            String currentTime = String.valueOf(System.currentTimeMillis());
            String filename    = currentTime + "_" + file.getOriginalFilename();

            Files.copy(file.getInputStream(), this.root.resolve(filename));

            Upload ent = Upload
                    .builder()
                    .name(filename)
                    .url(root + "\\" + filename)
                    .build();

            return ent;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Path load(String filename) {
        Path file = root.resolve(filename);
        return file;
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
