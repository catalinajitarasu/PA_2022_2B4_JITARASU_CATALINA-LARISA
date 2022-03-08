public class Main {
    public static void main(String[] args) {
        Computer computerA =new Computer();
        computerA.setStorageCapacity(100);
        computerA.setAddress("IP Adress");
        computerA.setName("v1");
        Computer computerB =new Computer();
        computerB.setStorageCapacity(100);
        computerB.setAddress("IP Adress");
        computerB.setName("v6");
        Router routerA =new Router();
        routerA.setAddress("IP Adress");
        routerA.setName("v2");
        Router routerB =new Router();
        routerB.setAddress("IP Adress");
        routerB.setName("v5");
        Switch switchA =new Switch();
        switchA.setName("v3");
        Switch switchB =new Switch();
        switchB.setName("v4");
        System.out.println(computerA);
        System.out.println(computerB);
        System.out.println(routerA);
        System.out.println(routerB);
        System.out.println(switchA);
        System.out.println(switchB);
        System.out.println( computerA.getName() + "--"+ routerA.getName());
        System.out.println( computerA.getName() + "--"+ switchA.getName());
        System.out.println( routerA.getName() + "--"+ switchA.getName());
        System.out.println( routerA.getName() + "--"+ switchB.getName());
        System.out.println( routerA.getName() + "--"+ routerB.getName());
        System.out.println( switchA.getName() + "--"+ switchB.getName());
        System.out.println( switchB.getName() + "--"+ routerB.getName());
        System.out.println( switchB.getName() + "--"+ computerB.getName());
        System.out.println( routerB.getName() + "--"+ computerB.getName());

    }

}
