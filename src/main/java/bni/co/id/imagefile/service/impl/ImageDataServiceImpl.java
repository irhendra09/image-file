package bni.co.id.imagefile.service.impl;

import bni.co.id.imagefile.model.ImageData;
import bni.co.id.imagefile.repository.ImageRepository;
import bni.co.id.imagefile.service.ImageDataService;
import bni.co.id.imagefile.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageDataServiceImpl implements ImageDataService {
    private final ImageRepository imageRepository;

    @Override
    public String uploadImage(MultipartFile image) throws IOException {
        ImageData imageData = imageRepository.save(ImageData.builder()
                .name(image.getOriginalFilename())
                .type(image.getContentType())
                .imageData(ImageUtils.compressImage(image.getBytes())).build());
        return "file uploaded successfully :" + imageData.getName();
    }

    @Override
    public byte[] downloadImage(String imageName) {
        Optional<ImageData> dbImageData = imageRepository.findByName(imageName);
        return ImageUtils.decompressImage(dbImageData.get().getImageData());
    }
}
