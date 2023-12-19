package com.coindesk.demo.services.models;

// import scala.collection.concurrent.Map;
// import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class SourceCoin {
    private CoinTime time;
    private String disclaimer;
    private String chartName;
    private Bpi bpi;

    // Getter and Setter methods
    // public List<CurrencyModel> getBpi() {
    //     return bpi;
    // }

    // public void setBpi(List<CurrencyModel> bpi) {
    //     this.bpi = bpi;
    // }    
}

// Inner class representing the "bpi" field

