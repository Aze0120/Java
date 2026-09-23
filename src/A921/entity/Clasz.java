package A921.entity;

public class Clasz {
    private Integer cid;
    private String cname;
    private Integer cnum;

    public Clasz(String cname, Integer cnum) {
        this.cname = cname;
        this.cnum = cnum;
    }

    public Clasz() {
    }

    public Clasz(Integer cid, String cname, Integer cnum) {
        this.cid = cid;
        this.cname = cname;
        this.cnum = cnum;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    @Override
    public String toString() {
        return "Clasz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cnum=" + cnum +
                '}';
    }
}
