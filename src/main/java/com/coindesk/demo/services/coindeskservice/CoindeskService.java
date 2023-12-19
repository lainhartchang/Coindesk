package com.coindesk.demo.services.coindeskservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coindesk.demo.services.models.Bitcoin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;

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

                // Convert the JSON response to an object using Gson
                // Gson gson = new Gson();
                // JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

                // Use the jsonObject as needed
                // ...
                return response.toString();
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Get data fail.";
    }    
}
