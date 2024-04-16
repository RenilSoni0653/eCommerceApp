package com.humber.imageservice.service;

import com.humber.imageservice.exception.ImageNotFoundException;
import com.humber.imageservice.exception.UnableToSaveImageException;
import com.humber.imageservice.model.Image;
import com.humber.imageservice.repository.ImageRepository;
import com.humber.imageservice.utils.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        System.out.println(">>!"+file.getSize());
        try{
            imageRepository.save(Image.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .imageData(ImageUtil.compressImage(file.getBytes())).build());
        }catch (Exception ex){
            throw new UnableToSaveImageException("Unable to save Image.Please try again later");
        }
        return "Image uploaded successfully: " +
                file.getOriginalFilename();
    }

    public Image getInfoByImageById(Long id) {
        Optional<Image> dbImage = imageRepository.findByImageId(id);
        System.out.println(">>>>>>>>>1111"+dbImage.isPresent());
        if(dbImage.isPresent()){
            return dbImage.get();
        }else{
            throw new ImageNotFoundException("Unable to find the image.");
        }

    }

    public byte[] getImage(Long id) {
        Optional<Image> dbImage = imageRepository.findByImageId(id);
        if(dbImage.isPresent()){
            byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
            return image;
        }else{
            throw new ImageNotFoundException("Unable to find the image.");
        }
    }
}
