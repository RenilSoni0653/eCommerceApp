package com.humber.orderservice.serviceClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "User", url = "http://localhost:8811/")
public interface UserClient {
}
