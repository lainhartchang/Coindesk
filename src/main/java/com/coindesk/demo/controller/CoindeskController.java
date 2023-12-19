package com.coindesk.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coindesk.demo.services.coindeskservice.ICoindeskService;
@RestController
public class CoindeskController {

    private ICoindeskService _coindeskService;

    @Autowired
    public CoindeskController(ICoindeskService coindeskService) {
        _coindeskService = coindeskService;
    }

    @GetMapping("/hello")
    public String Hello() {
        return "Hellooo";
    }

    @GetMapping("/getcoindesk")
    @RequestMapping(value = "/displaycoindesk", method = RequestMethod.GET, produces = "application/json")    
    //@ResponseBody
    public String DisplayCoindesk() {
        
        return _coindeskService.displayOriginalCoindesk();
    }
}
