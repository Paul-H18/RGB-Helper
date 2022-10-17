package de.paul.main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    public static void main (String[] args) {

        Color frameBg = Color.DARK_GRAY, frameFg, buttonBg = Color.GRAY, text = Color.WHITE;

        int rgb[] = new int[3];

        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.setLayout(null);
        frame.setBounds(0,0, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.getContentPane().setBackground(frameBg);

        frame.setResizable(false);
        frame.setTitle("Color");

        JPanel jp = new JPanel();


        JTextField[] fields = new JTextField[3];
        JLabel[] labels = new JLabel[3];

        for (int i = 0; i < 3; i++) {
            fields[i] = new JTextField();
            labels[i] = new JLabel();

            fields[i].setVisible(true);
            labels[i].setVisible(true);

            fields[i].setBackground(buttonBg);
            fields[i].setForeground(text);
            fields[i].setBorder(new LineBorder(buttonBg));

            labels[i].setForeground(text);

        }

        fields[0].setBounds(50, 10, 120, 30);
        labels[0].setText("R:");
        labels[0].setBounds(10, 10, 30, 30);

        fields[1].setBounds(50, 50, 120, 30);
        labels[1].setText("G:");
        labels[1].setBounds(10, 50, 30, 30);

        fields[2].setBounds(50, 90, 120, 30);
        labels[2].setText("B:");
        labels[2].setBounds(10, 90, 30, 30);

        JButton button = new JButton();
        button.setText("Display");
        button.setBounds(50, 130, 120, 30);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 3; i++) {
                    if(Integer.parseInt(fields[i].getText()) <= 255 && Integer.parseInt(fields[i].getText()) >= 0) {
                        rgb[i] = Integer.parseInt(fields[i].getText());
                    }
                    System.out.println(rgb[i]);
                }
                jp.setBackground(new Color(rgb[0], rgb[1], rgb[2]));

            }
        });

        jp.setBackground(Color.black);
        jp.setBorder(new LineBorder(Color.GRAY));
        jp.setBounds(200, 10, 160, 160);



        button.setBackground(buttonBg);
        button.setForeground(text);


        for (int i = 0; i < 3; i++) {
            frame.add(fields[i]);
            frame.add(labels[i]);
        }
        frame.add(jp);
        frame.add(button);
        frame.repaint();

    }
}
