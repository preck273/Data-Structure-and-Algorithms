package com.dataStructure;

import LinkedList.LinkedListCustomized;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ArrayListCustomised namer = new ArrayListCustomised(10);
        Integer[] names = {1,3,4,2,7,3,11,9,7,2,10};

        namer.addall(names);

//        System.out.println(Arrays.toString());
//        System.out.println(Arrays.toString(namer.arrSort()));

//        System.out.println(namer.contains(10));
	// write your code here
//        System.out.println("hello world");
//
        LinkedListCustomized linkedListCustomized = new LinkedListCustomized();
//
        linkedListCustomized.addFirst(1);
        linkedListCustomized.addLast(5);
        linkedListCustomized.addLast(3);
        linkedListCustomized.addLast(2);
        linkedListCustomized.addLast(4);

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

        Iterator<Integer> iterator = linkedListCustomized.descendingIterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        System.out.println("hello world");
    }

}
