package com.gik.collections.stepik;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsExample {
    public static void main(String[] args) {

/*        Sample Input:
        1 2 3 4 5 6
        2
        0 1
        3 4
        Sample Output:
        2 1 3 5 4 6*/

        String string = "1 2 3 4 5 6";
        int num = 2;
        int sw1;
        int sw2;


        List<Integer> list = Arrays.stream(string.split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < num; i++) {
            sw1 = 0;
            sw2 = 1;

            Collections.swap(list, sw1, sw2);
        }
        System.out.println(list);

        /*Sample Input:

        3 3
        1 1 1
        2 2 2
        3 3 3
        1
        Sample Output:

        3 3 3
        1 1 1
        2 2 2*/


        Scanner in = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        int numbers = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numbers; i++) {
            stringList.add(in.nextLine());
        }
        int rot = in.nextInt();
        Collections.rotate(stringList, rot);
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
