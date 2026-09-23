package A921.test;

import A921.entity.Stu;
import A921.service.Impl.StuServiceImpl;
import A921.service.StuService;

import java.util.List;

public class TestStuService {
    private static StuService service = new StuServiceImpl();

    public static void main(String[] args) {
        testEnterSchool();
//        testLeaveSchool();
//        claszTransfer();
//        getStuBySid();
//        getAllStus();
    }

    public static void testEnterSchool() {
        Stu stu = new Stu(null, "贾明晓", 20, "10340000000", 11);
        boolean b = service.enterSchool(stu);
        System.out.println(b);
    }

    public static void testLeaveSchool() {
        boolean b = service.leaveSchool(2);
        System.out.println(b);
    }

    public static void claszTransfer() {
        boolean b = service.claszTransfer(4, 4);
        System.out.println(b);
    }

    public static void checkID() {
    }

    public static void getStuBySid() {
        Stu stu = service.getStuBySid(4);
        System.out.println(stu);
    }

    public static void getAllStus() {
        List<Stu> stuList = service.getAllStus();
        for (Stu stu : stuList) {
            System.out.println(stu);
        }
    }
}
