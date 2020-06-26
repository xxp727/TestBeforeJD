package com.example.device.integration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.device.domain.Device;
import com.example.device.domain.RespBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private void getDeviceById() {
        Device expectDevice = new Device(1,"Name1","Type1","Description1","Serial1");
        String result = restTemplate.getForObject("/device/1",String.class);

        RespBean respBean = JSON.parseObject(result,new TypeReference<RespBean<Device>>(RespBean.class){});
        Assert.assertEquals(expectDevice,respBean.getObject());
    }

    private void getDeviceList() {
        Device device1 = new Device(1,"Name1","Type1","Description1","Serial1");
        Device device2 = new Device(2,"Name2","Type2","Description2","Serial2");

        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);

        String result = restTemplate.getForObject("/device",String.class);

        RespBean respBean = JSON.parseObject(result,new TypeReference<RespBean<List<Device>>>(RespBean.class){});
        Assert.assertEquals(devices,respBean.getObject());
    }

    private void updateDevice() {
        Device device = new Device(1,"newName1","newType1","newDescription1","newSerial1");
        String result = restTemplate.postForObject("/device/1",device,String.class);

        RespBean respBean = JSON.parseObject(result,RespBean.class);
        Assert.assertEquals(1,respBean.getObject());
    }

    private void addDevice() {
        Device device = new Device(3,"newName1","newType1","newDescription1","newSerial1");
        restTemplate.put("/device",device);

        String result = restTemplate.getForObject("/device",String.class);
        RespBean respBean = JSON.parseObject(result,new TypeReference<RespBean<List<Device>>>(RespBean.class){});
        Assert.assertEquals(3,((List)respBean.getObject()).size());
    }


    private void deleteDevice() {
        restTemplate.delete("/device/1");

        String result = restTemplate.getForObject("/device",String.class);
        RespBean respBean = JSON.parseObject(result,new TypeReference<RespBean<List<Device>>>(RespBean.class){});
        Assert.assertEquals(2,((List)respBean.getObject()).size());
    }

    private void getDeviceListByName() {
        String result = restTemplate.getForObject("/device/name/Name1",String.class);

        RespBean respBean = JSON.parseObject(result,new TypeReference<RespBean<List<Device>>>(RespBean.class){});
        Assert.assertEquals(1,((List)respBean.getObject()).size());
    }

    @Test
    public void test(){
        getDeviceById();
        getDeviceList();
        updateDevice();
        addDevice();
        deleteDevice();
        getDeviceListByName();
    }
}
