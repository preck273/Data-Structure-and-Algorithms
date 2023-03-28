package com.dataStructure;

import HashMap.CustomizedHashMap;
import LinkedList.LinkedListCustomized;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ArrayListCustomised namer = new ArrayListCustomised(10);
        Integer[] names = {1,3,4,2,7,3,11,9,7,2,10};


        CustomizedHashMap<String, String> map = new CustomizedHashMap<String, String>();
        map.put("A", "B");
        map.put("E", "F");
        map.put("H", "P");
        map.put("P", "2");
        map.put("1",  "G");
        map.put("2", "6");
        map.put("3", "2");
        map.put("4", "4");
        map.put("1",  "H");

        //System.out.println("Map list " + map);
//        System.out.println(map.get("A"));
//        System.out.println(map.remove("A"));
//        System.out.println(map.get("A"));
        map.remove("1");
        System.out.println(map);



        //namer.addall(names);

//        System.out.println(Arrays.toString());
//        System.out.println(Arrays.toString(namer.arrSort()));

//        System.out.println(namer.contains(10));
	// write your code here
//        System.out.println("hello world");

//
//        LinkedListCustomized linkedListCustomized = new LinkedListCustomized();
////
//        linkedListCustomized.addFirst(1);
//        linkedListCustomized.addLast(5);
//        linkedListCustomized.addLast(3);
//        linkedListCustomized.addLast(2);
//        linkedListCustomized.addLast(4);

//        System.out.println(linkedListCustomized.get(2));
//
//        System.out.println(linkedListCustomized.getLength());
//
//        System.out.println(linkedListCustomized.contains(1));
//        System.out.println(linkedListCustomized.contains(2));
//        System.out.println(linkedListCustomized.contains(3));
//        System.out.println(linkedListCustomized.contains(4));
//        System.out.println(linkedListCustomized.contains(5));

//        System.out.println(linkedListCustomized.getLast());
//        System.out.println(Arrays.toString(linkedListCustomized.descendingIterator()));


//        Iterator<Integer> iterator = Arrays.asList(linkedListCustomized.descendingIterator()).iterator();

//        Iterator<Integer> iterator = linkedListCustomized.descendingIterator();
//
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        System.out.println("hello world");
//        long endTime = System.currentTimeMillis();
//      //  long duration = endTime - startTime;
//        System.out.println("Time taken: " + duration + " milliseconds");
    }

    //CustomizedHashMap<String, String> customizedHashMap = new CustomizedHashMap<String, String>();


}
