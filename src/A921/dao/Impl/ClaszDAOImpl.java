package A921.dao.Impl;

import A921.dao.ClaszDAO;
import A921.entity.Clasz;
import A921.util.DBOpr;
import A921.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClaszDAOImpl implements ClaszDAO {
    private static Connection conn = null;
    private static PreparedStatement pre = null;
    private static ResultSet res = null;

    @Override
    public boolean save(Clasz clasz) {
        String sql = "insert into tb_class(cname) values(?)";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, clasz.getCname());
            int row = pre.executeUpdate();
            return row > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, pre, conn);
        }
    }

    @Override
    public boolean update(Clasz clasz) {
        String sql = "update tb_class set cname=?,cnum=? where cid=?";
        Object[] objs =
                { clasz.getCname(), clasz.getCnum(),clasz.getCid()};
        return DBOpr.update(sql, objs) > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer cid) {
        String sql = "delete from tb_class where cid = ?";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, cid);
            int row = pre.executeUpdate();
            return row > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, pre, conn);
        }
    }

    @Override
    public Clasz findOne(Integer cid) {
        String sql = "select * from tb_class where cid = ?";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, cid);
            res = pre.executeQuery();
            if (res.next()) {
                Clasz clasz = new Clasz();
                clasz.setCid(cid);
                clasz.setCname(res.getString("cname"));
                clasz.setCnum(res.getInt("cnum"));
                return clasz;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(res, pre, conn);
        }
    }

    @Override
    public List<Clasz> findAll() {
        String sql = "select * from tb_class";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            List<Clasz> claszList = new ArrayList<>();
            while (res.next()) {
                int id = res.getInt("cid");
                String name = res.getString("cname");
                int num = res.getInt("cnum");
                Clasz clasz=new Clasz(id, name, num);
                claszList.add(clasz);
            }
            return claszList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(res, pre, conn);
        }
    }
}
