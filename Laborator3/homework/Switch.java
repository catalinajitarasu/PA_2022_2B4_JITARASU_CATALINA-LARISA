package homework;

import java.util.Map;

public class Switch extends Node {
    @Override
    public String toString() {
        return "Switch{" +
                "name='" + name + '\'' +
                '}';
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
}
