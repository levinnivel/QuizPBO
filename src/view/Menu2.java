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
import controller.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu2 implements ActionListener{
    static DatabaseHandler conn = new DatabaseHandler();
    JFrame allJurFrame = new JFrame();
    
    JLabel labTitle = new JLabel("Lihat Data Semua Jurusan");
    
    Object data[][]={
        {"ABC","Mat"}
    };    
    String column[]={"Kode","Nama"};   
    
    JTable tabJurusan = new JTable(data, column);
    
    JButton btnBack = new JButton("Back");
    
    public Menu2(){
        allJurFrame.setSize(500,600);
        allJurFrame.setLocationRelativeTo(null);
        allJurFrame.setLayout(null);
        allJurFrame.setVisible(true);
        
        labTitle.setBounds(150,30, 200,20);
        JScrollPane sp = new JScrollPane(tabJurusan);
        sp.setBounds(50,50, 300,500);
        
        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);
        btnBack.setBounds(10,10, 100,20);
        
        allJurFrame.add(labTitle);
        allJurFrame.add(sp);
        allJurFrame.add(btnBack);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch(command){
            case "Back":
                allJurFrame.dispose();
                new MainMenu();
            break;
        }
    }
}
