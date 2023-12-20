package com.coindesk.demo.services.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name="Bitcoin")
@Accessors(chain = true)
public class Bitcoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
    @Column(name="id")
    private int Id;

    @Column(name="code")
    private String Code;
    
    @Column(name="codecname")
    private String Codecname;
    
    @Column(name="symbol")
    private String Symbol;
    
    @Column(name="rate")
    private String Rate; 

    @Column(name="description")
    private String Description;
    
    @Column(name="ratefloat")
    //private BigDecimal Ratefloat;
    private String Ratefloat;

    @Column(name="updated")
    private String Updated;
    
    @Column(name="updatediso")
    private String UpdatedISO;

    @Column(name="updateduk")
    private String Updateduk;

    @Column(name="updatedtw")
    private String Updatedtw;
    
    @Column(name="createdate")
    private Long Createdate;

    @Column(name="moddate")
    private Long Moddate;    
}
