package A920.entity;

import java.util.Date;

public class device {
    private int id;
    private String name;
    private int status;
    private Date createDate;

    public device() {
    }

    public device(String name, int status, Date createDate) {
        this.name = name;
        this.status = status;
        this.createDate = createDate;
    }

    public device(int id, String name, int status, Date createDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createDate = createDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
