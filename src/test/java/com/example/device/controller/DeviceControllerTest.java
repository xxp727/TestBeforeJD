package com.example.device.controller;

import com.example.device.domain.Device;
import com.example.device.util.JsonUtil;
import javafx.beans.binding.ObjectExpression;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DeviceControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void getDeviceList() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/device")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getDeviceById() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/device/2")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void updateDeviceById() throws Exception{
        Device device = new Device(2,"updateName","updateType","updateDescription","updateSerial");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.
                post("/device/2").
                contentType(MediaType.APPLICATION_JSON).content(JsonUtil.ObjectToJson(device))).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void addDevice() throws Exception{
        Device device = new Device(null,"newName","newType","newDescription","newSerial");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.
                put("/device").
                contentType(MediaType.APPLICATION_JSON).content(JsonUtil.ObjectToJson(device))).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deleteDevice() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/device/2")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getDeviceByName() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/device/name/new")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}