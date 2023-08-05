package com.friends.sickseek.shared.feign.azure;


import com.friends.sickseek.shared.feign.azure.dto.request.UrlRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "azure", url = "https://sickseekfriends.cognitiveservices.azure.com/")
public interface AzureController {

    @PostMapping("/face/v1.0/detect?returnFaceId=true")
    void detectFace(
            @RequestHeader("Ocp-Apim-Subscription-Key") String key,
            @RequestBody UrlRequest request
    );
}
