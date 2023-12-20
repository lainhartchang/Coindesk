package com.coindesk.demo.services.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CUBCoin {
    public String Code;
    public String CodeCname;
    public String Rate;
    public String UpdateTW;
}
