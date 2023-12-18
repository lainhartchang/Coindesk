package com.coindesk.demo.services.models;

// import java.math.BigDecimal;
// import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import java.text.SimpleDateFormat;
// import java.time.LocalDateTime;
// import java.sql.Time;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.time.LocalDateTime;

@Entity
@Table(name="Bitcoin")
public class Bitcoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    

    @Column(name="code")
    private String Code;
    
    @Column(name="codecname")
    private String Codecname;
    
    @Column(name="symbol")
    private String Symbol;
    
    @Column(name="rate")
    private Double Rate; 

    @Column(name="description")
    private String Description;
    
    @Column(name="ratefloat")
    private Double Ratefloat;

    @Column(name="updated")
    private String Updated;
    
    @Column(name="updatediso")
    private String UpdatedISO;

    @Column(name="updateduk")
    private String Updateduk;
    
    @Column(name="createdate")
    private Long Createdate;

    @Column(name="moddate")
    private Long Moddate;

    //Consructor
    public Bitcoin() {
        /*TODO Auto-generated constructor stub*/
    }
    
    //Getters and Setters
    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
    
    public String getCodecname() {
        return Codecname;
    }

    public void setCodecname(String codecname) {
        Codecname = codecname;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }   

    public Double getRate() {
        return Rate;
    }

    public void setRate(Double rate) {
        Rate = rate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }   

    public Double getRatefloat() {
        return Ratefloat;
    }

    public void setRatefloat(Double ratefloat) {
        Ratefloat = ratefloat;
    }

    public String getUpdated() {
        return Updated;
    }

    public void setUpdated(String updated) {
        Updated = updated;
    }

    public String getUpdatedISO() {
        return UpdatedISO;
    }

    public void setUpdatedISO(String updatedISO) {
        UpdatedISO = updatedISO;
    }

    public String getUpdateduk() {
        return Updateduk;
    }

    public void setUpdateduk(String updateduk) {
        Updateduk = updateduk;
    }

    public Long getCreatedate(Long Createdate) {        
        return Createdate;
    }

    public void setCreatedate(Long createdate) {
        Createdate = createdate;
    }

    public Long getModdate(Long Moddate) {
        return Moddate;
    }

    public void setModdate(Long moddate) {
        Moddate = moddate;
    }    
    
}
