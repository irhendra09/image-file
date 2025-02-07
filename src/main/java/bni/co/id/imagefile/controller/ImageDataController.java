package bni.co.id.imagefile.controller;

import bni.co.id.imagefile.service.ImageDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageDataController {
    private final ImageDataService imageDataService;

    public ImageDataController(ImageDataService imageDataService) {
        this.imageDataService = imageDataService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadImage = imageDataService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<?> getImage(@PathVariable String filename) {
        byte[] imageData = imageDataService.downloadImage(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
