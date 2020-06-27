# 入职京东前的小项目

## 项目内容

该项目意在模拟一个简单的设备管理后台系统，使用SpringBoot完成一个包含简单CRUD功能的Restful服务

重要的功能点：  

+ mybatis
+ mysql
+ 接口
  + 获取设备列表 get /device
  + 获取设备 get /device
  + 修改设备 update /device/{id}
  + 创建设备 post /device
  + 删除设备 delete /device/{id}
  + 搜索设备 get /device/name/{device_name}
+ log4j2记录日志到本地
+ TestRestTemplate和H2DataBase构建集成测试
+ Mockito构建单元测试
+ Redis缓存查询，失效时间15分钟，当update时缓存失效
