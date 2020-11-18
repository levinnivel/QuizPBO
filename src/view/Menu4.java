/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
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
import java.util.ArrayList;

public class Menu4 implements ActionListener{
    static DatabaseHandler conn = new DatabaseHandler();
    JFrame perJurFrame = new JFrame();
    
    JLabel labTitle = new JLabel("Lihat Data Mahasiswa Per Jurusan");
    
    ArrayList<String> listKodJur = Controller.getAllJurusan();
    String[] kodeJurusan = GetStringArray(listKodJur);
    
    Object data[][]={
        {"1119003","Levin", "2019", "A"}
    };    
    String column[]={"NIM","Nama","Angkatan", "Kode Jurusan"};   
    
    JTable tabMahasiswa = new JTable(data, column);
    JComboBox cbKodJur = new JComboBox(kodeJurusan);
    JButton btnBack = new JButton("Back");
    
    public Menu4(){
        perJurFrame.setSize(500,600);
        perJurFrame.setLocationRelativeTo(null);
        perJurFrame.setLayout(null);
        perJurFrame.setVisible(true);
        
        labTitle.setBounds(150,30, 200,20);
        cbKodJur.setBounds(10,30, 100,20);
        JScrollPane sp = new JScrollPane(tabMahasiswa);
        sp.setBounds(50,50, 300,500);
        
        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);
        btnBack.setBounds(10,10, 100,20);
        
        perJurFrame.add(labTitle);
        perJurFrame.add(cbKodJur);
        perJurFrame.add(sp);
        perJurFrame.add(btnBack);
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch(command){
            case "Back":
                perJurFrame.dispose();
                new MainMenu();
            break;
        }
    }
    
    public static String[] GetStringArray(ArrayList<String> arr) 
    { 
  
        // declaration and initialise String Array 
        String str[] = new String[arr.size()]; 
  
        // Convert ArrayList to object array 
        Object[] objArr = arr.toArray(); 
  
        // Iterating and converting to String 
        int i = 0; 
        for (Object obj : objArr) { 
            str[i++] = (String)obj; 
        } 
  
        return str; 
    } 
}
