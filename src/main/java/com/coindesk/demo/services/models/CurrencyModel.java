package com.coindesk.demo.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CurrencyModel {
    public String code;
    public String symbol;
    public String rate;
    public String description;

    @JsonProperty("rate_float")
    public String rate_float;        
    // Getter and Setter methods

    // public String getCode() {
    //     return code;
    // }

    // public void setCode(String code) {
    //     this.code = code;
    // }

    // public String getSymbol() {
    //     return symbol;
    // }

    // public void setSymbol(String symbol) {
    //     this.symbol = symbol;
    // }

    // public String getRate() {
    //     return rate;
    // }

    // public void setRate(String rate) {
    //     this.rate = rate;
    // }

    // public float getRateFloat() {
    //     return rateFloat;
    // }

    // public void setRateFloat(float rateFloat) {
    //     this.rateFloat = rateFloat;
    // }

    // public String getDescription() {
    //     return description;
    // }

    // public void setDescription(String description) {
    //     this.description = description;
    // }
}
