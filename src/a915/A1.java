package a915;

import java.util.ArrayList;
import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Device> devices = new ArrayList<>();
        while (true) {
            System.out.println("设备系统");
            System.out.println("1.新增设备");
            System.out.println("2.查询单个设备");
            System.out.println("3.查询所有设备");
            System.out.println("4.修改设备状态");
            System.out.println("5.修改设备信息");
            System.out.println("6.删除设备信息");
            System.out.println("7.台账");
            System.out.println("0.退出系统");
            System.out.println("请输入你的选择:");
            int choice;
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                System.out.println("请输入0-7的整数来进行选择操作:");
                if (in.hasNextInt()) {
                    in.nextLine();
                } else {
                    System.out.println("输入已结束，系统退出");
                    break;
                }
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        System.out.println("请输入设备ID:");
                        int id = in.nextInt();
                        System.out.println("请输入设备码:");
                        int code = in.nextInt();
                        System.out.println("请输入设备名称:");
                        String name = in.next();
                        System.out.println("请输入设备类型:");
                        String type = in.next();
                        System.out.println("请输入设备状态:");
                        String status = in.next();
                        System.out.println("请输入设备更新日期：");
                        String update = in.next();
                        Device device = new Device(id, code, name, type, status, update);
                        devices.add(device);
                        System.out.println("设备信息:");
                        System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                        System.out.println(device.getId() + "\t" + device.getCode() + "\t\t" + device.getName() + "\t\t" + device.getType() + "\t\t" + device.getStatus() + "\t\t" + device.getUpdate());
                        break;
                    case 2:
                        System.out.println("准备开始查询,请输入设备ID:");
                        if (devices.isEmpty()) {
                            System.out.println("当前系统无设备存入！");
                        } else {
                            int searchId = in.nextInt();
                            boolean found = false;
                            for (Device device1 : devices) {
                                if (device1.getId() == searchId) {
                                    found = true;
                                    System.out.println("设备信息:");
                                    System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                                    System.out.println(device1.getId() + "\t" + device1.getCode() + "\t\t" + device1.getName() + "\t\t" + device1.getType() + "\t\t" + device1.getStatus() + "\t\t" + device1.getUpdate());
                                    System.out.println("设备查询成功");
                                }
                            }
                            if (!found) {
                                System.out.println("未找到ID为 " + searchId + " 的设备");
                            }
                        }
                        break;
                    case 3:
                        if (devices.isEmpty()) {
                            System.out.println("当前系统无设备存入！");
                        } else {
                            System.out.println("设备查询成功");
                            System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                            for (Device device1 : devices) {
                                System.out.println(device1.getId() + "\t" + device1.getCode() + "\t\t" + device1.getName() + "\t\t" + device1.getType() + "\t\t" + device1.getStatus() + "\t\t" + device1.getUpdate());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("请输入修改设备状态的设备ID:");
                        if (devices.isEmpty()) {
                            System.out.println("当前系统无设备存入！");
                        } else {
                            int searchId = in.nextInt();
                            boolean found = false;
                            for (Device device1 : devices) {
                                if (device1.getId() == searchId) {
                                    System.out.println("设备信息:");
                                    System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                                    System.out.println(device1.getId() + "\t" + device1.getCode() + "\t\t" + device1.getName() + "\t\t" + device1.getType() + "\t\t" + device1.getStatus() + "\t\t" + device1.getUpdate());
                                    System.out.println("开始修改");
                                    System.out.println("请输入设备状态:");
                                    device1.setStatus(in.next());
                                    System.out.println("请输入设备更新日期：");
                                    device1.setUpdate(in.next());
                                    System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                                    System.out.println(device1.getId() + "\t" + device1.getCode() + "\t\t" + device1.getName() + "\t\t" + device1.getType() + "\t\t" + device1.getStatus() + "\t\t" + device1.getUpdate());
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("未找到ID为 " + searchId + " 的设备");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("请输入修改设备信息的设备ID:");
                        if (devices.isEmpty()) {
                            System.out.println("当前系统无设备存入!");
                        } else {
                            int searchId = in.nextInt();
                            boolean found = false;
                            for (Device device1 : devices) {
                                if (device1.getId() == searchId) {
                                    found = true;
                                    System.out.println("设备信息:");
                                    System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                                    System.out.println(device1.getId() + "\t" + device1.getCode() + "\t\t" + device1.getName() + "\t\t" + device1.getType() + "\t\t" + device1.getStatus() + "\t\t" + device1.getUpdate());
                                    System.out.println("开始修改");
                                    System.out.println("请输入设备码:");
                                    device1.setCode(in.nextInt());
                                    System.out.println("请输入设备名称:");
                                    device1.setName(in.next());
                                    System.out.println("请输入设备类型:");
                                    device1.setType(in.next());
                                    System.out.println("请输入设备状态:");
                                    device1.setStatus(in.next());
                                    System.out.println("请输入设备更新日期：");
                                    device1.setUpdate(in.next());
                                    System.out.println("设备信息修改成功");
                                    System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                                    System.out.println(device1.getId() + "\t" + device1.getCode() + "\t\t" + device1.getName() + "\t\t" + device1.getType() + "\t\t" + device1.getStatus() + "\t\t" + device1.getUpdate());
                                }
                            }
                            if (!found) {
                                System.out.println("未找到ID为 " + searchId + " 的设备");
                            }
                        }
                        break;
                    case 6:
                        System.out.println("请输入需要删除的设备的设备ID:");
                        if (devices.isEmpty()) {
                            System.out.println("当前系统无设备存入！");
                        } else {
                            int searchId = in.nextInt();
                            boolean found = false;
                            for (Device device1 : devices) {
                                if (device1.getId() == searchId) {
                                    found = true;
                                    System.out.println("删除设备的设备信息:");
                                    System.out.println("id\tcode\tname\ttype\tstatus\tupdateDate");
                                    System.out.println(device1.getId() + "\t" + device1.getCode() + "\t\t" + device1.getName() + "\t\t" + device1.getType() + "\t\t" + device1.getStatus() + "\t\t" + device1.getUpdate());
                                    System.out.println("删除成功");
                                }
                            }
                            devices.removeIf(device1 -> device1.getId() == searchId);
                            if (!found) {
                                System.out.println("未找到ID为 " + searchId + " 的设备");
                            }
                        }
                        break;
                    case 7:
                        if (devices.isEmpty()) {
                            System.out.println("当前系统无设备存入！");
                            break;
                        }
                        int ky = 0;
                        int ty = 0;
                        int bx = 0;
                        int bf = 0;
                        for (Device device1 : devices) {
                            switch (device1.getStatus()) {
                                case "正常":
                                    ky++;
                                    break;
                                case "报修":
                                    bx++;
                                    break;
                                case "报废":
                                    bf++;
                                    break;
                                case "停用":
                                    ty++;
                                    break;
                            }
                        }
                        System.out.println("设备台账:当前总共有" + devices.size() + "台设备,其中正常:" + ky + "台,报修:" + bx + "台,报废:" + bf + "台,停用:" + ty + "台");
                        break;
                    case 0:
                        System.out.println("系统退出成功");
                        System.exit(0);
                    default:
                        System.out.println("输入错误");
                }
            } catch (Exception e) {
                System.out.println("系统业务出现问题,请重新选择功能！");
            }
        }
    }
}
