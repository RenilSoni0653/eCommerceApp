package com.humber.imageservice.controller;

import com.humber.imageservice.model.Image;
import com.humber.imageservice.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/addImage")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        System.out.println(">>>>>>>>>>>>>"+file.isEmpty());
        String response = imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/info/{Id}")
    public ResponseEntity<Image>  getImageInfoById(@PathVariable(name = "Id") Long id){
        Image image = imageService.getInfoByImageById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]>  getImageById(@PathVariable(name = "id") Long id){
        byte[] image = imageService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}
