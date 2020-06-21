package com.example.device.mapper;

import com.example.device.domain.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper {
    @Select(value = "select * from device where id = #{id}")
    Device getDeviceById(Integer id);

    @Select(value = "select * from device")
    List<Device> getDeviceList();

    @Select(value = "select * from device where name like concat(concat('%',#{keyword}),'%')")
    List<Device> getDeviceListByName(String keyword);


    @Update(value = "update device set name=#{name},type=#{type},description=#{description},serial=#{serial} where id = #{id}")
    Integer updateDeviceById(Device device);

    @Insert(value = "insert into device (name,type,description,serial) values (#{name},#{type},#{description},#{serial})")
    Integer addDevice(Device device);

    @Delete(value = "delete from device where id=#{id}")
    Integer deleteDeviceById(Integer id);
}