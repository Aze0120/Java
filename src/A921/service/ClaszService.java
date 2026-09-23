package A921.service;

import A921.entity.Clasz;

import java.util.List;

public interface ClaszService {
    boolean createClazz(Clasz clasz);

    boolean deleteClazz(Integer cid);

    boolean updateClazz(Clasz clasz);

    Clasz getClazzByCid(Integer cid);

    List<Clasz> getAllClazzes();
}
