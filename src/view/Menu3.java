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
import java.util.ArrayList;
import controller.Controller;

public class Menu3 implements ActionListener{
    static DatabaseHandler conn = new DatabaseHandler();
    JFrame inMahFrame = new JFrame();
    
    JLabel labTitle = new JLabel("Insert Data Mahasiswa Baru");
    JLabel labNIM = new JLabel("NIM : ");
    JLabel labNama = new JLabel("Nama : ");
    JLabel labAngkatan = new JLabel("Angkatan : ");
    JLabel labKodJur = new JLabel("Kode Jurusan : ");
    
    
    JTextField tfNIM = new JTextField();
    JTextField tfNama = new JTextField();
    JTextField tfAngkatan = new JTextField();
    ArrayList<String> listKodJur = Controller.getAllJurusan();
    String[] kodeJurusan = GetStringArray(listKodJur);
    JComboBox cbKodJur = new JComboBox(kodeJurusan);
    
    JButton btnInMah = new JButton("Insert Mahasiswa");
    
    public Menu3(){
        inMahFrame.setSize(500,350);
        inMahFrame.setLocationRelativeTo(null);
        inMahFrame.setLayout(null);
        inMahFrame.setVisible(true);
        
        labTitle.setBounds(150,30, 200,20);
        labNIM.setBounds(50,50, 100,20);
        labNama.setBounds(50,80, 100,20);
        labAngkatan.setBounds(50,110, 100,20);
        labKodJur.setBounds(50,140, 100,20);
        
        tfNIM.setBounds(170,50, 100,20);
        tfNama.setBounds(170,80, 100,20);
        tfAngkatan.setBounds(170,110, 100,20);
        cbKodJur.setBounds(170,140, 100,20);
        
        btnInMah.setBounds(250,250, 150,20);
        btnInMah.setActionCommand("Insert Mahasiswa");
        btnInMah.addActionListener(this);
        
        inMahFrame.add(labTitle);
        inMahFrame.add(labNIM);
        inMahFrame.add(labNama);
        inMahFrame.add(labAngkatan);
        inMahFrame.add(labKodJur);
        inMahFrame.add(tfNIM);
        inMahFrame.add(tfNama);
        inMahFrame.add(tfAngkatan);
        inMahFrame.add(cbKodJur);
        inMahFrame.add(btnInMah);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch(command){
            case "Insert Mahasiswa":
                conn.connect();
                String query = "INSERT INTO mahasiswa VALUES(?,?,?,?)";
                try {
                    PreparedStatement stmt = conn.con.prepareStatement(query);
                    stmt.setString(1, tfNIM.getText());
                    stmt.setString(2, tfNama.getText());
                    stmt.setInt(3, Integer.parseInt(tfAngkatan.getText()));
                    stmt.setString(4, cbKodJur.getSelectedItem().toString());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(inMahFrame,"Mahasiswa telah berhasil ditambahkan!");
                    inMahFrame.dispose();
                    new MainMenu();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
