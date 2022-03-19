package homework;

public class Main {
    public static void main(String[] args) {
        Computer computerA =new Computer();
        computerA.setStorageCapacity(50);
        computerA.setName("v1");
        computerA.setAddress("BC");
        Computer computerB =new Computer();
        computerB.setStorageCapacity(100);
        computerB.setName("v6");
        computerB.setAddress("BD");
        Router routerA =new Router();
        routerA.setName("v2");
        routerA.setAddress("DE");
        Router routerB =new Router();
        routerB.setName("v5");
        routerB.setAddress("BR");
        Switch switchA =new Switch();
        switchA.setName("v3");
        Switch switchB =new Switch();
        switchB.setName("v4");

        computerA.setCost(routerA,10);
        computerA.setCost(switchA,50);
        routerA.setCost(switchA,20);
        routerA.setCost(switchB,20);
        routerA.setCost(routerB,10);
        switchA.setCost(switchB,20);
        switchB.setCost(routerB,30);
        switchB.setCost(computerB,10);
        routerB.setCost(computerB,10);

        for (Node id : computerA.cost.keySet()) {
            System.out.println(computerA.name + "->" + id.name + " | " + computerA.cost.get(id));
        }
        for (Node id : routerA.cost.keySet()) {
            System.out.println(routerA.name + "->" + id.name + " | " + routerA.cost.get(id));
        }
        for (Node id : switchA.cost.keySet()) {
            System.out.println(switchA.name + "->" + id.name + " | " + switchA.cost.get(id));
        }
        for (Node id : switchB.cost.keySet()) {
            System.out.println(switchB.name + "->" + id.name + " | " + switchB.cost.get(id));
        }
        for (Node id : routerB.cost.keySet()) {
            System.out.println(routerB.name + "->" + id.name + " | " + routerB.cost.get(id));
        }

        //Sortare noduri identificabile
        Network Network1= new Network ("Network1");
        Network1.nodes.add(computerA);
        Network1.nodes.add(computerB);
        Network1.nodes.add(routerA);
        Network1.nodes.add(routerB);
        Network1.nodes.add(switchA);
        Network1.nodes.add(switchB);
        System.out.println();
        System.out.println("Nodurile identificabile ordonate dupa adresa:");
        Network1.nodeIdentificable();

        //distanta de la nodurile identificabile la celelalte
        System.out.println();
        System.out.println("Drumuri de cost minim:");
       Network1.orderAlg();

    }
}
