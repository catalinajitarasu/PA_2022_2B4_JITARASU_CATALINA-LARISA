package Lab4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Street> streetList = new LinkedList<>();
        Set<Intersection> intersectionSet = new HashSet<>();

        Intersection v0 = new Intersection("v0");
        Intersection v1 = new Intersection("v1");
        Intersection v2 = new Intersection("v2");
        Intersection v3 = new Intersection("v3");
        Intersection v4 = new Intersection("v4");
        Intersection v5 = new Intersection("v5");
        Intersection v6 = new Intersection("v6");
        Intersection v7 = new Intersection("v7");
        System.out.println(v0);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        System.out.println(v6);
        System.out.println(v7);

        var streets = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street("S" + i,i)).toArray(Street[]::new);
        streets[0].setLength(2);
        streets[1].setLength(5);
        streets[2].setLength(2);
        System.out.println(streets[0]);

        streetList.add(streets[0]);
        streetList.add(streets[1]);
        streetList.add(streets[2]);

        System.out.println("Lista de strazi sortata dupa lungime: ");
        List<Street> newSortedList = streetList.stream().sorted(Comparator.comparing(Street::getLength)).
                collect(Collectors.toList());
        System.out.println(newSortedList);

        intersectionSet.add(v0);
        intersectionSet.add(v3);
        intersectionSet.add(v2);
        intersectionSet.add(v4);
        intersectionSet.add(v6);
        intersectionSet.add(v5);
        intersectionSet.add(v7);
        intersectionSet.add(v7);

        System.out.println(intersectionSet);

   }
}
