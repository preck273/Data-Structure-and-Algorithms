package com.dataStructure;

import LinkedList.LinkedListCustomized;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LinkedListGui implements ActionListener{

    JFrame frame;
    JTextField textField, resultField, timeField, linkedlistField;
    JButton[] arrayListButtons = new JButton [14];
    JButton sizeButton, addFirstButton,addLastButton, getButton,getFirstButton, getLastButton,
        removeFirstButton, removeLastButton,removeValueButton, clearButton, addAllButton,
         containsButton, descedingIteratorButton, showArrayButton;
    JPanel panel;

    LinkedListCustomized linkedList = new LinkedListCustomized();

    Font myFont = new Font("Calibri", Font.BOLD,30);

    LinkedListGui(){

        frame = new JFrame("ODE | LinkedList");
        frame.setSize(600,980);
        frame.setLayout(null);

//        Input textbox
        textField = new JTextField();
        textField.setBounds(75,100,450,50);
        textField.setFont(myFont);
//        textField.setEditable(false);

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
        sizeButton = new JButton("Size");
        addFirstButton = new JButton("AddFirst");
        addLastButton = new JButton("AddLast");
        getButton = new JButton("GetIndex");
        getFirstButton = new JButton("GetFirst");
        getLastButton = new JButton("GetLast");
        removeFirstButton = new JButton("RemoveFirst");
        removeLastButton = new JButton("RemoveLast");
        removeValueButton = new JButton("RemoveValue");
        clearButton = new JButton("Clear");
        addAllButton = new JButton("AddAll");
        containsButton = new JButton("Contains");
        descedingIteratorButton = new JButton("DescIterator");
        showArrayButton = new JButton("ShowArr");


        arrayListButtons[0] = sizeButton;
        arrayListButtons[1] = addFirstButton;
        arrayListButtons[2] = addLastButton;
        arrayListButtons[3] = getButton;
        arrayListButtons[4] = getFirstButton;
        arrayListButtons[5] = getLastButton;
        arrayListButtons[6] = removeFirstButton;
        arrayListButtons[7] = removeLastButton;
        arrayListButtons[8] = removeValueButton;
        arrayListButtons[9] = clearButton;
        arrayListButtons[10] = addAllButton;
        arrayListButtons[11] = containsButton;
        arrayListButtons[12] = descedingIteratorButton;
        arrayListButtons[13] = showArrayButton;

        for(int i=0;i<14;i++){
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
        panel.add(arrayListButtons[8]);
        panel.add(arrayListButtons[9]);
        panel.add(arrayListButtons[10]);
        panel.add(arrayListButtons[11]);
        panel.add(arrayListButtons[12]);
        panel.add(arrayListButtons[13]);

//        Push nav to screen
        frame.add(panel);

//        Add navigation
//        frame.remove(panel);
        frame.add(textField);
        frame.add(timeField);
        frame.add(resultField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == sizeButton) {
            long startTime = System.nanoTime();
            resultField.setText(Integer.toString(linkedList.size()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }

        if(e.getSource() == addFirstButton) {
            if(isEmpty()){
                resultField.setText("Enter an Integer value");
            }
            else{
                int input = Integer.parseInt(textField.getText());
                long startTime = System.nanoTime();
                linkedList.addFirst(input);
                long endTime   = System.nanoTime();
                long totalTime = (endTime - startTime);
                timeField.setText(Long.toString((totalTime))+ " nanoseconds");
                resultField.setText(Arrays.toString(linkedList.toArrayList()));
            }
        }
        if(e.getSource() == addLastButton) {
            if(isEmpty()){
                resultField.setText("Enter a list of Integers");
            }
            else{
                int input = Integer.parseInt(textField.getText());
                long startTime = System.nanoTime();
                linkedList.addLast(input);
                long endTime   = System.nanoTime();
                long totalTime = (endTime - startTime);
                timeField.setText(Long.toString((totalTime))+ " nanoseconds");
                resultField.setText(Arrays.toString(linkedList.toArrayList()));
            }
        }
        if(e.getSource() == getButton) {
            int input = Integer.parseInt(textField.getText());
            long startTime = System.nanoTime();
            resultField.setText(Integer.toString((Integer) linkedList.get(input)));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == getFirstButton) {
            long startTime = System.nanoTime();
            resultField.setText(Integer.toString((Integer) linkedList.getFirst()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == getLastButton) {
            long startTime = System.nanoTime();
            resultField.setText(Integer.toString((Integer) linkedList.getLast()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == removeFirstButton) {
            long startTime = System.nanoTime();
            linkedList.removeFirst();
            resultField.setText(Arrays.toString(linkedList.toArrayList()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == removeLastButton) {
            long startTime = System.nanoTime();
            linkedList.removeLast();
            resultField.setText(Arrays.toString(linkedList.toArrayList()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == removeValueButton) {
            int input = Integer.parseInt(textField.getText());
            long startTime = System.nanoTime();
            linkedList.removeValue(input);
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
            resultField.setText(Arrays.toString(linkedList.toArrayList()));
        }
        if(e.getSource() == clearButton) {
            long startTime = System.nanoTime();
            linkedList.clear();
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
            resultField.setText(Integer.toString(linkedList.size()));
        }
        if(e.getSource() == addAllButton) {
            long startTime = System.nanoTime();
            linkedList.addAll(stringtoArray(textField.getText()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
            resultField.setText(Arrays.toString(linkedList.toArrayList()));
        }
        if(e.getSource() == containsButton) {
            int input = Integer.parseInt(textField.getText());
            long startTime = System.nanoTime();
            resultField.setText(Boolean.toString(linkedList.contains(input)));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
        }
        if(e.getSource() == descedingIteratorButton) {
            long startTime = System.nanoTime();
            linkedList.descendingIterator();
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
            Iterator desc = linkedList.descendingIterator();
            List<Integer> descarr = new ArrayList<Integer>();
            while(desc.hasNext()){

            }
//            resultField.setText(Arrays.toString();
        }
        if(e.getSource() == showArrayButton) {
            long startTime = System.nanoTime();
            resultField.setText(Arrays.toString(linkedList.toArrayList()));
            long endTime   = System.nanoTime();
            long totalTime = (endTime - startTime);
            timeField.setText(Long.toString((totalTime))+ " nanoseconds");
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


