package A921.test;

import A921.dao.Impl.StuDAOImpl;
import A921.dao.StuDAO;
import A921.entity.Stu;

import java.util.List;

public class TestStuDAO {
    public static StuDAO stuDAO=new StuDAOImpl();
    public static void main(String[] args) {
        //TextStuDAO.save();
        //TextStuDAO.update();
        //TextStuDAO.delete();
        //Stu stu=TextStuDAO.findone();
        //System.out.println(stu);
        //List<Stu> list=TextStuDAO.findAll();
        //for(Stu stu:list){
        //    System.out.println(stu);
        //}
    }
    public static void save() {
        Stu stu = new Stu();
        stu.setSname("zhangsan");
        stu.setSage(18);
        stu.setSphone("1000000000");
        stu.setCid(1);
        if(stuDAO.save(stu)){
            System.out.println("true");
        };
    }
    public static void update() {
        Stu stu = new Stu();
        stu.setSid(3);
        stu.setSname("lisi");
        stu.setSage(28);
        stu.setSphone("1100000000");
        stu.setCid(2);
        if(stuDAO.update(stu)){
            System.out.println("true");
        }
    }
    public static void delete() {
        Stu stu = new Stu();
        stu.setSid(1);
        if (stuDAO.delete(stu.getSid())){
            System.out.println("true");
        }
    }
    public  static Stu findone() {
        Stu stu = new Stu();
        stu.setSid(2);
        stu=stuDAO.findOne(stu.getSid());
        return stu;
    }
    public static List<Stu> findAll() {
        return stuDAO.findAll();
    }
}
