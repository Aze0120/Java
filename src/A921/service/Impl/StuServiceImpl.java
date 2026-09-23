package A921.service.Impl;

import A921.dao.ClaszDAO;
import A921.dao.Impl.ClaszDAOImpl;
import A921.dao.Impl.StuDAOImpl;
import A921.dao.StuDAO;
import A921.entity.Clasz;
import A921.entity.Stu;
import A921.service.StuService;

import java.util.List;

public class StuServiceImpl implements StuService {
    public static StuDAO stuDAO = new StuDAOImpl();
    public static ClaszDAO claszDAO = new ClaszDAOImpl();

    @Override
    public boolean enterSchool(Stu stu) {
        if (stu.getSname() == null || stu.getSname().trim().equals("")) {
            throw new RuntimeException("姓名不能为空！");
        }
        if (stu.getSage() == null) {
            throw new RuntimeException("年龄不能为空！");
        }
        if (stu.getSage() <= 0) {
            throw new RuntimeException("年龄不能为负数！");
        }
        if (stu.getSphone() == null || stu.getSphone().trim().equals("")) {
            throw new RuntimeException("手机号码不能为空！");
        }
        if (stu.getSphone().length() != 11) {
            throw new RuntimeException("手机号码为11位数字。");
        }
        if (stu.getCid() == null) {
            throw new RuntimeException("班级id不能为空！");
        }
        Clasz clasz = claszDAO.findOne(stu.getCid());
        if (clasz == null) {
            throw new RuntimeException("班级不存在！");
        }
        boolean b = stuDAO.save(stu);
        //调用ClazzDAO中的update方法，将班级人数+1
        clasz.setCnum(clasz.getCnum() + 1);
        boolean b1 = claszDAO.update(clasz);
        return b && b1;
    }

    @Override
    public boolean leaveSchool(Integer sid) {
        if (sid == null) {
            throw new RuntimeException("学生id不能为空！");
        }
        if (sid <= 0) {
            throw new RuntimeException("学生id不能为负数！");
        }
        Stu stu = stuDAO.findOne(sid);   // 必须接收返回值，否则下面 stu.getCid() 拿到的是 null
        if (stu == null) {
            throw new RuntimeException("查无此人！");
        }

        Clasz clasz = claszDAO.findOne(stu.getCid());
        if (clasz == null) {
            throw new RuntimeException("班级不存在！");
        }
        clasz.setCnum(clasz.getCnum() - 1);
        boolean b1 = claszDAO.update(clasz);
        boolean b = stuDAO.delete(sid);
        return b && b1;
    }

    @Override
    public boolean claszTransfer(Integer sid, Integer cid) {
        if (sid == null) {
            throw new RuntimeException("学生id不能为空！");
        }
        if (sid <= 0) {
            throw new RuntimeException("学生id不能为负数");
        }
        if (cid == null) {
            throw new RuntimeException("班级id不能为空！");
        }
        if (cid <= 0) {
            throw new RuntimeException("班级id不能为负数");
        }
        Clasz clasz = claszDAO.findOne(cid);
        if (clasz == null) {
            throw new RuntimeException("转入班级不存在！");
        }
        Stu stu = stuDAO.findOne(sid);
        if (stu == null) {
            throw new RuntimeException("学生不存在！");
        }
        Clasz clasz1 = claszDAO.findOne(stu.getCid());
        if (clasz1 == null) {
            throw new RuntimeException("转出班级不存在！");
        }
        clasz.setCnum(clasz.getCnum() + 1);
        boolean b = claszDAO.update(clasz);
        clasz1.setCnum(clasz1.getCnum() - 1);
        boolean b1 = claszDAO.update(clasz1);
        stu.setCid(cid);
        boolean b2 = stuDAO.update(stu);
        return b && b1 && b2;
    }

    @Override
    public void checkID(Integer id) {
        //判空
        if (id == null) {
            throw new RuntimeException("编号不能为空!");
        }
        //判断范围
        if (id <= 0) {
            throw new RuntimeException("编号范围有误!");
        }
    }

    @Override
    public Stu getStuBySid(Integer sid) {
        checkID(sid);
        Stu stu = stuDAO.findOne(sid);
        return stu;
    }

    @Override
    public List<Stu> getAllStus() {
        return stuDAO.findAll();
    }

    @Override
    public List<Stu> getStusClasz(Integer cid) {
        return stuDAO.findClaszAll(cid);
    }
}
