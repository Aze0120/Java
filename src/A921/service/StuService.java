package A921.service;

import A921.entity.Stu;

import java.util.List;

public interface StuService {
    boolean enterSchool(Stu stu);

    boolean leaveSchool(Integer sid);

    boolean claszTransfer(Integer sid,Integer cid);
    void checkID(Integer id);
    Stu getStuBySid(Integer sid);
    List<Stu> getAllStus();
    List<Stu> getStusClasz(Integer cid);

}
