package com.dataStructure;

import LinkedList.LinkedListCustomized;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Gui implements ActionListener{

    JFrame frame;
    JTextField textField, resultField;
    JButton[] arrayListButtons = new JButton [9];
    JButton addButton, addAllButton, removeButton, removeAllButton,sizeButton, containsButton, indexButton, sortButton, showArrayButton;
    JButton arraylistButton, hashmapButton, linkedlistButton;
    JPanel panel;

    ArrayListCustomised arrayList = new ArrayListCustomised(5);
    LinkedListCustomized linkedList = new LinkedListCustomized();

    Font myFont = new Font("Calibri", Font.BOLD,30);

    String input, result;

    String operator; // change to action

    Gui(){

        frame = new JFrame("ODE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setLayout(null);

//        Input textbox
        textField = new JTextField();
        textField.setBounds(75,100,450,50);
        textField.setFont(myFont);
//        textField.setEditable(false);

        //        Input result
        resultField = new JTextField();
        resultField.setBounds(75,700,450,50);
        resultField.setFont(myFont);
        resultField.setEditable(false);

//        Add ArrayList Buttons
        addButton = new JButton("Add");
        addAllButton = new JButton("Addall");
        removeButton = new JButton("Remove");
        removeAllButton = new JButton("RemoveAll");
        sizeButton = new JButton("Size");
        containsButton = new JButton("Contains");
        indexButton = new JButton("GetIndex");
        sortButton = new JButton("Sort");
        showArrayButton = new JButton("Show Array");

        arrayListButtons[0] = addButton;
        arrayListButtons[1] = addAllButton;
        arrayListButtons[2] = removeButton;
        arrayListButtons[3] = removeAllButton;
        arrayListButtons[4] = sizeButton;
        arrayListButtons[5] = containsButton;
        arrayListButtons[6] = indexButton;
        arrayListButtons[7] = sortButton;
        arrayListButtons[8] = showArrayButton;

        for(int i=0;i<9;i++){
            arrayListButtons[i].addActionListener(this);
            arrayListButtons[i].setFont(myFont);
            arrayListButtons[i].setFocusable (false);
        }

//        Add Navaigation
        arraylistButton = new JButton("ArrayList");
        hashmapButton = new JButton("HashMap");
        linkedlistButton= new JButton("LinkedList");

//        Place Navigation buttons
        arraylistButton.setBounds(50,25,100,50);
        hashmapButton.setBounds(250,25,100,50);
        linkedlistButton.setBounds(450,25,100,50);

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

//        Push nav to screen
        frame.add(arraylistButton);
        frame.add(hashmapButton);
        frame.add(linkedlistButton);

        frame.add(panel);

//        Add navigation
//        frame.remove(panel);
        frame.add(textField);
        frame.add(resultField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showArrayButton) {
            resultField.setText(Arrays.toString(arrayList.toArray()));
        }
        if(e.getSource() == addButton) {
            if(isEmpty()){
                resultField.setText("Enter an Integer value");
            }
            else{
                int input = Integer.parseInt(textField.getText());
                arrayList.add(input);
                resultField.setText(Arrays.toString(arrayList.toArray()));
            }
        }
        if(e.getSource() == addAllButton) {
            if(isEmpty()){
                resultField.setText("Enter a list of Integers");
            }
            else{
                arrayList.addall(stringtoArray(textField.getText()));
                resultField.setText(Arrays.toString(arrayList.toArray()));
            }
        }
        if(e.getSource() == removeButton) {
            int input = Integer.parseInt(textField.getText());
            arrayList.remove(input);
            resultField.setText(Arrays.toString(arrayList.toArray()));
        }
        if(e.getSource() == removeAllButton) {
            arrayList.removeAll();
            resultField.setText(Arrays.toString(arrayList.toArray()));
        }
        if(e.getSource() == sizeButton) {
            resultField.setText(Integer.toString(arrayList.getArrSize()));
        }
        if(e.getSource() == containsButton) {
            if(arrayList.contains(Integer.parseInt(textField.getText()))){
                resultField.setText(Boolean.toString(arrayList.contains(Integer.parseInt(textField.getText()))));
            }
            else{
                resultField.setText("false");
            }
        }
        if(e.getSource() == indexButton) {
            int input = Integer.parseInt(textField.getText());
            resultField.setText(Integer.toString(arrayList.indexof(input)));
        }
        if(e.getSource() == sortButton) {
            resultField.setText(Arrays.toString(arrayList.arrSort()));
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
