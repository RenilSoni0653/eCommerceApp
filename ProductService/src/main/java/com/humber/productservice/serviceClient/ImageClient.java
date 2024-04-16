package com.humber.productservice.serviceClient;

import com.humber.productservice.entity.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("image-service")
public interface ImageClient {
    @GetMapping("/image/getImage/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable(value = "id") Long id);

    @GetMapping("/image/info/{Id}")
    public ResponseEntity<Image>  getImageInfoById(@PathVariable(value = "Id") Long id);
}
