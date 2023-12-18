package com.coindesk.demo.services.coindeskservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coindesk.demo.services.models.Bitcoin;

@Service
public final class CoindeskService implements ICoindeskService {

    private ICoindeskRepository _coindeskRepository;
    
    public CoindeskService()    {
        
    }

    @Autowired
    public CoindeskService(ICoindeskRepository _coindeskRepository)   {
        this._coindeskRepository = _coindeskRepository;        
    }

    @Override
    public String displayOriginalCoindesk() {

        return "Original Coindesk";
    }    
    
    @Override
    public String displayCUBCoindesk()  {
        return "CUB Coindesk";
    }

    @Override
    public List<Bitcoin> GetAll()   {        
        return null;
    }

    @Override
    public Bitcoin GetByID(String id)   {
        return null;
    }

    @Override
    public int AddCoin(Bitcoin model)   {
        return 0;
    }

    @Override
    public int Delete(String code)  {
        return 0;
    }
    
}
