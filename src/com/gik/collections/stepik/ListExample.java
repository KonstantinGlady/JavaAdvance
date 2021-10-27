package com.gik.collections.stepik;

import java.util.*;
import java.util.stream.Collectors;

public class ListExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        int size = list.size();
        System.out.println(size);
        boolean isEmpty = list.isEmpty();
        System.out.println(isEmpty);

        list.add("mr.Brown");
        list.add("mr.Blue");
        list.add("mr.Red");
        list.add("mr.Yellow");

        size = list.size();
        System.out.println(size);
        isEmpty = list.isEmpty();
        System.out.println(isEmpty);

        int indexOfElement = list.indexOf("mr.Yellow");
        System.out.println(indexOfElement);
        String element = list.get(indexOfElement);
        System.out.println(element);

        list.set(indexOfElement, "mr.Orange");
        System.out.println(list.get(indexOfElement));

        for (String s : list) {
            System.out.println(s);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //convert to array
        Object[] objects = list.toArray();

        String[] strings = list.toArray(new String[0]);

        //convert to list
        List<String> abc = Arrays.asList("a", "b", "c", "d");

        //sublist
        List<Integer> integers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println(integers.subList(1, 3));
        integers.subList(1, 3).clear();
        System.out.println(integers);


        list.remove(1);
        list.clear();

        List<String> nameList = new ArrayList<>(Arrays.asList("mr.Red", "mr.Yellow", "mr.Blue"));
        System.out.println(nameList);

        nameList.stream().iterator().forEachRemaining(System.out::println);

        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }


        List<Integer> listInts;
        String s = "1 2 3 4 5 6 7";
        listInts = Arrays.stream(s.split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = listInts.size() - 1; i >= 0; i--) {
            if (listInts.get(i) % 2 == 0) {
                System.out.print(listInts.get(i) + " ");
            }
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(1);
        list3.add(2);

        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list1));
        System.out.println(list1.equals(list3));
        System.out.println(list3.equals(list2));

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

        }


    }
}
