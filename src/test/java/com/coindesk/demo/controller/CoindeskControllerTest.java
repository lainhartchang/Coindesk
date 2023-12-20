package com.coindesk.demo.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import com.coindesk.demo.services.models.Bitcoin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
@AutoConfigureMockMvc
public class CoindeskControllerTest {

    @Autowired
    private MockMvc mockMvc;    

    @Test
    public void TestDisplayCoindesk() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/display/coindesk"));
        
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void TestDisplayCUBCoin() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/display/cubcoin/1"));
        
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void TestGetCUBCoin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/display/coindesk"));
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/cubcoin/1"));
        
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void TestGetAllCUBCoin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/display/coindesk"));
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/cubcoin"));
        
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void TestPostCUBCoin() throws Exception {
        // Perform the POST request to insert the Bitcoin object
        mockMvc.perform(MockMvcRequestBuilders.get("/api/display/coindesk"));
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/cubcoin")
            .contentType(MediaType.APPLICATION_PROBLEM_JSON_VALUE)
            .content(new ObjectMapper().writeValueAsString(TestBitcoin())));

        // Verify the response
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void TestPutCUBCoin() throws Exception {
        // Perform the PUT request to update the Bitcoin object
        mockMvc.perform(MockMvcRequestBuilders.get("/api/display/coindesk"));
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put("/api/cubcoin")
            .contentType(MediaType.APPLICATION_PROBLEM_JSON_VALUE)
            .content(new ObjectMapper().writeValueAsString(TestBitcoin())));

        // Verify the response
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void DeleteCUBCoin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/display/coindesk"));
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.delete("/api/cubcoin/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString("1")));

        // Verify the response
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    private Bitcoin TestBitcoin()  {
        Bitcoin testCoin = new Bitcoin();  
        testCoin.setId(1);      
        testCoin.setCode("NTD");
        testCoin.setCodecname("新台幣");
        testCoin.setDescription("Cathay United Bank No1.");
        testCoin.setRate("42,893.0111");
        testCoin.setRatefloat("42893.0111");
        testCoin.setSymbol("$");
        testCoin.setUpdated("Dec 20, 2023 07:20:00 UTC");
        testCoin.setUpdatedISO("2023-12-20T07:20:00+00:00");
        testCoin.setUpdateduk("Dec 20, 2023 at 07:20 GMT");
        testCoin.setUpdatedtw("2023/12/20 07:20:00:00");
        testCoin.setCreatedate(20231220072000L);
        testCoin.setModdate(20231220072000L);
        
        return testCoin;
    }
}
