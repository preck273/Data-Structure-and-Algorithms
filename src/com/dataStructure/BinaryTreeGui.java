package com.dataStructure;

import BinaryTree.CustomizedBinaryTree;
import LinkedList.LinkedListCustomized;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class BinaryTreeGui implements ActionListener{

    JFrame frame;
    JTextField textField, hintField, resultField, timeField;
    JButton[] arrayListButtons = new JButton [8];
    JButton addButton, addAllButton, containsButton, isEmptyButton,sizeButton, findSmallestButton, deleteButton, showArrayButton;
    JPanel panel;

    CustomizedBinaryTree bt = new CustomizedBinaryTree();

    Font myFont = new Font("Calibri", Font.BOLD,30);

    String input, result;

    String operator; // change to action

    BinaryTreeGui(){

        frame = new JFrame("ODE | BinaryTree");
        frame.setSize(600,800);
        frame.setLayout(null);

//        Input textbox
        textField = new JTextField();
        textField.setBounds(75,100,450,50);
        textField.setFont(myFont);
//        textField.setEditable(false);

        //        hint textbox
        hintField = new JTextField();
        hintField.setBounds(10,50,550,50);
//        hintField.setFont(myFont);
        hintField.setText("Hint: Type 1: traverseInOrder, Type 2: traversePreOrder,Type 3: traversePostOrder before Show Array");
        hintField.setEditable(false);

        //        Time textbox
        timeField = new JTextField();
        timeField.setBounds(75,650,450,50);
        timeField.setFont(myFont);
        timeField.setEditable(false);

        //        Input result
        resultField = new JTextField();
        resultField.setBounds(75,700,450,50);
        resultField.setFont(myFont);
        resultField.setEditable(false);

//        Add ArrayList Buttons
        addButton = new JButton("Add");
        addAllButton = new JButton("Addall");
        containsButton = new JButton("Contains");
        isEmptyButton = new JButton("IsEmpty");
        sizeButton = new JButton("Size");
        findSmallestButton = new JButton("FindSmallest");
        deleteButton = new JButton("Delete");
        showArrayButton = new JButton("Show Array");

        arrayListButtons[0] = addButton;
        arrayListButtons[1] = addAllButton;
        arrayListButtons[2] = containsButton;
        arrayListButtons[3] = isEmptyButton;
        arrayListButtons[4] = sizeButton;
        arrayListButtons[5] = findSmallestButton;
        arrayListButtons[6] = deleteButton;
        arrayListButtons[7] = showArrayButton;

        for(int i=0;i<8;i++){
            arrayListButtons[i].addActionListener(this);
            arrayListButtons[i].setFont(myFont);
            arrayListButtons[i].setFocusable (false);
        }

//       Print to panel
        panel = new JPanel();
        panel.setBounds(50,160,500,450);
        panel.setLayout(new GridLayout(10,4,10,10));
//        panel.setBackground(Color.GRAY);

        panel.add(arrayListButtons[0]);
        panel.add(arrayListButtons[1]);
        panel.add(arrayListButtons[2]);
        panel.add(arrayListButtons[3]);
        panel.add(arrayListButtons[4]);
        panel.add(arrayListButtons[5]);
        panel.add(arrayListButtons[6]);
        panel.add(arrayListButtons[7]);

//        Push nav to screen

        frame.add(panel);

//        Add navigation
//        frame.remove(panel);
        frame.add(textField);
        frame.add(hintField);
        frame.add(timeField);
        frame.add(resultField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showArrayButton) {
            if(isEmpty()){
                resultField.setText("Enter an Integer value");
            }
            int input = Integer.parseInt(textField.getText());
            long startTime = System.nanoTime();
            resultField.setText(bt.bsttoArray(input).toString());
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == addButton) {
            if(isEmpty()){
                resultField.setText("Enter an Integer value");
            }
            else{
                int input = Integer.parseInt(textField.getText());
                long startTime = System.nanoTime();
                bt.add(input);
                long endTime   = System.nanoTime();
                long totalTime = (endTime - startTime);
                timeField.setText(Long.toString((totalTime))+ " nanoseconds");
                resultField.setText((bt.bsttoArray(1).toString()));
            }
        }
        if(e.getSource() == containsButton) {
            long startTime = System.nanoTime();

            if(bt.containsNode(Integer.parseInt(textField.getText()))){
                resultField.setText(Boolean.toString(bt.containsNode(Integer.parseInt(textField.getText()))));
            }
            else{
                resultField.setText("false");
            }

            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == isEmptyButton) {
            long startTime = System.nanoTime();
            resultField.setText(Boolean.toString(bt.isEmpty()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == sizeButton) {
            long startTime = System.nanoTime();
            resultField.setText(Integer.toString(bt.getSize()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == findSmallestButton) {
            long startTime = System.nanoTime();
            resultField.setText(Integer.toString(bt.findSmallestValue(bt.getTree())));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == deleteButton) {
            int input = Integer.parseInt(textField.getText());
            long startTime = System.nanoTime();
            bt.delete(input);
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
            resultField.setText((bt.bsttoArray(1).toString()));

        }
    }

    public boolean isEmpty(){
        if(textField.getText().equals("")){
            return true;
        }
        return false;
    }

    public Integer[] stringtoArray(String name){
        String[] string = name.replaceAll("\\[", "")
            .replaceAll("]", "")
            .split(",");

        // declaring an array with the size of string
        Integer[] arr = new Integer[string.length];

        // parsing the String argument as a signed decimal
        // integer object and storing that integer into the
        // array
        for (int i = 0; i < string.length; i++) {
            arr[i] = Integer.valueOf(string[i]);
        }

        return arr;
    }

}


