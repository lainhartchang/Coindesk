package com.coindesk.demo.services.coindeskservice;

import com.coindesk.demo.services.models.Bitcoin;

import java.util.List;

public interface ICoindeskService {

    public String displayOriginalCoindesk();   
    
    public Bitcoin displayCUBCoindesk(String id);

    public List<Bitcoin> GetAll();

    public Bitcoin GetByID(String id);

    public int Add(Bitcoin model);

    public void Delete(String code);

    public void Update(Bitcoin bitcoin);
}
