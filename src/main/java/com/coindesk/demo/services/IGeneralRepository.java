package com.coindesk.demo.services;

import java.util.List;

public interface IGeneralRepository<T> {
    
    public int getByID(String id);
    public List<T> getAll();
    public int Insert(T model);
    public int Update(T model);
    public int Delete(String id);

}
