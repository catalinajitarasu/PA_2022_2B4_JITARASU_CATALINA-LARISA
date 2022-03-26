package Lab4;


import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Street> streetList = new LinkedList<>();
        Set<Intersection> intersectionSet = new HashSet<>();
        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        Faker faker = new Faker();

        Intersection v0 = new Intersection(faker.address().streetAddressNumber());
        Intersection v1 = new Intersection(faker.address().streetAddressNumber());
        Intersection v2 = new Intersection(faker.address().streetAddressNumber());
        Intersection v3 = new Intersection(faker.address().streetAddressNumber());
        Intersection v4 = new Intersection(faker.address().streetAddressNumber());
        Intersection v5 = new Intersection(faker.address().streetAddressNumber());
        Intersection v6 = new Intersection(faker.address().streetAddressNumber());
        Intersection v7 = new Intersection(faker.address().streetAddressNumber());
        Intersection v8 = new Intersection(faker.address().streetAddressNumber());

        var streets = IntStream.rangeClosed(0, 16)
                .mapToObj(i -> new Street(faker.address().streetName())).toArray(Street[]::new);

        streets[0].setLength(2); streets[0].setOne(v0); streets[0].setTwo(v1);
        streets[1].setLength(2); streets[1].setOne(v0); streets[1].setTwo(v2);
        streets[2].setLength(2); streets[2].setOne(v0); streets[2].setTwo(v3);
        streets[3].setLength(1); streets[3].setOne(v2); streets[3].setTwo(v3);
        streets[4].setLength(2); streets[4].setOne(v1); streets[4].setTwo(v2);
        streets[5].setLength(3); streets[5].setOne(v1); streets[5].setTwo(v4);
        streets[6].setLength(2); streets[6].setOne(v2); streets[6].setTwo(v6);
        streets[7].setLength(2); streets[7].setOne(v2); streets[7].setTwo(v5);
        streets[8].setLength(3); streets[8].setOne(v3); streets[8].setTwo(v5);
        streets[9].setLength(1); streets[9].setOne(v4); streets[9].setTwo(v5);
        streets[10].setLength(1); streets[10].setOne(v4); streets[10].setTwo(v7);
        streets[11].setLength(2); streets[11].setOne(v4); streets[11].setTwo(v8);
        streets[12].setLength(1); streets[12].setOne(v6); streets[12].setTwo(v7);
        streets[13].setLength(1); streets[13].setOne(v7); streets[13].setTwo(v8);
        streets[14].setLength(1); streets[14].setOne(v6); streets[14].setTwo(v8);
        streets[15].setLength(3); streets[15].setOne(v5); streets[15].setTwo(v8);

        streetList.add(streets[0]);
        streetList.add(streets[1]);
        streetList.add(streets[2]);
        streetList.add(streets[3]);
        streetList.add(streets[4]);
        streetList.add(streets[5]);
        streetList.add(streets[6]);
        streetList.add(streets[7]);
        streetList.add(streets[8]);
        streetList.add(streets[9]);
        streetList.add(streets[10]);
        streetList.add(streets[11]);
        streetList.add(streets[12]);
        streetList.add(streets[13]);
        streetList.add(streets[14]);
        streetList.add(streets[15]);

        intersectionSet.add(v0);
        intersectionSet.add(v1);
        intersectionSet.add(v2);
        intersectionSet.add(v3);
        intersectionSet.add(v4);
        intersectionSet.add(v6);
        intersectionSet.add(v5);
        intersectionSet.add(v7);
        intersectionSet.add(v8);

        cityMap.put(v0, Arrays.asList(streets[0], streets[1], streets[2]));
        cityMap.put(v1, Arrays.asList(streets[0], streets[5], streets[4]));
        cityMap.put(v2, Arrays.asList(streets[1], streets[4], streets[6], streets[3], streets[7]));
        cityMap.put(v3, Arrays.asList(streets[2], streets[3], streets[8]));
        cityMap.put(v4, Arrays.asList(streets[5], streets[9], streets[10], streets[11]));
        cityMap.put(v5, Arrays.asList(streets[8], streets[7], streets[9], streets[15]));
        cityMap.put(v6, Arrays.asList(streets[6], streets[12], streets[14]));
        cityMap.put(v7, Arrays.asList(streets[10], streets[12], streets[13]));
        cityMap.put(v8, Arrays.asList(streets[11], streets[13], streets[14], streets[15]));

        List<Street> newSortedList = streetList.stream().sorted(Comparator.comparing(Street::getLength)).toList();

        System.out.println(streets[1].getName());

        //write a query that display all the streets that are longer than a specified value
        int value=(int)(Math.random()*4);
        //(max-min+min)-min max=3; min=1;
        List<Street> result = streetList.stream()
                .filter(street -> street.getLength() > value)
                .filter(street -> cityMap.get(streets[1].getOne()).size() + cityMap.get(streets[1].getTwo()).size() > 2)
                .collect(Collectors.toList());

        System.out.println(value);
        System.out.println(result);
    }
}
