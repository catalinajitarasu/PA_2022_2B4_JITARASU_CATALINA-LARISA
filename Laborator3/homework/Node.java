package homework;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    protected String name;
    protected Map<Node, Integer> cost = new HashMap<>();

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }
    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
