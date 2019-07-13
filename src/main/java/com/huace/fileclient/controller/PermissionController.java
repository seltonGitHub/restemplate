package com.huace.fileclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("hc")
public class PermissionController {


    @GetMapping("gettoken")
    public ResponseEntity getMytoken() {
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url = "http://192.168.1.137:8000/authentication/v1/authenticate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "11111111111111111111111111111");
        map.add("client_secret", "222222222222222222");
        map.add("grant_type", "client_credentials");
        map.add("scope", "data:read data:write data:create data:search bucket:create bucket:read bucket:update bucket:delete");

        HttpEntity<MultiValueMap<String, String>> requestMess = new HttpEntity<>(map, headers);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, requestMess, String.class);
        return stringResponseEntity;
    }
}
