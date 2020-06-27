package com.example.device.service;

import com.example.device.domain.Device;
import com.example.device.mapper.DeviceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "redis-cache")
public class DeviceServiceImpl implements DeviceService{

    private static Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

    @Resource
    DeviceMapper deviceMapper;

    @Cacheable
    public Device getDeviceById(Integer id){
        return deviceMapper.getDeviceById(id);
    }

    public List<Device> getDeviceList(){
        return deviceMapper.getDeviceList();
    }

    @Cacheable
    public List<Device> getDeviceByName(String keyword) {
        return deviceMapper.getDeviceListByName(keyword);
    }

    @CacheEvict(allEntries = true)
    public Integer updateDeviceById(Integer id,String name,String type,String description,String serial){
        Device device = new Device(id,name,type,description,serial);
        return deviceMapper.updateDeviceById(device);
    }

    @CacheEvict(allEntries = true)
    public Integer addDevice(String name,String type,String description,String serial){
        Device device = new Device(null,name,type,description,serial);
        return deviceMapper.addDevice(device);
    }

    @CacheEvict(allEntries = true)
    public Integer deleteDeviceById(Integer id){
        return deviceMapper.deleteDeviceById(id);
    }
}
