package a915;

import java.util.Scanner;

public class Device {
    private int id;
    private int code;
    private String name;
    private String type;
    private String status;
    private String update;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if ("正常".equals(status) || "报修".equals(status) || "报废".equals(status) || "停用".equals(status)) {
            this.status = status;
        } else {
            System.out.println("设备状态只存在:正常、报修、报废、停用。");
            throw new RuntimeException("设备状态只存在:正常、报修、报废、停用。");
        }
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Device() {
    }

    public Device(int id, int code, String name, String type, String status, String update) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.setStatus(status);
        this.update = update;
    }

    @Override
    public String toString() {
        return "device{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", update='" + update + '\'' +
                '}';
    }
}
