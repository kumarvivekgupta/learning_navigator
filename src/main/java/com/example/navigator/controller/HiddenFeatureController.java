package com.example.navigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.navigator.service.HiddenFeatureService;

@RestController
@RequestMapping("/hidden-feature")
public class HiddenFeatureController {

    @Autowired
private HiddenFeatureService hiddenFeatureService;    
    @GetMapping("/{number}")
    public String getNumberFeature(@PathVariable("number") Long number){
         return    hiddenFeatureService.getExternalData(number);
    }
    
}
