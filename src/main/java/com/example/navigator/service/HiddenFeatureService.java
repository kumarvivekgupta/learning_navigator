package com.example.navigator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiddenFeatureService {

    @Autowired
    private RestTemplate restTemplate;

    public String getExternalData(Long number) {
        String apiUrl = "http://numbersapi.com/"+number;
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
