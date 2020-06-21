package com.example.device.service;

import com.example.device.domain.Device;
import com.example.device.mapper.DeviceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Resource
    DeviceMapper deviceMapper;

    public Device getDeviceById(Integer id){
        return deviceMapper.getDeviceById(id);
    }

    public List<Device> getDeviceList(){
        return deviceMapper.getDeviceList();
    }
    
    public List<Device> getDeviceByName(String keyword) throws Exception {
        return deviceMapper.getDeviceListByName(keyword);
    }

    public Integer updateDeviceById(Integer id,String name,String type,String description,String serial){
        Device device = new Device(id,name,type,description,serial);
        return deviceMapper.updateDeviceById(device);
    }

    public Integer addDevice(String name,String type,String description,String serial){
        Device device = new Device(null,name,type,description,serial);
        return deviceMapper.addDevice(device);
    }

    public Integer deleteDeviceById(Integer id){
        return deviceMapper.deleteDeviceById(id);
    }
}
