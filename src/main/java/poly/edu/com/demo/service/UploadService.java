package poly.edu.com.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {
    String save(MultipartFile file);
}
