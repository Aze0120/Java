package A921.dao.Impl;

import A921.dao.StuDAO;
import A921.entity.Stu;
import A921.util.DBOpr;
import A921.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDAOImpl implements StuDAO {
    private Connection conn;
    private PreparedStatement pre;
    private ResultSet res;

    @Override
    public boolean save(Stu stu) {
        String sql = "insert into tb_stu(sname,sage,sphone,cid) values(?,?,?,?)";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, stu.getSname());
            pre.setInt(2, stu.getSage());
            pre.setString(3, stu.getSphone());
            pre.setInt(4, stu.getCid());
            int row = pre.executeUpdate();
            return row > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, pre, conn);
        }
    }

    @Override
    public boolean update(Stu stu) {
        String sql = "update tb_stu set sname=?,sage=?,sphone=?,cid=? where sid=?";
        Object[] objs =
                {stu.getSname(), stu.getSage(), stu.getSphone(), stu.getCid(), stu.getSid()};
        return DBOpr.update(sql, objs) > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer sid) {
        String sql = "delete from tb_stu where sid = ?";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sid);
            int row = pre.executeUpdate();
            return row > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, pre, conn);
        }
    }

    @Override
    public Stu findOne(Integer sid) {
        String sql = "select * from tb_stu where sid = ?";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sid);
            res = pre.executeQuery();
            if (!res.next()) {   // 没查到该学号，直接返回 null，不能再调用 getXxx()
                return null;
            }
            Stu stu = new Stu();
            stu.setSid(sid);
            stu.setSname(res.getString("sname"));
            stu.setSage(res.getInt("sage"));
            stu.setSphone(res.getString("sphone"));
            stu.setCid(res.getInt("cid"));
            return stu;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(res, pre, conn);
        }
    }

    @Override
    public List<Stu> findAll() {
        String sql = "select * from tb_stu";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            List<Stu> stuList = new ArrayList<>();
            while (res.next()) {
                int id = res.getInt("sid");
                String name = res.getString("sname");
                int age = res.getInt("sage");
                String phone = res.getString("sphone");
                int cid = res.getInt("cid");
                Stu stu = new Stu(id, name, age, phone, cid);
                stuList.add(stu);
            }
            return stuList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(res, pre, conn);
        }
    }

    public List<Stu> findClaszAll(Integer cid) {
        String sql = "select * from tb_stu where cid=?";
        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1,cid);
            res = pre.executeQuery();
            List<Stu> stuList = new ArrayList<>();
            while (res.next()) {
                int id = res.getInt("sid");
                String name = res.getString("sname");
                int age = res.getInt("sage");
                String phone = res.getString("sphone");
                Stu stu = new Stu(id, name, age, phone, cid);
                stuList.add(stu);
            }
            return stuList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(res, pre, conn);
        }
    }
}
