package com.example.device.mapper;

import com.example.device.domain.Device;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
class DeviceMapperTest {

    @Resource
    DeviceMapper deviceMapper;

    @Test
    void getDeviceById() {
        Device actualDevice = deviceMapper.getDeviceById(1);

//        Assert.assertEquals(expectDevice,actualDevice);
        System.out.println(actualDevice);
    }

    @Test
    void getDeviceList() {
        List<Device> devices = deviceMapper.getDeviceList();

//        Assert.assertEquals(devices,deviceMapper.getDeviceList());
        System.out.println(devices);
    }

    @Test
    void updateDeviceById() {
        Device device = new Device(1,"newName1","newType1","newDescription1","newSerial1");
        int i = deviceMapper.updateDeviceById(device);

//        Assert.assertEquals(device,deviceMapper.getDeviceById(1));
        System.out.println(i);
    }

    @Test
    void addDevice() {
        Device device = new Device(3,"Name3","Type3","Description3","Serial3");
        Integer i = deviceMapper.addDevice(device);

//        Assert.assertEquals(device,deviceMapper.getDeviceById(3));
        System.out.println(i);
    }

    @Test
    void deleteDeviceById() {
        Integer i = deviceMapper.deleteDeviceById(1);

//        Assert.assertEquals(1,deviceMapper.getDeviceList().size());
        System.out.println(i);
    }

    @Test
    void getDeviceListByName() {
        List<Device> devices = deviceMapper.getDeviceListByName("Name1");

//        Assert.assertEquals(devices,deviceMapper.getDeviceListByName("Name1"));
        System.out.println(devices);
    }
}