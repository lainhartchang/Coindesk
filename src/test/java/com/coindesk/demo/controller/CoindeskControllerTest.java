package com.coindesk.demo.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.beans.factory.annotation.Autowired;



@AutoConfigureMockMvc
@SpringBootTest(classes = { CoindeskController.class })
public class CoindeskControllerTest {

    @Autowired
    private MockMvc mockMvc;    

    @Before(value = "")
    public void setUp() throws Exception {
       System.out.println("---------------start---------------");
       testHello();
       System.out.println("================end================");
    }
    
    @Test
    void testHello() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/hello"));
        
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}
