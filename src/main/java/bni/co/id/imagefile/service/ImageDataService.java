package bni.co.id.imagefile.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageDataService {
    String uploadImage(MultipartFile image) throws IOException;
    byte[] downloadImage(String imageName);
}