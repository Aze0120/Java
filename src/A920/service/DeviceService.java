package A920.service;

import A920.entity.device;

import java.util.List;

public interface DeviceService {
    boolean addDevice(device device);

    boolean deleteDevice(int id);

    boolean bx(int id);

    List<device> getAllDevices();

    device getDeviceById(int id);
}
