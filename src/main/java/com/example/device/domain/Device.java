package com.example.device.domain;

import java.io.Serializable;

public class Device implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (getId() != null ? !getId().equals(device.getId()) : device.getId() != null) return false;
        if (getName() != null ? !getName().equals(device.getName()) : device.getName() != null) return false;
        if (getType() != null ? !getType().equals(device.getType()) : device.getType() != null) return false;
        if (getDescription() != null ? !getDescription().equals(device.getDescription()) : device.getDescription() != null)
            return false;
        return getSerial() != null ? getSerial().equals(device.getSerial()) : device.getSerial() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getSerial() != null ? getSerial().hashCode() : 0);
        return result;
    }
}
