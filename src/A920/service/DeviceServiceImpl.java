package A920.service;

import A920.dao.DeviceDao;
import A920.dao.DeviceDaoImpl;
import A920.entity.device;

import java.util.List;

public class DeviceServiceImpl implements DeviceService {
    private DeviceDao deviceDao = new DeviceDaoImpl();

    @Override
    public boolean addDevice(device device) {
        if (device.getName() == null || device.getName().trim().length() == 0) {
            throw new RuntimeException("名称不能为空");
        }
        //状态只能是1、2、3、4
        if (device.getStatus() < 1 || device.getStatus() > 4) {
            throw new RuntimeException("状态只能是1、2、3、4");
        }
        //调用dao方法处理业务逻辑
        return deviceDao.save(device);
    }

    @Override
    public boolean deleteDevice(int id) {
        if(id<0){
            throw new RuntimeException("id超出范围");
        }
        //调用dao方法处理业务逻辑
        return deviceDao.delete(id);
    }

    @Override
    public boolean bx(int id) {
        if (id <= 0) {
            throw new RuntimeException("id超出范围");
        }
        device device = deviceDao.findOne(id);
        if (device == null) {
            throw new RuntimeException("设备不存在");
        }
        device.setStatus(3);
        boolean b = deviceDao.update(device);
        return b;
    }

    @Override
    public List<device> getAllDevices() {
        List<device> deviceList = deviceDao.findAll();
        return deviceList;
    }

    @Override
    public device getDeviceById(int id) {
        //checkId(id);
    //调用dao方法完成业务逻辑
        device device = deviceDao.findOne(id);
        return device;
    }
}
