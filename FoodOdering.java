package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;


public class FoodOdering implements ActionListener {
    JFrame frame = new JFrame("Food Odering Management System");
    JComboBox box;
    JButton order = new JButton("Order");
    JButton deliver = new JButton("Delivered");
    JTextArea textArea = new JTextArea();
    JLabel label1 = new JLabel("Customer Name");
    JLabel label2 = new JLabel("Food Item");
    JLabel label3 = new JLabel("Price");
    JLabel label4 = new JLabel("Address");
    JLabel label5 = new JLabel("Phone Number");

    JTextField field1 = new JTextField();
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();
    JTextField field5 = new JTextField();

    Queue<Object> foodqueue = new LinkedList<>();
    String name, food_item, price, address, number , print_data;
    int i = 0;

    FoodOdering() {
        String[] food = {"" , "Zinger", "Roll", "Chicken Burger" , "Pizza" , "Drink" , "Sandwich",
                         "French Fries"};
        box = new JComboBox(food);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        label1.setBounds(100, 10, 150, 50);
//        label1.setForeground(Color.red);
        label1.setFont(new Font("cambria", Font.BOLD, 18));
        label2.setBounds(100, 70, 130, 50);
//        label2.setForeground(Color.red);
        label2.setFont(new Font("cambria", Font.BOLD, 18));
        label3.setBounds(100, 140, 130, 50);
//        label3.setForeground(Color.red);
        label3.setFont(new Font("cambria", Font.BOLD, 18));
        label4.setBounds(100, 220, 150, 30);
        label4.setFont(new Font("cambria", Font.BOLD, 18));
//        label4.setForeground(Color.red);
        label5.setBounds(100, 300, 150, 30);
//        label5.setForeground(Color.red);
        label5.setFont(new Font("cambria", Font.BOLD, 18));
        field1.setBounds(300, 20, 200, 30);
        box.setBounds(300, 80, 200, 30);
        field3.setBounds(300, 150, 200, 30);
        field4.setBounds(300, 220, 200, 30);
        field5.setBounds(300, 300, 200, 30);

        order.setBounds(370, 610, 100, 40);
        deliver.setBounds(150, 610, 100, 40);
        textArea.setBounds(1, 350, 700, 250);
        textArea.setBackground(Color.white);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(field1);
        frame.add(box);
        frame.add(field3);
        frame.add(field4);
        frame.add(field5);
        frame.add(order);
        frame.add(deliver);

        order.addActionListener(this);
        deliver.addActionListener(this);
        frame.add(textArea);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == order) {

            if (field1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Customer Name");
            } else if (field3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Price");
            } else if (field4.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Address");
            } else if (field5.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Phone Number");
            } else {
                i++;
                name = field1.getText();
                food_item = (String) box.getSelectedItem();
                price = field3.getText();
                address = field4.getText();
                number = field5.getText();
                print_data = " " +i + "   Name:  " + name + "\tFood Item:  " + food_item + "\t" + "Price:  " + price + "\tAddress:  " + address + "\tNumber:  " + number + "\n";
                foodqueue.add(print_data);
                textArea.setText(foodqueue.toString());
                field1.setText(null);
                field3.setText(null);
                field4.setText(null);
                field5.setText(null);
            }
        } else if (e.getSource() == deliver) {
            if (foodqueue.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Order placed in a Queue");
            }
            try {
                foodqueue.remove();
            }catch (Exception e1){
                System.out.println("No order placed in Queue");
            }

            textArea.setText(foodqueue.toString());
        }
    }
    public static void main(String[] args) {
        new FoodOdering();
    }
}

