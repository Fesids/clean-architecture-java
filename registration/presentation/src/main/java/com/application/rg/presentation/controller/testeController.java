package com.application.rg.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class testeController {


    @GetMapping
    public String teste(){
        return "working";
    }

    @GetMapping("/teste2")
    public String teste2(){
        return "teste 2";
    }

}
