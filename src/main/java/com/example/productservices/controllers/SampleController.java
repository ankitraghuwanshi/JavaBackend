package com.example.productservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class SampleController {

    @GetMapping("/hello/{numberOfTimes}")
    public String sayhello(@PathVariable("numberOfTimes") int b){
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<b; i++){
            sb.append("hello ");
        }
        return sb.toString();
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "bye everyone!!";
    }
}
