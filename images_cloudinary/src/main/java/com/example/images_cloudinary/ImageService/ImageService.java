package com.example.images_cloudinary.ImageService;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.images_cloudinary.Dto.ImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {

    private final Cloudinary cloudinary;
    @Autowired
    public ImageService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    public ImageDto uploadImage(MultipartFile images) throws IOException {
        Map<?,?> uploadResult = cloudinary.uploader().upload(images.getBytes(), ObjectUtils.emptyMap());
        String publicId = uploadResult.get("public_id").toString();
        String imageUrl = uploadResult.get("secure_url").toString();
        return new ImageDto(publicId,imageUrl);
    }
}
