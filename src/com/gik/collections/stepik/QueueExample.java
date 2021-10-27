package com.gik.collections.stepik;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {

        //fifo
        Queue<String> q = new ArrayDeque<>();
        q.add("first");
        q.add("second");
        q.add("third");
        System.out.println(q.peek());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());

        //deque lifo
        System.out.println("////");
        Deque<String> d = new ArrayDeque<>();
        d.offerLast("first");
        d.offerLast("second");
        d.offerLast("third");
        System.out.println(d);
        System.out.println(d.pollLast());
        System.out.println(d.pollLast());
        System.out.println(d.pollLast());
        System.out.println(d.pollLast()); //null

        //старая реализация. рекомендутеся использовать deque
        Stack<String> stringStack = new Stack<>();
        stringStack.push("first");
        stringStack.push("second");
        stringStack.push("third");
        System.out.println(stringStack);
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        //  System.out.println(stringStack.pop()); //EmptyStackException

        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4));
        queue.addLast(5);
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        Deque<Integer> d2 = new ArrayDeque<>();
        d2.add(1);
        d2.add(2);
        d2.add(3);
        System.out.println(d2);

        while (!d2.isEmpty()) {
            System.out.println(d2.removeLast());
        }

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Deque<Integer> deque2 = new ArrayDeque<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                deque2.addFirst(i);
            } else {
                deque2.addLast(i);
            }
        }
        System.out.println(deque2);

        Deque<Character> q2 = new ArrayDeque<>();
        String s = ")([][])";
        char[] chars = s.toCharArray();
        for (char c : chars) {

            if (c == '(' || c == '[' || c == '{') {
                q2.addFirst(c);
            } else if ((c == ')' || c == ']' || c == '}')) {
                if (q2.peekFirst() == null) {
                    q2.addFirst(c);
                    break;
                }
                if ((c == ')' && q2.getFirst() == '(')
                        || (c == '}' && q2.getFirst() == '{')
                        || (c == ']' && q2.getFirst() == '[')) {
                    q2.removeFirst();
                } else {
                    break;
                }
            }
        }
        if (q2.isEmpty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        Deque<Integer> de = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Deque<Integer> de2 = new ArrayDeque<>();
        Deque<Integer> de3 = new ArrayDeque<>();
        int firstBox = 0;
        int secondBox = 0;

        for (int i = 0; i < 6; i++) {
            int n = de.removeFirst();
            if (secondBox >= firstBox) {
                de2.addLast(n);
                firstBox += n;
            } else {
                de3.addLast(n);
                secondBox += n;
            }
        }
        System.out.println(de2);
        System.out.println(de3);

        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> deque = new ArrayDeque<>();
        List<String> list1 = new ArrayList<>();
        list1.add("push 2 ");
        list1.add("push 1 ");
        list1.add("pop ");
        list1.add("max ");

        int current = Integer.MIN_VALUE;
        max.addFirst(current);

        for (String s1 : list1) {
            String[] strings = s1.trim().split("\\s+");

            switch (strings[0]) {
                case "push":
                    current = Integer.parseInt(strings[1]);
                    deque.addFirst(current);
                    if (current >= max.getFirst()) {
                        max.addFirst(current);
                    }
                    break;
                case "pop":
                    if (deque.getFirst().equals(max.getFirst())) {
                        max.removeFirst();
                    }
                    deque.removeFirst();
                    break;
                case "max":
                    System.out.println(max.getFirst());
            }
        }


    }
}
