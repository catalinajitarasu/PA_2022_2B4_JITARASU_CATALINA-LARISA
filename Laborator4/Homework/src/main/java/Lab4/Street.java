package Lab4;

import java.util.List;
import java.util.stream.Collectors;

public class Street{
    private String name;
    private int length;
    private Intersection one;
    private Intersection two;

    public Street(String name, int length, Intersection one, Intersection two){
        this.name=name;
        this.length=length;
        this.one=one;
        this.two=two;
    }

    public Street(String name) {
        this.name=name;
    }

    public Intersection getTwo() {
        return two;
    }

    public void setTwo(Intersection two) {
        this.two = two;
    }

    public Intersection getOne() {
        return one;
    }

    public void setOne(Intersection one) {
        this.one = one;
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
                ", one=" + one +
                ", two=" + two +
                '}';
    }

    public int compareTo(Object o) {
        return 0;
    }
}
