package com.coindesk.demo.services.coindeskservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coindesk.demo.services.models.Bitcoin;
import com.coindesk.demo.services.models.SourceCoin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigInteger;
import java.util.List;
import java.net.URL;
import java.lang.Long;


//import com.google.gson.Gson;
//import com.google.gson.JsonObject;

@Service
public final class CoindeskService implements ICoindeskService {

    private ICoindeskRepository _coindeskRepository;

    private List<Bitcoin> _bitcoinList;
    
    public CoindeskService()    {
        
    }

    @Autowired
    public CoindeskService(ICoindeskRepository _coindeskRepository)   {
        this._coindeskRepository = _coindeskRepository;        
    }

    @Override
    public String displayOriginalCoindesk() {

        return CallCoinDeskAPI();
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
        _coindeskRepository.getById("EUR");
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

    private String CallCoinDeskAPI() {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                //StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                _bitcoinList = JsonParserObject(response.toString());
                 
                // Use the jsonObject as needed                
                return response.toString();
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Get data fail.";
    }    

    private List<Bitcoin> JsonParserObject(String response) {
        // Convert the JSON response to an object using Gson
        Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, (JsonDeserializer<Double>) (jsonElement, typeOfT, ctx) -> {
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                return jsonElement.getAsDouble();
            } else if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                String stringValue = jsonElement.getAsString();
                try {
                    return Double.parseDouble(stringValue);
                } catch (NumberFormatException e) {
                    return null; 
                }
            }
            return null; 
        }).create();
        SourceCoin sourceCoinObj = gson.fromJson(response.toString(), SourceCoin.class);
        return SourceCoinToBitcoin(sourceCoinObj);
    }

    private List<Bitcoin> SourceCoinToBitcoin(SourceCoin sourceCoin) {
        List<Bitcoin> bitcoinList = new ArrayList<Bitcoin>();
        int count = 3;
        for (int i = 0; i < count; i++) {
            Bitcoin bitcoin = new Bitcoin();
            bitcoin.setUpdated(sourceCoin.getTime().getUpdated());
            bitcoin.setUpdatedISO(sourceCoin.getTime().getUpdatedISO());
            bitcoin.setUpdateduk(sourceCoin.getTime().getUpdateduk());
            bitcoin.setCreatedate(GetDate());
            bitcoin.setModdate(GetDate());

            if (i == 0) {
                bitcoin.setCode(sourceCoin.getBpi().getUSD().getCode());
                bitcoin.setSymbol(sourceCoin.getBpi().getUSD().getSymbol());
                bitcoin.setRate(sourceCoin.getBpi().getUSD().getRate());
                bitcoin.setDescription(sourceCoin.getBpi().getUSD().getDescription());
                bitcoin.setRatefloat(new BigDecimal(sourceCoin.getBpi().getUSD().getRate_float()));
                bitcoin.setCodecname(localization(sourceCoin.getBpi().getUSD().getCode()));
            } else if (i == 1) {
                bitcoin.setCode(sourceCoin.getBpi().getGBP().getCode());
                bitcoin.setSymbol(sourceCoin.getBpi().getGBP().getSymbol());
                bitcoin.setRate(sourceCoin.getBpi().getGBP().getRate());
                bitcoin.setDescription(sourceCoin.getBpi().getGBP().getDescription());
                bitcoin.setRatefloat(new BigDecimal(sourceCoin.getBpi().getGBP().getRate_float()));
                bitcoin.setCodecname(localization(sourceCoin.getBpi().getGBP().getCode()));
            } else if (i == 2) {
                bitcoin.setCode(sourceCoin.getBpi().getEUR().getCode());
                bitcoin.setSymbol(sourceCoin.getBpi().getEUR().getSymbol());
                bitcoin.setRate(sourceCoin.getBpi().getEUR().getRate());
                bitcoin.setDescription(sourceCoin.getBpi().getEUR().getDescription());
                bitcoin.setRatefloat(new BigDecimal(sourceCoin.getBpi().getEUR().getRate_float()));
                bitcoin.setCodecname(localization(sourceCoin.getBpi().getEUR().getCode()));
            }
            
            bitcoinList.add(bitcoin);
        }

        return bitcoinList;
    }

    private Long GetDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String formattedDateTime = now.format(formatter);
        return Long.parseLong(formattedDateTime);          
    }

    private String localization(String response) {
        switch (response) {
            case "USD":
                return "美金";                
            case "GBP":
                return "英鎊";
            case "EUR":               
                return "歐元";                
            default:
                return response;
        }
    }
}
