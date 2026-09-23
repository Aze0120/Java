package A921.dao;

import A921.entity.Clasz;

import java.util.List;

public interface ClaszDAO {
    boolean save(Clasz clazz);
    boolean update(Clasz clazz);
    boolean delete(Integer cid);
    Clasz findOne(Integer cid);
    List<Clasz> findAll();
}
