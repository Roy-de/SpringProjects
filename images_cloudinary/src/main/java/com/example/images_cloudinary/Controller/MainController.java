package com.example.images_cloudinary.Controller;

import com.example.images_cloudinary.Dto.ImageDto;
import com.example.images_cloudinary.ImageService.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
@Slf4j
public class MainController {
    private final ImageService imageService;

    public MainController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/images")
    public ResponseEntity<String> uploadImages( @RequestParam("files") MultipartFile[] files) {

        List<ImageDto> uploadedImages = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                ImageDto image = imageService.uploadImage(file);
                log.info("Image: {}",image.getPublic_id());
                log.info("Image: {}",image.getSecure_url());
                uploadedImages.add(image);
            }

            return ResponseEntity.ok("success");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed.");
        }
    }
}
