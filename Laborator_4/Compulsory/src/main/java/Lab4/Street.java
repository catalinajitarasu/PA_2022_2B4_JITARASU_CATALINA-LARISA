package Lab4;

public class Street{
    private String name;
    private int length;
    public Street(String name, int length){
        this.name=name;
        this.length=length;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }

    public int compareTo(Object o) {
        return 0;
    }
}
