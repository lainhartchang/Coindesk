package com.coindesk.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.coindesk.demo.services.coindeskservice.ICoindeskService;
import com.coindesk.demo.services.models.Bitcoin;
import com.coindesk.demo.services.models.CUBCoin;

//import org.hibernate.mapping.List;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoindeskController {

    private ICoindeskService _coindeskService;
    
    public CoindeskController(ICoindeskService coindeskService) {
        _coindeskService = coindeskService;
    }

    @GetMapping("/hello")
    public String Hello() {
        return "Hellooo";
    }
    
    @ResponseBody
    @RequestMapping(value = "/display/coindesk", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> DisplayCoindesk() {
        try {
            String responseString = _coindeskService.displayOriginalCoindesk();
            return ResponseEntity.ok().body(responseString);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while displaying Coindesk.");
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/display/cubcoin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)        
    public ResponseEntity<CUBCoin> DisplayCUBCoin(@PathVariable("id") String id) {
        try {
            Bitcoin bitcoin = _coindeskService.GetByID(id);
            CUBCoin cubcoin = new CUBCoin();
            cubcoin.Code = bitcoin.getCode();
            cubcoin.CodeCname = bitcoin.getCodecname();
            cubcoin.Rate = bitcoin.getRate();
            cubcoin.UpdateTW = bitcoin.getUpdatedtw();
            return ResponseEntity.ok().body(cubcoin);
        } catch (Exception e) {            
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cubcoin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)    
    public ResponseEntity<?> GetCUBCoin(@PathVariable("id") String id) {
        try {
            Bitcoin bitcoin = _coindeskService.GetByID(id);               
            return ResponseEntity.ok().body(bitcoin);
        } catch (Exception e) {            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error occurred");
        }
    }    

    @ResponseBody
    @RequestMapping(value = "/cubcoin", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)    
    public ResponseEntity<?> GetAllCUBCoin() {
        try {
            List<Bitcoin> bitcoinList = _coindeskService.GetAll();            
            return ResponseEntity.ok().body(bitcoinList);
        } catch (Exception e) {            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error occurred");
        }
    }    
    
    @RequestMapping(value = "/cubcoin", method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)    
    @ResponseBody
    public ResponseEntity<?> PostCUBCoin(@RequestBody Bitcoin request) {
               
        Bitcoin bitcoin = new Bitcoin();
        bitcoin.setId(request.getId());
        bitcoin.setCode(request.getCode());
        bitcoin.setCodecname(request.getCodecname());
        bitcoin.setSymbol(request.getSymbol()); 
        bitcoin.setRate(request.getRate());
        bitcoin.setDescription(request.getDescription());
        bitcoin.setRatefloat(request.getRatefloat());
        bitcoin.setUpdated(request.getUpdated());
        bitcoin.setUpdatedISO(request.getUpdatedISO());
        bitcoin.setUpdateduk(request.getUpdateduk());
        bitcoin.setUpdatedtw(request.getUpdatedtw());
        bitcoin.setCreatedate(request.getCreatedate());
        bitcoin.setModdate(request.getModdate());     

        try {
            _coindeskService.Add(bitcoin);
            Bitcoin feedbackCoin = _coindeskService.GetByID(String.valueOf(request.getId()));
            return ResponseEntity.status(HttpStatus.OK).body(feedbackCoin);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error occurred");
        }
    }
    
    @RequestMapping(value = "/cubcoin", method = RequestMethod.PUT, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)    
    @ResponseBody
    public ResponseEntity<?> PutCUBCoin(@RequestBody Bitcoin request) {
               
        Bitcoin bitcoin = new Bitcoin();
        bitcoin.setId(request.getId());
        bitcoin.setCode(request.getCode());
        bitcoin.setCodecname(request.getCodecname());
        bitcoin.setSymbol(request.getSymbol()); 
        bitcoin.setRate(request.getRate());
        bitcoin.setDescription(request.getDescription());
        bitcoin.setRatefloat(request.getRatefloat());
        bitcoin.setUpdated(request.getUpdated());
        bitcoin.setUpdatedISO(request.getUpdatedISO());
        bitcoin.setUpdateduk(request.getUpdateduk());
        bitcoin.setUpdatedtw(request.getUpdatedtw());
        bitcoin.setCreatedate(request.getCreatedate());
        bitcoin.setModdate(request.getModdate());     

        try {
            _coindeskService.Update(bitcoin);
            return ResponseEntity.status(HttpStatus.OK).body("Update successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error occurred");
        }
    }
    
    @RequestMapping(value = "/cubcoin/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)    
    @ResponseBody
    public ResponseEntity<String> DeleteCUBCoin(@PathVariable("id") String id) {
        try {
            _coindeskService.Delete(id);
            return ResponseEntity.ok().body("Deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while deleting Coindesk.");
        }                
    }
}
