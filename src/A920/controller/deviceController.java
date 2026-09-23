package A920.controller;

import A920.dao.DeviceDao;
import A920.dao.DeviceDaoImpl;
import A920.entity.device;
import A920.service.DeviceService;
import A920.service.DeviceServiceImpl;
import A920.utils.IdException;
import A920.utils.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class deviceController {
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static DeviceService deviceService = new DeviceServiceImpl();

    public static void printMenu() {
        System.out.println("1. 添加设备");
        System.out.println("2. 删除设备");
        System.out.println("3. 报修设备");
        System.out.println("4. 查询设备");
        System.out.println("5. 按设备ID查询设备:");
        System.out.println("6. 退出");
        System.out.println("请输入你的选择：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                boolean str = true;
                while (str) {
                    deviceController.addDevice();
                    System.out.println("是/否 继续添加设备(请输入y/n):");
                    String yn = scanner.next();
                    if (yn.equals("y")) {
                        str = true;
                    } else if (yn.equals("n")) {
                        str = false;
                    }else  {
                        System.out.println("请输入y/n:");
                    }
                }
                break;

            case 2:
                deviceController.deleteDevice();
                break;
            case 3:
                deviceController.bx();
                break;
            case 4:
                deviceController.getAllDevice();
                break;
            case 5:
                deviceController.getOneDevice();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重新输入");
        }
        printMenu();
    }


    private static void addDevice() {
        System.out.println("请输入设备名称:");
        String name = scanner.next();
        System.out.println("请输入设备状态（1、可用  2、停用  3、维修  4、报废）:");
        int status = scanner.nextInt();
        System.out.println("请输入设备购买日期:");
        String dateStr = scanner.next();
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        device device = new device(name, status, date);
        DeviceDao deviceDao = new DeviceDaoImpl();
        boolean save = deviceDao.save(device);
        if (save) {
            System.out.println("设备添加成功");
        } else {
            System.out.println("设备添加失败");
        }
    }

    private static void deleteDevice() {
        try {
//只完成用户交互
            System.out.println("请输入设备id：");
            int id = scanner.nextInt();
//调用业务层方法完成删除设备的逻辑
            boolean b = deviceService.deleteDevice(id);
            if (b) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (IdException e) {
            System.out.println("id超出范围");
        } catch (Exception e) {
            System.out.println("非校验异常");
        }
    }

    private static void bx() {
        System.out.println("请输入报修设备id：");
        int id = scanner.nextInt();
        try {
            boolean b = deviceService.bx(id);
            if (b) {
                System.out.println("报修成功");
            } else {
                System.out.println("报修失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getOneDevice() {
        try {
            System.out.println("请输入设备id：");
            int id = scanner.nextInt();
            device device = deviceService.getDeviceById(id);
            if (device != null) {
                System.out.println("编号\t名称\t状态\t日期");
                System.out.println(device);
            } else {
                System.out.println("设备不存在");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getAllDevice() {
        System.out.println("编号\t名称\t状态\t日期");
        List<device> deviceList = deviceService.getAllDevices();
        for (device device : deviceList) {
            System.out.println(device);
        }
    }
}
