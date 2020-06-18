package com.example.device.domain;

public class Device {
    Integer id;
    String name;
    String type;
    String description;
    String serial;

    public Device(){

    }

    public Device(Integer id, String name, String type, String description, String serial) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.serial = serial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
