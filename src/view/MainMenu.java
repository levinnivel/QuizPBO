/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainMenu implements ActionListener{
    JFrame mainFrame = new JFrame();
    
    JLabel labTitle = new JLabel("Main Menu");
    
    JButton btnMenu1 = new JButton("Insert Data Jurusan Baru");
    JButton btnMenu2 = new JButton("Lihat Data Semua Jurusan");
    JButton btnMenu3 = new JButton("Insert Data Mahasiswa Baru");
    JButton btnMenu4 = new JButton("Lihat Data Mahasiswa Per Jurusan");
    
    public MainMenu(){
        mainFrame.setSize(500,400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        
        labTitle.setBounds(200,40, 100, 20);
        
        btnMenu1.setActionCommand("1");
        btnMenu1.addActionListener(this);
        btnMenu1.setBounds(150,100, 200,40);
        
        btnMenu2.setActionCommand("2");
        btnMenu2.addActionListener(this);
        btnMenu2.setBounds(150,150, 200,40);
        
        btnMenu3.setActionCommand("3");
        btnMenu3.addActionListener(this);
        btnMenu3.setBounds(150,200, 200,40);
        
        btnMenu4.setActionCommand("4");
        btnMenu4.addActionListener(this);
        btnMenu4.setBounds(150,250, 200,40);
        
        mainFrame.add(labTitle);
        mainFrame.add(btnMenu1);
        mainFrame.add(btnMenu2);
        mainFrame.add(btnMenu3);
        mainFrame.add(btnMenu4);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch(command){
            case "1":
                mainFrame.dispose();
                new Menu1();
            break;
            case "2":
                mainFrame.dispose();
                new Menu2();
            break;
            case "3":
                mainFrame.dispose();
                new Menu3();
            break;
            case "4":
                mainFrame.dispose();
                new Menu4();
            break;
        }
    }
}
