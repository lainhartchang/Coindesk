package com.coindesk.demo.services.coindeskservice;

import com.coindesk.demo.services.models.Bitcoin;

import java.util.List;

public interface ICoindeskService /*extends IGeneralRepository<Bitcoin>*/{

    public String displayOriginalCoindesk();   
    
    public String displayCUBCoindesk();

    public List<Bitcoin> GetAll();

    public Bitcoin GetByID(String id);

    public int AddCoin(Bitcoin model);

    public int Delete(String code);
}
