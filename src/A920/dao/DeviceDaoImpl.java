package A920.dao;

import A920.entity.device;
import A920.utils.Daopr;
import A920.utils.JdbcUtils;
import A920.utils.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DeviceDaoImpl implements DeviceDao {


    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    Daopr daopr = new Daopr();

    public boolean save(device device) {
        String sql = "insert into tb_device(name,status,createDate) values(?,?,?)";
        Object[] objs = {device.getName(), device.getStatus(), device.getCreateDate()};
        return daopr.update(sql, objs);
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from tb_device where id = ?";
        Object[] objs = {id};
        return daopr.update(sql, objs);
    }

    @Override
    public boolean update(device device) {
        String sql = "update tb_device set name=?,status=?,createDate=? where id=?";
        Object[] objs = {device.getName(), device.getStatus(), device.getCreateDate(), device.getId()};
        return daopr.update(sql, objs);
    }

    @Override
    public device findOne(int id) {
        String sql = "select * from tb_device where id = ?";
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id2 = rs.getInt(1);
                String name = rs.getString(2);
                int status = rs.getInt(3);
                String dateStr = rs.getString(4);
                Date date = Tools.sdf.parse(dateStr);
                device device = new device(id2, name, status, date);
                return device;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(rs, ps, conn);
        }
        return null;
    }

    @Override
    public List<device> findAll() {
        String sql = "select * from tb_device";
        List<device> deviceList = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt(1);
                String name = rs.getString(2);
                int status = rs.getInt(3);
                String dateStr = rs.getString(4);
                Date date = Tools.sdf.parse(dateStr);
                device device = new device(id2, name, status, date);
                deviceList.add(device);
            }
            return deviceList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(rs, ps, conn);
        }

    }
}
