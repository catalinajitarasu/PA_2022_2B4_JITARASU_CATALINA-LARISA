import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    //… constructors, getters, setters
    public void addNode(Node node) {
        nodes.add(node);
    }
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
    public List<Node> getNodes() {
        return nodes;
    }
    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }
    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
