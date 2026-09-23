package A921.entity;

public class Stu {
    private Integer sid;
    private String sname;
    private Integer sage;
    private String sphone;
    private Integer cid;

    public Stu(String sname, Integer sage, String sphone, Integer cid) {
        this.sname = sname;
        this.sage = sage;
        this.sphone = sphone;
        this.cid = cid;
    }

    public Stu() {
    }

    public Stu(Integer sid, String sname, Integer sage, String sphone, Integer cid) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.sphone = sphone;
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sphone='" + sphone + '\'' +
                ", cid=" + cid +
                '}';
    }
}
