package a915;

public class Student {
    private long id;
    private long iphone;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIphone() {
        return iphone;
    }

    public void setIphone(long iphone) {
        this.iphone = iphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(int id, int iphone, String name) {
        this.id = id;
        this.iphone = iphone;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", iphone=" + iphone +
                ", name='" + name + '\'' +
                '}';
    }
}
