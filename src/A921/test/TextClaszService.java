package A921.test;


import A921.dao.ClaszDAO;
import A921.dao.Impl.ClaszDAOImpl;
import A921.entity.Clasz;
import A921.entity.Stu;

import java.util.List;

public class TextClaszService {
    public static ClaszDAO claszDAO = new ClaszDAOImpl();

    public static void main(String[] args) {
        save();
        //delete();
        //update();
        //getClazzByCid();
        //getAllClazzes();
    }

    public static void save() {
        Clasz clasz = new Clasz();
        clasz.setCname("大清班");
        System.out.println(claszDAO.save(clasz));
    }

    public static void delete() {
        Clasz clasz = new Clasz();
        clasz.setCid(6);
        System.out.println(claszDAO.delete(clasz.getCid()));
    }

    public static void update() {
        Clasz clasz = new Clasz();
        clasz.setCid(5);
        clasz.setCname("5ban");
        clasz.setCnum(0);
        System.out.println(claszDAO.update(clasz));
    }

    public static void getClazzByCid() {
        Clasz clasz = new Clasz();
        clasz.setCid(5);
        System.out.println(claszDAO.findOne(clasz.getCid()));
    }
    public static void getAllClazzes(){
        List<Clasz> list = claszDAO.findAll();
        for (Clasz clasz : list) {
            System.out.println(clasz);
        }
    }
}
