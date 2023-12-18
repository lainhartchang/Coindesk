package com.coindesk.demo.services.coindeskservice;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coindesk.demo.services.models.Bitcoin;

@Repository
public class CoindeskRepository implements ICoindeskRepository{

    public CoindeskRepository()    {
        
    }

    public int getByID(String id) {
        return 0;
    }

    public List<Bitcoin> getAll() {
        return null;
    }

    public int Insert(Bitcoin model)    {
        return 0;
    }

    public int Update(Bitcoin model)    {
        return 0;
    }
    

    public int Delete(String id)    {
        return 0;
    }

}
