package com.coindesk.demo.services;

import java.util.List;

public interface IGeneralRepository<T> {
    
    public T getById(String id);
    public List<T> getAll();
    public int insert(T model);
    public int update(T model);
    public void delete(String id);

}
