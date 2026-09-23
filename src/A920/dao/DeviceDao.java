package A920.dao;

import A920.entity.device;

import java.util.List;

public interface DeviceDao {
    boolean save(device device);

    boolean delete(int id);

    boolean update(device device);

    device findOne(int id);

    List<device> findAll();
}
