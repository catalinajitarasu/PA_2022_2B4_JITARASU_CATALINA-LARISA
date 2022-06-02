package Lab4;

public class Intersection {
    public String name;
    public Intersection(String nume) {
        this.name = nume;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }
}
