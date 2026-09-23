package A921.dao;

import A921.entity.Stu;

import java.util.List;

public interface StuDAO {
    boolean save(Stu stu);

    boolean update(Stu stu);

    boolean delete(Integer sid);

    Stu findOne(Integer sid);

    List<Stu> findAll();
    List<Stu> findClaszAll(Integer cid);
}
