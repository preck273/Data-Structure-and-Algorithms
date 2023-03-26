package com.dataStructure;

import LinkedList.LinkedListCustomized;

public class Main {

    public static void main(String[] args) {


        String[] names= new String[5];

        names[0] = "J";
        names[1] = "A";
        names[2] = "M";
        names[3] = "E";
        names[4] = "S";

        names= new String[5];
        System.out.println(names[0]);
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

    }

}
