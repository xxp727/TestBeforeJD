package com.example.device.mapper;

import com.example.device.domain.Device;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
class DeviceMapperTest {

    @Resource
    DeviceMapper deviceMapper;

    @Test
    void getDeviceById() {
        System.out.println(deviceMapper.getDeviceById(1));
    }

    @Test
    void getDeviceList() {
        System.out.println(deviceMapper.getDeviceList());
    }

    @Test
    void updateDeviceById() {
        Device device = new Device(1,"name","type","description","serial");
        Integer i = deviceMapper.updateDeviceById(device);
        System.out.println(i);

        device.setId(1000000);
        System.out.println(deviceMapper.updateDeviceById(device));

        System.out.println(deviceMapper.getDeviceList());
    }

    @Test
    void addDevice() {
        Device device = new Device(null,"name","type","description","serial");
        Integer i = deviceMapper.addDevice(device);
        System.out.println(i);
        System.out.println(deviceMapper.getDeviceList());
    }

    @Test
    void deleteDeviceById() {
        deviceMapper.deleteDeviceById(1);
        System.out.println(deviceMapper.getDeviceList());
    }

    @Test
    void getDeviceListByName() {
        System.out.println(deviceMapper.getDeviceListByName("new"));
    }
}