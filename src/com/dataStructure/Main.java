package com.dataStructure;

import LinkedList.LinkedListCustomized;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList namer = new ArrayList(10);
        Integer[] names = {1,3,4,2,7,3,11,9,7,2,10};

        namer.addall(names);

        Math.round(2);

        System.out.println(Arrays.toString(namer.list));
        System.out.println(namer.contains(3));


//        System.out.println(namer.contains(10));
	// write your code here
        System.out.println("hello world");

        LinkedListCustomized linkedListCustomized = new LinkedListCustomized();

        linkedListCustomized.addFirst(1);
        linkedListCustomized.addLast(2);
        linkedListCustomized.addLast(3);
        linkedListCustomized.addLast(4);
        linkedListCustomized.addLast(5);


        System.out.println(linkedListCustomized.get(2));

        System.out.println(linkedListCustomized.getLength());

        System.out.println(linkedListCustomized.convertToArray());


//        System.out.println(linkedListCustomized.getLast());
//        System.out.println(linkedListCustomized.get(0));

//        System.out.println("hello world");
    }

}
