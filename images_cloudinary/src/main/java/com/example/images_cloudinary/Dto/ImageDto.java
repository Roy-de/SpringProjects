package com.example.images_cloudinary.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageDto {
    private String public_id;
    private String secure_url;
}
