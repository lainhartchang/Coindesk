package com.coindesk.demo.services.models;

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
import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name="Bitcoin")
@Accessors(chain = true)
public class Bitcoin {
    
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
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
    private BigDecimal Ratefloat;

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
}
