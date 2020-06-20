package com.example.device.controller;

import com.example.device.domain.Device;
import com.example.device.domain.RespBean;
import com.example.device.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeviceController {

    @Resource
    DeviceService deviceService;

    @RequestMapping(value = "/device",method = RequestMethod.GET)
    public RespBean getDeviceList(){
        try{
            List<Device> deviceList = deviceService.getDeviceList();
            return new RespBean(200,"成功",deviceList);
        }
        catch (Exception e){
            return new RespBean(500,e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/device/{id}",method = RequestMethod.GET)
    public RespBean getDeviceById(@PathVariable Integer id){
        try{
            Device device = deviceService.getDeviceById(id);
            return new RespBean(200,"成功",device);
        }
        catch (Exception e){
            return new RespBean(500,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/device/{id}",method = RequestMethod.POST)
    public RespBean updateDeviceById(@PathVariable Integer id, @RequestBody Device device){
        try{
            Integer code = deviceService.updateDeviceById(id,device.getName(),device.getType(),device.getDescription(),device.getSerial());
            if(code == 1){
                return new RespBean(200,"成功",code);
            }
            else {
                return new RespBean(200,"该设备不存在",code);
            }
        }
        catch (Exception e){
            return new RespBean(500,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/device",method = RequestMethod.PUT)
    public RespBean addDevice(@RequestBody Device device) {
        try {
            Integer code = deviceService.addDevice(device.getName(), device.getType(), device.getDescription(), device.getSerial());
            if (code == 1) {
                return new RespBean(200, "成功", code);
            } else {
                return new RespBean(200, "添加失败", code);
            }
        } catch (Exception e) {
            return new RespBean(500, e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/device/{id}",method = RequestMethod.DELETE)
    public RespBean deleteDevice(@PathVariable Integer id){
        try{
            Integer code = deviceService.deleteDeviceById(id);
            if (code == 1) {
                return new RespBean(200, "成功", code);
            } else {
                return new RespBean(200, "删除失败", code);
            }
        }
        catch (Exception e) {
            return new RespBean(500, e.getMessage(), null);
        }
    }
}
