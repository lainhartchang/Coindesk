package com.coindesk.demo.services.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CoinTime {
    public String updated;
    public String updatedISO;
    public String updateduk;
}
