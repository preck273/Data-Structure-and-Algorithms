package com.dataStructure;
import javax.swing.JOptionPane;

import HashMap.CustomizedHashMap;
import LinkedList.LinkedListCustomized;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ArrayListCustomised namer = new ArrayListCustomised(10);
//
        Integer[] names = {1,3,4,2,7,3,11,9,7,2,10};

//        From Int Array to HAshmap
//
//        String[] keys = new String[names.length];
//        String[] values = new String[names.length];
//
//
//        for (int i = 0; i< names.length; i++){
//            keys[i] = Integer.toString(i);
//            values[i] = Integer.toString(names[i]);
//        }
//
//        CustomizedHashMap<String, String> output = new CustomizedHashMap<String, String>(keys.length);
//
//        for (int i = 0; i< names.length; i++){
//            output.put(keys[i],values[i]);
//        }
//
//        System.out.println(output);


//        namer.addall(names);
//
//        System.out.println(Arrays.toString(namer.arrSort()));
//        System.out.println(Arrays.toString(namer.arrSort()));

//        System.out.println(namer.contains(10));
	// write your code here
//        System.out.println("hello world");

//
        LinkedListCustomized linkedListCustomized = new LinkedListCustomized();

        linkedListCustomized.addAll(names);

//        System.out.println(namer);

////
//        linkedListCustomized.addFirst(1);
//        linkedListCustomized.addLast(5);
//        linkedListCustomized.addLast(3);
//        linkedListCustomized.addLast(2);
//        linkedListCustomized.addLast(4);

//        System.out.println(linkedListCustomized.get(10));
//
//        System.out.println(linkedListCustomized.getLength());
//
//        System.out.println(linkedListCustomized.contains(1));
//        System.out.println(linkedListCustomized.contains(2));
//        System.out.println(linkedListCustomized.contains(3));
//        System.out.println(linkedListCustomized.contains(4));
//        System.out.println(linkedListCustomized.contains(5));

//        System.out.println(linkedListCustomized.getLast());


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


//        while(true){
//            String name = JOptionPane.showInputDialog("Enter your name");
//
//            String[] string = name.replaceAll("\\[", "")
//                .replaceAll("]", "")
//                .split(",");
//
//            // declaring an array with the size of string
//            Integer[] arr = new Integer[string.length];
//
//            // parsing the String argument as a signed decimal
//            // integer object and storing that integer into the
//            // array
//            for (int i = 0; i < string.length; i++) {
//                arr[i] = Integer.valueOf(string[i]);
//            }
//
//            ArrayListCustomised namer = new ArrayListCustomised(arr.length);
//            namer.addall(arr);
//
//            JOptionPane.showMessageDialog(null, "Sorted Array "+ Arrays.toString(namer.arrSort()));
//
//
////Add to display linked list
//            String ll = JOptionPane.showInputDialog("Enter your List. E.g 1,2,3,4,5,7,8");
//
//            LinkedListCustomized linkedListCustomized = new LinkedListCustomized();
//
//            linkedListCustomized.addAll(arr);
//
//
//
//            JOptionPane.showMessageDialog(null, "Sorted Array "+ linkedListCustomized.contains(2));
//
//
//            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
//
//            JOptionPane.showMessageDialog(null, "You are "+age+" years old");
//
//            double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));
//            JOptionPane.showMessageDialog(null, "You are "+height+" cm tall");
//        }


        }


}
