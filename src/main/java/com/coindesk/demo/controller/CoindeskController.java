package com.coindesk.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CoindeskController {
    @GetMapping("/hello")
    public String Hello() {
        return "Hellooo";
    }
}
