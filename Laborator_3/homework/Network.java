package homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Network {
    protected List<Node> nodes = new ArrayList<>();
    protected String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Network(String name) {
        this.name = name;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return Objects.equals(nodes, network.nodes) && Objects.equals(name, network.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes, name);
    }

    //creaza lista cu locurile identificabile
    public void nodeIdentificable(){
        List<Node> identificabile = new ArrayList<>();
        for(int index=0;index<this.nodes.size();index++) //verific sa fie Identificable
            if(nodes.get(index) instanceof Identifiable)
                 identificabile.add((nodes.get(index)));
        //folosesc clasa Comporator pentru a ordona lista in functie de adresa
        identificabile.sort(Comparator.comparing(Node::toString));
        for(int index=0;index<identificabile.size();index++)
            System.out.println(identificabile.get(index));
    }

    /**
     * Algoritmul lui BellmanFord,care imi calculeaza cel mai mic drum de la un nod la alt nod
     * @param node1 primul nod al drumului
     * @param node2 unde vreau sa ajung
     */
    public void distanceCost(Node node1, Node node2) {
        int index1 = 0;
        int k;
        int indice1 = 0;
        int indice2 = 0;
        int[] distance = new int[nodes.size()];//tine minte distanta fata de fiecare nod vizitat pentru fiecare pozitie
        int[] previous = new int[nodes.size()];//nodurile vizitate
        int tempDistance = 0;//costul total
        for (int i = 0; i < nodes.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
            if (nodes.get(i).getName().equals(node2.name)) index1 = i;
        }
        distance[index1] = 0;
        for (int i = 0; i < nodes.size(); i++) {
            //iau toate nodurile din retea
            for (int j = i; j < nodes.size(); j++) {
                Node n1 = nodes.get(i);
                Node n2 = nodes.get(j);
                if (!n1.equals(n2)) {
                    try {
                        int cost = n1.cost.get(n2);
                        //se ia costul dintre cele 2 muchii daca exista
                        if (distance[i] != Integer.MAX_VALUE && distance[i] + cost < distance[j])
                            tempDistance = distance[j]+cost;
                        //daca este mai mic modific distanta si notam in previous[i] ca am trecut prin j
                        if (tempDistance < distance[i]) {
                            distance[i] = tempDistance;
                            previous[i] = j;
                        } else if (tempDistance == distance[i]) {//daca sunt egale le luam in functie de ordine
                            for (k = 0; k < nodes.size(); k++)
                                if (nodes.get(previous[i]) == nodes.get(k)) {
                                    indice1 = k;
                                }
                            if (nodes.get(j) == nodes.get(k)) indice2 = k;
                            if (indice1 < indice2) {
                                distance[i] = tempDistance;
                                previous[i] = indice1;
                            } else {
                                distance[i] = tempDistance;
                                previous[i] = indice2;
                            }
                        }
                    } catch (Exception e){}
                }
            }
        }
        System.out.println("Cost " + node1.getName() + " -> " + node2.getName() + " : " + tempDistance);
    }

    public void orderAlg(){
        List<Node> identificabile = new ArrayList<>();
        for(int index=0;index<this.nodes.size();index++) //verific sa fie Identificable
            if(nodes.get(index) instanceof Identifiable)
                identificabile.add((nodes.get(index)));

        for(int index=0;index<identificabile.size();index++)
              for(int index1=index+1;index1<identificabile.size();index1++){
                            distanceCost(identificabile.get(index),identificabile.get(index1));
              }
    }
}
