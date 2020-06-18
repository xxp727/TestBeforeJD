package com.example.device.service;

import com.example.device.domain.Device;
import com.example.device.mapper.DeviceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceService {

    @Resource
    DeviceMapper deviceMapper;

    Device getDeviceById(Integer id){
        return deviceMapper.getDeviceById(id);
    }

    List<Device> getDeviceList(){
        return deviceMapper.getDeviceList();
    }

    Integer updateDeviceById(Integer id,String name,String type,String description,String serial){
        Device device = new Device(id,name,type,description,serial);
        return deviceMapper.updateDeviceById(device);
    }

    Integer addDevice(String name,String type,String description,String serial){
        Device device = new Device(null,name,type,description,serial);
        return deviceMapper.addDevice(device);
    }

    Integer deleteDeviceById(Integer id){
        return deviceMapper.deleteDeviceById(id);
    }
}
