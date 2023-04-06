package com.dataStructure;

import LinkedList.LinkedListCustomized;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MainGui implements ActionListener{
    JFrame frame;

    JButton arraylistButton, hashmapButton, linkedlistButton;

    MainGui(){

        frame = new JFrame("ODE");
        frame.setSize(600,800);
        frame.setLayout(null);

//        Add Navaigation
        arraylistButton = new JButton("ArrayList");
        arraylistButton.addActionListener(this);
        arraylistButton.setFocusable (false);

        hashmapButton = new JButton("HashMap");
        hashmapButton.addActionListener(this);
        hashmapButton.setFocusable (false);

        linkedlistButton= new JButton("LinkedList");
        linkedlistButton.addActionListener(this);
        linkedlistButton.setFocusable (false);

//        Place Navigation buttons
        arraylistButton.setBounds(50,25,100,50);
        hashmapButton.setBounds(250,25,100,50);
        linkedlistButton.setBounds(450,25,100,50);

//        Push nav to screen
        frame.add(arraylistButton);
        frame.add(hashmapButton);
        frame.add(linkedlistButton);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == arraylistButton) {
            new ArrayListGui();
//            frame.dispose();
        }
        if(e.getSource() == linkedlistButton) {
            new LinkedListGui();
        }
        if(e.getSource() == hashmapButton) {
            new HashmapGui();
        }
    }
}
