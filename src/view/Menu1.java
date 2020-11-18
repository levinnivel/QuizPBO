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

public class Menu1 implements ActionListener{
    static DatabaseHandler conn = new DatabaseHandler();
    JFrame inJurFrame = new JFrame();
    
    JLabel labTitle = new JLabel("Insert Data Jurusan Baru");
    JLabel labKode = new JLabel("Kode : ");
    JLabel labNama = new JLabel("Nama : ");
    
    JTextField tfKode = new JTextField();
    JTextField tfNama = new JTextField();
    
    JButton btnInJur = new JButton("Insert Jurusan");
    
    public Menu1(){
        inJurFrame.setSize(500,350);
        inJurFrame.setLocationRelativeTo(null);
        inJurFrame.setLayout(null);
        inJurFrame.setVisible(true);
        
        labTitle.setBounds(150,30, 200,20);
        labKode.setBounds(50,70, 100,20);
        labNama.setBounds(50,100, 100,20);
        
        tfKode.setBounds(170,70, 100,20);
        tfNama.setBounds(170,100, 100,20);
        
        btnInJur.setBounds(250,250, 150,20);
        btnInJur.setActionCommand("Insert Jurusan");
        btnInJur.addActionListener(this);
        
        inJurFrame.add(labTitle);
        inJurFrame.add(labKode);
        inJurFrame.add(labNama);
        inJurFrame.add(tfKode);
        inJurFrame.add(tfNama);
        inJurFrame.add(btnInJur);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch(command){
            case "Insert Jurusan":
                conn.connect();
                String query = "INSERT INTO jurusan VALUES(?,?)";
                try {
                    PreparedStatement stmt = conn.con.prepareStatement(query);
                    stmt.setString(1, tfKode.getText());
                    stmt.setString(2, tfNama.getText());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(inJurFrame,"Jurusan telah berhasil ditambahkan!");
                    inJurFrame.dispose();
                    new MainMenu();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            break;
        }
    }
}
