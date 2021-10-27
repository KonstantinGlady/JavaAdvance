package com.gik.collections.stepik;

import java.util.*;

public class IterableExample {
    public static void main(String[] args) {

        List<String> collection = Arrays.asList("first", "second", "third");

        for (String s : collection) {
            System.out.println(s);
        }

        Set<Long> set = new TreeSet<>();
        set.add(5L);
        set.add(30L);
        set.add(23L);
        set.add(83L);

        Iterator<Long> iter = set.iterator();
        while (iter.hasNext()) {
            long current = iter.next();
            if (current > 5) {
                System.out.println(current);
            }
        }

        List<String> list = new ArrayList<>(collection);
        System.out.println(list);
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
