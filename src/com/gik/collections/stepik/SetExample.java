package com.gik.collections.stepik;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        set1.add(0);
        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(2);
        set2.add(4);
        set2.add(1);

        result.addAll(set1); // containse 0 1 2
        result.addAll(set2); // containse 0 1 2 3 4 we lost 1 figure
        System.out.println(result);


        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(11);
        sortedSet.add(22);
        sortedSet.add(33);
        sortedSet.add(44);
        System.out.println(sortedSet);

        SortedSet<Integer> numbersLessThen33 = sortedSet.headSet(33);
        System.out.println(numbersLessThen33);
        int biggest = sortedSet.last();
        System.out.println(biggest);

        Set<Character> characters = new LinkedHashSet<>();

        for (char i = 'a'; i < 'k'; i++) {
            characters.add(i);
        }
        System.out.println(characters);

        SortedSet<String> set = new TreeSet<>();
        set.add("Gamma");
        set.add("Alpha");
        set.add("Omega");
        System.out.println(set);

        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        nameSet.stream().iterator().forEachRemaining(System.out::println);

    }
}
