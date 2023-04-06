package com.dataStructure;
import javax.swing.JOptionPane;

import BinaryTree.CustomizedBinaryTree;
import BinaryTree.Node;
import HashMap.CustomizedHashMap;
import LinkedList.LinkedListCustomized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        //MainGui gui = new MainGui();

//        CustomizedBinaryTree binaryTree = new CustomizedBinaryTree();
//        Node node = new Node(7);
//        Node node2 = new Node(2);
//
//        binaryTree.addRecursive(node, 6);
//
////        binaryTree.add(1);
////        binaryTree.add(2);
////        binaryTree.add(3);
////        binaryTree.add(4);
//        binaryTree.add(5);
//
//       System.out.println(binaryTree.findSmallestValue(node));
        //System.out.println(binaryTree.getSize());

        //binaryTree.traversePreOrder(node);
        // BinaryTree createBinaryTree() {
            CustomizedBinaryTree bt = new CustomizedBinaryTree();

            bt.add(6);
            bt.add(4);
            bt.add(8);
            bt.add(3);
            bt.add(5);
            bt.add(7);
            bt.add(9);
        System.out.println(bt);



//        System.out.println(it.next());
//
//        CustomizedHashMap<Integer, String> output = new CustomizedHashMap<Integer, String>(names.length);
//
//        //        From Int Array to HAshmap
////
//        String[] keys = new String[names.length];
////        String[] values = new String[names.length];
////
////
//        for (int i = 0; i< names.length; i++){
//            keys[i] = Integer.toString(i);
////            values[i] = Integer.toString(names[i]);
//        }
////
////
//        for (int i = 0; i< names.length; i++){
//            output.put(names[i],keys[i]);
//        }
//
//        System.out.println(output);
        }
//

}
