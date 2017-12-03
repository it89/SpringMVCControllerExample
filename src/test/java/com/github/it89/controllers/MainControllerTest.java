package com.github.it89.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring/servlet-context.xml")
public class MainControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void checkIsMapped() throws Exception {
        mockMvc.perform(get("/text")).andExpect(status().isOk()).andExpect(content().string("index"));
    }

    @Test
    public void checkWithEmptyParam() throws Exception {
        mockMvc.perform(get("/text?param")).andExpect(status().isOk()).andExpect(content().string("index"));
        mockMvc.perform(get("/text?param=")).andExpect(status().isOk()).andExpect(content().string("index"));
    }

    @Test
    public void checkWithParam() throws Exception {
        mockMvc.perform(get("/text?param=test")).andExpect(status().isOk()).andExpect(content().string("index (test)"));
    }

}