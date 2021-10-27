package com.gik.collections.stepik;

import java.time.LocalDate;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();// не отсартированный мэп
        map.put(1000, "Notebook");
        map.put(2000, "Phone");
        map.put(3000, "Keyboard");

        System.out.println(map);

        String notebook = map.get(1000);
        System.out.println(notebook);
        String noSuchItem = map.get(4000);
        System.out.println(noSuchItem);//null

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (String s : map.values()) {
            System.out.println(s);
        }

        Map<Integer, String> map1 = new LinkedHashMap<>();// сортировка идет как положили расширяем HashMap
        map1.put(1000, "Notebook");
        map1.put(2000, "Keyboard");
        map1.put(3000, "Phone");
        System.out.println(map1);

        SortedMap<LocalDate, String> sortedMap = new TreeMap<>();
        sortedMap.put(LocalDate.of(2017, 6, 7), " Java conference");
        sortedMap.put(LocalDate.of(2017, 6, 6), "Another Java conference");
        sortedMap.put(LocalDate.of(2017, 6, 8), "Moder art");

        LocalDate fromInclusive = LocalDate.of(2017, 6, 7);
        LocalDate toExclusive = LocalDate.of(2017, 6, 9);

        System.out.println(sortedMap.subMap(fromInclusive, toExclusive));


        Map<String, Integer> map2 = new TreeMap<>();
        map2.put("Gamma", 3);
        map2.put("Omega", 24);
        map2.put("Alpha", 1);

        Map<String, Integer> map3 = new LinkedHashMap<>();
        String s = "a aa abC aa ac abc bcd a";
        String[] strings = s.split("\\s+");

        for (String t : strings) {
            if (map3.containsKey(t)) {
                map3.computeIfPresent(t, (key, val) -> val + 1);
            } else {
                map3.put(t, 1);
            }
        }
        System.out.println(map3);

       /* Sample Input:
        3
        a
        bb
        cCc
        2
        a bb aab aba ccc
        c bb aaa

        Sample Output:
        aaa
        aab
        c
        aba*/

       /* Scanner in = new Scanner(System.in);
        Map<String, Integer> vocabulary = new HashMap<>();
        Map<String, Integer> currentMap = new HashMap<>();

        int d = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        for (int i = 0; i < d; i++) {
            vocabulary.put(in.nextLine().toLowerCase(), 1);
        }

        int l = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        for (int n = 0; n < l; n++) {
            String[] strings2 = in.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < strings.length; i++) {
                String current = strings2[i];
                if (!vocabulary.containsKey(current) && !map.containsKey(current)) {
                    currentMap.put(current, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> m : currentMap.entrySet()) {
            System.out.println(m.getKey());
        }*/

      /* abcd
         *d%#
         abacabadaba
         #*%*d*%   */
        /*output
        *d*%*d*#*d*
        dacabac*/

        String eString = "abacabadaba";
        String dString = "#*%*d*%";
        StringBuilder eBuilder = new StringBuilder();
        StringBuilder dBuilder = new StringBuilder();

        Map<Character, Character> encoder = new HashMap<>();
        Map<Character, Character> decoder = new HashMap<>();
        encoder.put('a', '*');
        encoder.put('b', 'd');
        encoder.put('c', '%');
        encoder.put('d', '#');

        char[] chars = eString.toCharArray();
        for (char aChar : chars) {
            if (encoder.containsKey(aChar)) {
                eBuilder.append(encoder.get(aChar));
            }
        }
        System.out.println(eBuilder);

        decoder.put('*', 'a');
        decoder.put('d', 'b');
        decoder.put('%', 'c');
        decoder.put('#', 'd');

        char[] chars1 = dString.toCharArray();
        for (char c : chars1) {
            if (decoder.containsKey(c)) {
                dBuilder.append(decoder.get(c));
            }
        }
        System.out.println(dBuilder);

      /*  Sample Input:

        2 4
        5
        1 aa
        5 ee
        2 bb
        4 dd
        3 cc
        Sample Output:

        2 bb
        3 cc
        4 dd*/

        int from = 2;
        int to = 4;
        int num = 5;
        int key = 0;
        String v = "";
        Map<Integer, String> stringMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            key = 4;
            v = "aa";
            if (key >= from && key <= to) {
                stringMap.put(key, v);
            }
        }

        for (Map.Entry<Integer, String> m : stringMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
