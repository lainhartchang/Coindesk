package com.coindesk.demo.services.models;

import org.w3c.dom.UserDataHandler;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.List;

@Data
@Accessors(chain = true)
public class Bpi {
    public CurrencyModel USD;        
    public CurrencyModel GBP;
    public CurrencyModel EUR;
}
