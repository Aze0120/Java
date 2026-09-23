package A921.service.Impl;

import A921.dao.ClaszDAO;
import A921.dao.Impl.ClaszDAOImpl;
import A921.entity.Clasz;
import A921.service.ClaszService;

import java.util.List;

public class ClaszServiceImpl implements ClaszService {
    ClaszDAO claszDAO = new ClaszDAOImpl();

    @Override
    public boolean createClazz(Clasz clasz) {
        if (clasz == null) {
            throw new IllegalArgumentException("班级信息不能为空");
        }
        Clasz clasz1 = claszDAO.findOne(clasz.getCid());
        if (clasz1 != null) {
            throw new IllegalArgumentException("班级已存在！");
        }
        if (clasz.getCname() == null || "".equals(clasz.getCname())) {
            throw new IllegalArgumentException("班级名称不能为空！");
        }
        boolean b = claszDAO.save(clasz);
        return b;
    }

    @Override
    public boolean deleteClazz(Integer cid) {
        if (cid == null) {
            throw new IllegalArgumentException("班级id不能为空！");
        }
        if (cid <= 0) {
            throw new IllegalArgumentException("班级id不能为负数！");
        }
        Clasz clasz = claszDAO.findOne(cid);
        if (clasz == null) {
            throw new IllegalArgumentException("班级不存在！");
        }
        boolean b = claszDAO.delete(cid);

        return b;
    }

    @Override
    public boolean updateClazz(Clasz clasz) {
        if (clasz == null) {
            throw new IllegalArgumentException("班级信息不能为空");
        }
        Clasz clasz1 = claszDAO.findOne(clasz.getCid());
        if (clasz1 == null) {
            throw new IllegalArgumentException("班级不存在！");
        }
        if (clasz.getCname() == null || "".equals(clasz.getCname())||clasz1.getCname() == null || "".equals(clasz1.getCname())) {
            throw new IllegalArgumentException("班级名称不能为空！");
        }
        boolean b = claszDAO.update(clasz);
        return b;
    }

    @Override
    public Clasz getClazzByCid(Integer cid) {
        Clasz clasz = claszDAO.findOne(cid);
        return clasz;
    }

    @Override
    public List<Clasz> getAllClazzes() {
        return claszDAO.findAll();
    }
}
