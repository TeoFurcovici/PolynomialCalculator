package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UI extends  JFrame{
    //declarations zone for UI
    /*
    Here i declare all the GUI components that I used for constructing the interface. Then, in the next section (i.e in the constructor) I
    set the bounds for each of them and also add them to the panel, so that it can be visible to the user.
    Beside this, I also add the getters and setters for the JTextField dedicated to polynomial, because these are the only ones that I use
    during the development of this application.
    Then in the last part are the declarations for the buttons event handling, one method for each button.
     */
    public JLabel firstPolyLabel=new JLabel("First Polynomial:");
    public JLabel secondPolyLabel=new JLabel("Second Polynomial:");
    public JLabel resultLabel=new JLabel("The result is:");
    public JLabel chooseOpLabel=new JLabel("Choose what operation to perform:");
    public JTextField firstPolyText=new JTextField();
    public JTextField secondPolyText=new JTextField();
    public JTextField resultPolyText=new JTextField();
    public JButton addButton=new JButton("ADDITION");
    public JButton subtractButton=new JButton("SUBTRACTION");
    public JButton mulButton=new JButton("MULTIPLICATION");
    public JButton divisionButton=new JButton("DIVISION");
    public JButton derivButtonPoly1=new JButton("DERIVATION Poly1");
    public JButton derivButtonPoly2=new JButton("DERIVATION Poly2");
    public JButton integrButtonPoly1=new JButton("INTEGRATION Poly1");
    public JButton integrButtonPoly2=new JButton("INTEGRATION Poly2");
   public JButton clearButton=new JButton("CLEAR!");

    public String getFirstPolyText() {
        return firstPolyText.getText().toString();
    }

    public void setFirstPolyText(String string) {
        firstPolyText.setText(string);
    }

    public String getSecondPolyText() {
        return secondPolyText.getText().toString();
    }

    public void setSecondPolyText(String string) {
        secondPolyText.setText(string);
    }

    public void setResultPolyText(String string) {
        resultPolyText.setText(string);
    }



    public UI() {
        JFrame frame=new JFrame();
        frame.setSize(498,476);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        panel.setBackground(Color.decode("#ccd9ff"));
        panel.setLayout(null);
        frame.add(panel);



        firstPolyLabel.setBounds(7,7,120,25);
        secondPolyLabel.setBounds(7,47,130,25);
        resultLabel.setBounds(7,77,130,25);
        chooseOpLabel.setBounds(107,107,250,25);
        firstPolyText.setBounds(125,10,165,25);
        secondPolyText.setBounds(140,48,165,25);
        resultPolyText.setBounds(110,76,200,25);
        addButton.setBounds(20,140,175,35);
        subtractButton.setBounds(20,180,175,35);
        mulButton.setBounds(20,220,175,35);
        divisionButton.setBounds(270,140,175,35);
        derivButtonPoly1.setBounds(270,180,175,35);
        derivButtonPoly2.setBounds(270,220,175,35);
        integrButtonPoly1.setBounds(137,260,195,35);
        integrButtonPoly2.setBounds(137,300,195,35);
        clearButton.setBounds(137,340,195,35);


        firstPolyLabel.setFont(new Font("Serif",Font.BOLD,15));
        secondPolyLabel.setFont(new Font("Serif",Font.BOLD,15));
        resultLabel.setFont(new Font("Serif",Font.BOLD,15));
        chooseOpLabel.setFont(new Font("Serif",Font.BOLD,15));
        addButton.setFont(new Font("Serif",Font.BOLD,15));
        subtractButton.setFont(new Font("Serif",Font.BOLD,15));
        mulButton.setFont(new Font("Serif",Font.BOLD,15));
        divisionButton.setFont(new Font("Serif",Font.BOLD,15));
        derivButtonPoly1.setFont(new Font("Serif",Font.BOLD,15));
        derivButtonPoly2.setFont(new Font("Serif",Font.BOLD,15));
        integrButtonPoly1.setFont(new Font("Serif",Font.BOLD,15));
        integrButtonPoly2.setFont(new Font("Serif",Font.BOLD,15));
        clearButton.setFont(new Font("Serif",Font.BOLD,15));




        panel.add(secondPolyLabel);
        panel.add(firstPolyLabel);
        panel.add(resultLabel);
        panel.add(firstPolyText);
        panel.add(secondPolyText);
        panel.add(resultPolyText);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(mulButton);
        panel.add(divisionButton);
        panel.add(derivButtonPoly1);
        panel.add(derivButtonPoly2);
        panel.add(integrButtonPoly1);
        panel.add(integrButtonPoly2);
        panel.add(chooseOpLabel);
        panel.add(clearButton);

    }
    public void clearButtonAction ( ActionListener actionListener)
    {
        clearButton.addActionListener(actionListener);
    }
    public void additionButtonAction ( ActionListener actionListener)
    {
        addButton.addActionListener(actionListener);
    }
    public void subtractButtonAction ( ActionListener actionListener)
    {
        subtractButton.addActionListener(actionListener);
    }
    public void multiplicationButtonAction ( ActionListener actionListener)
    {
        mulButton.addActionListener(actionListener);
    }
    public void divisionButtonAction ( ActionListener actionListener)
    {
        divisionButton.addActionListener(actionListener);
    }
    public void derivationButtonActionPoly1 ( ActionListener actionListener)
    {
        derivButtonPoly1.addActionListener(actionListener);
    }
    public void derivationButtonActionPoly2 ( ActionListener actionListener)
    {
        derivButtonPoly2.addActionListener(actionListener);
    }
    public void integrationButtonActionPoly1 ( ActionListener actionListener)
    {
        integrButtonPoly1.addActionListener(actionListener);
    }
    public void integrationButtonActionPoly2 (final ActionListener actionListener)
    {
        integrButtonPoly2.addActionListener(actionListener);
    }
}
