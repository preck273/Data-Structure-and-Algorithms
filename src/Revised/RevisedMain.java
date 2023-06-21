package Revised;

import Revised.BinaryTree.*;
import Revised.LinkedList.LinkedListCustomizedNew;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class RevisedMain {

    public static void main(String[] args) {
//Import dataset
        String filePath = "C:\\Users\\Gebruiker\\Documents\\GitHub\\Data-Structure-and-Algorithms\\src\\Revised\\Resources\\cars.txt";

        txttoList<String> carstxt = new txttoList<String>(); //change based on
        List<String> cars = carstxt.readFileToList(filePath, String.class);

        System.out.println("ARRAYLIST");
        System.out.println("....................................................................................................................");

//        Test String
        arrayListNew<String> arrayList = new arrayListNew<String>(10);

        // Add elements to the ArrayList
        for (String car : cars) {
            arrayList.add(car);
        }

        // Create an array of strings
        String[] values = {"Tesla", "Subaru", "Porsche"};

        // Add all elements from the array to the ArrayList
        arrayList.addAll(values);

        // Check if the ArrayList contains a specific value
        String searchValue = "Subaru";
        boolean containsValue = arrayList.contains(searchValue);
        System.out.println("Contains " + searchValue + ": " + containsValue);

        // Get the index of a specific value in the ArrayList
        String searchIndexValue = "Lambo";
        int index = arrayList.indexof(searchIndexValue);
        System.out.println("Index of " + searchIndexValue + ": " + index);

        // Test bubbleSortSelf
        arrayListNew<String> sortedList = arrayList.bubbleSortSelf();

        // Compare both Lists
        System.out.println("Unsorted List:" + Arrays.toString(arrayList.toArray()));
        System.out.println("Sorted List:" + Arrays.toString(sortedList.toArray()));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("                                                                                                                    ");

//        String TEst
        // Create a new binary tree

        System.out.println("BINARY TREE");
        System.out.println("....................................................................................................................");
        CustomizedBinaryTreeNew<String> binaryTree = new CustomizedBinaryTreeNew<String>();

        // Add elements to the binary tree
        for (String car : cars) {
            binaryTree.add(car);
        }

        // Check if the binary tree contains a specific element
        System.out.println("Contains 'Tesla': " + binaryTree.containsNode("Tesla"));
        System.out.println("Contains 'BMW': " + binaryTree.containsNode("BMW"));

        // Get the size of the binary tree
        System.out.println("Size of the tree: " + binaryTree.getSize());

        // Convert the binary tree to an array using in-order traversal
        System.out.println("Binary tree to array (In-order): " + binaryTree.print(1).bstToArray(1));

        // Delete an element from the binary tree
        binaryTree.delete("Tesla");

        // Convert the binary tree to an array using pre-order traversal
        System.out.println("Binary tree to array (Pre-order): " + binaryTree.print(1).bstToArray(2));

//Test levels
        System.out.println("BINARY TREE ADD BY LEVELS");
        System.out.println("....................................................................................................................");
        CustomizedBinaryTreeNew<Integer> tree = new CustomizedBinaryTreeNew<Integer>();

        // Add values by level
        List<Integer> intvalues = Arrays.asList(1,2,3,4,5,6,7,8,9);
        tree.addByLevel(intvalues);

        // Test the getLevel function
        int valueToFind = 4;
        int level = tree.getLevel(valueToFind);
        System.out.println(valueToFind + " is on level: " + level);

        System.out.println("Binary tree to array (In-order): " + tree.bstToArray(1));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("                                                                                                                    ");

        System.out.println("LINKED LIST");
        System.out.println("....................................................................................................................");
        LinkedListCustomizedNew<String> linkedList = new LinkedListCustomizedNew<String>();

        // Add elements to the list
        for (String car : cars) {
            linkedList.addLast(car);
        }

        // Print the elements of the list
        System.out.println("Original list: " + linkedList.convertToArray());

        // Test the getFirst() and getLast() methods
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());

        // Test the removeFirst() method
        linkedList.removeFirst();
        System.out.println("After removing the first element: " + linkedList.convertToArray());

        // Test the removeLast() method
        linkedList.removeLast();
        System.out.println("After removing the last element: " + linkedList.convertToArray());

        // Test the removeValue() method
        linkedList.removeValue("BMW");
        System.out.println("After removing the value BMW: " + linkedList.convertToArray());

        // Test the size() method
        System.out.println("Size of the list: " + linkedList.size());

        // Test the contains() method
        System.out.println("List contains Chevrolet : " + linkedList.contains("Chevrolet"
        ));
        System.out.println("List contains Cake : " + linkedList.contains("Cake"));

        // Test the sort() method
        System.out.println("Unsorted list: " + linkedList.convertToArray());
        linkedList.sort();
        System.out.println("Sorted list: " + linkedList.convertToArray());
    }

}




