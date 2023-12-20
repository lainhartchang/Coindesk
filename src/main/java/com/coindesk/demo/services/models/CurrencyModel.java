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
}
