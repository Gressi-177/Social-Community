package com.vietdoan.api.service.impl;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.entities.Upload;
import com.vietdoan.api.exception.CustomIOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements com.vietdoan.api.service.DocumentService {
    private final String uploadDir = "uploads";
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
        } catch (IOException e) {
            throw new CustomIOException(ErrorMessage.FAILED_TO_SAVE_FILE.getMessage());
        }
    }

    @Override
    public Path load(String filename) throws FileNotFoundException {
        Path file = root.resolve(filename);
        if (!Files.exists(file)) {
            throw new FileNotFoundException("File not found: " + filename);
        }
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
