package ru.gb.jtwo.clesson.online;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);

        map.put("January", 10);

        System.out.println(map.get("January"));

        System.out.println(map);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        for (String s : map.keySet()) {
            System.out.println(s + "=" + map.get(s));
        }
    }

    private static void treeSetExample() {
        TreeSet<Box> set = new TreeSet<>();
        Box b1 = new Box(2, 2, 1);
        Box b2 = new Box(3, 3, 3);
        Box b3 = new Box(4, 4, 0);
        set.add(b1);
        set.add(b2);
        set.add(b3);
        System.out.println(set);

        for (Box b : set) {
            System.out.println(b);
        }
    }

    private static void arsenExample() {
        LinkedHashSet<Box> set = new LinkedHashSet<>();
        Box b1 = new Box(2, 2, 1);
        Box b2 = new Box(3, 3, 3);
        Box b3 = new Box(2, 2, 0);
        set.add(b1);
        set.add(b2);
        set.add(b3);
        System.out.println(set);
    }

    private static void listWithBoxes() {
        Box b1 = new Box(2, 2, 2);
        Box b2 = new Box(3, 3, 3);
        Box b3 = new Box(4, 4, 4);
        Box b4 = new Box(5, 5, 5);
        LinkedList<Box> list = new LinkedList<>(Arrays.asList(b1, b2, b3, b4));
        list.add(new Box(1, 1, 1));
        Box b5 = new Box(2, 2, 2);

        System.out.println(b1.hashCode());
        System.out.println(b5.hashCode());

        //list.remove(0);

        System.out.println(list.contains(b5));

        System.out.println(list);
    }

    private static void arrayListSample() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Java");
        list.add("World");

        System.out.println(list.contains("Java")); //new String("Java")

        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            System.out.println(s);
        }

        for (String s : list) {
            System.out.println(s);
        }

        list.remove(list.size() - 1);
    }
}
