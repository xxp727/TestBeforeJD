package com.example.device.service;

import com.example.device.domain.Device;

import java.text.DecimalFormat;
import java.util.List;

public interface DeviceService {
    Device getDeviceById(Integer id) throws Exception;

    List<Device> getDeviceList() throws Exception;

    List<Device> getDeviceByName(String keyword) throws Exception;

    Integer updateDeviceById(Integer id,String name,String type,String description,String serial) throws Exception;

    Integer addDevice(String name,String type,String description,String serial) throws Exception;

    Integer deleteDeviceById(Integer id) throws Exception;
}
