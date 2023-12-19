package com.coindesk.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coindesk.demo.services.coindeskservice.ICoindeskService;
import com.coindesk.demo.services.models.Bitcoin;
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

    @GetMapping("/display/coindesk")
    @RequestMapping(value = "/display/coindesk", method = RequestMethod.GET, produces = "application/json")    
    //@ResponseBody
    public String DisplayCoindesk() {
        
        return _coindeskService.displayOriginalCoindesk();
    }

    @GetMapping("/cubcoin/{id}")
    @RequestMapping(value = "/cubcoin/{id}", method = RequestMethod.GET, produces = "application/json")    
    //@ResponseBody
    public Bitcoin DisplayCUBCoin(@PathVariable("id") String id) {
        
        Bitcoin bitcoin = _coindeskService.GetByID(id);
        return bitcoin;
    }

    @DeleteMapping("/cubcoin/{id}")
    @RequestMapping(value = "/cubcoin/{id}", method = RequestMethod.DELETE, produces = "application/json")    
    //@ResponseBody
    public void DeleteCUBCoin(@PathVariable("id") String id) {
                
        _coindeskService.Delete(id);
    }
}
