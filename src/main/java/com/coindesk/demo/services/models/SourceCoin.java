package com.coindesk.demo.services.models;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class SourceCoin {
    private CoinTime time;
    private String disclaimer;
    private String chartName;
    private Bpi bpi;  
}

// Inner class representing the "bpi" field

