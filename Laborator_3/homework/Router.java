package homework;
import java.util.Map;
import java.util.Objects;

public class Router extends Node  implements Identifiable {
    private String address;
    public void setAddress(String address) {

        this.address = address;
    }
    @Override
    public String getAddress() {

        return address;
    }
    @Override
    public int compareTo(Node o) {
        return super.compareTo(o);
    }

    @Override
    public Map<Node, Integer> getCost() {
        return super.getCost();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setCost(Node node, int value) {
        super.setCost(node, value);
    }

    @Override
    public String toString() {
        return "Router{" + "name=" + name + ", " +
                "address='" + address + '\'' +
                '}';
    }
}
