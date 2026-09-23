package A921.test;

import A921.dao.ClaszDAO;
import A921.dao.Impl.ClaszDAOImpl;
import A921.entity.Clasz;

import java.util.List;

public class TestClaszDAO {
    public static ClaszDAO dao = new ClaszDAOImpl();

    public static void main(String[] args) {
        //TextClaszDAO.save();
        //TextClaszDAO.update();
        //TextClaszDAO.delete();
        //Clasz clasz=TextClaszDAO.findone();
        //System.out.println(clasz);
        //List<Clasz> claszList=TextClaszDAO.findAll();
        //for(Clasz clasz:claszList){
        //    System.out.println(clasz);
        //}
    }

    public static void save() {
        Clasz clasz = new Clasz();
        clasz.setCid(2);
        clasz.setCname("2ban");
        clasz.setCnum(20);
        if (dao.save(clasz)) {
            System.out.println("true");
        }
    }

    public static void update() {
        Clasz clasz = new Clasz();
        clasz.setCid(2);
        clasz.setCname("7ban");
        clasz.setCnum(30);
        if (dao.update(clasz)) {
            System.out.println("true");
        }
    }

    public static void delete() {
        Clasz clasz = new Clasz();
        clasz.setCid(2);
        if (dao.delete(clasz.getCid())) {
            System.out.println("true");
        }
    }

    public static Clasz findone() {
        Clasz clasz = new Clasz();
        clasz.setCid(1);
        clasz=dao.findOne(clasz.getCid());
        return clasz;
    }

    public static List<Clasz> findAll() {
        return dao.findAll();
    }
}
