package com.vietdoan.api.service;

import com.vietdoan.api.entities.Upload;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface DocumentService {
    public void init();

    public Upload save(MultipartFile file);

    public Path load(String filename) throws FileNotFoundException;

    public void deleteAll();

    public Stream<Path> loadAll();
}
