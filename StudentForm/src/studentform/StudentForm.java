/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studentform;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame implements ActionListener {

    JLabel lblHead,lblName,lblGender,lblMobile,lblEmail,lblCourse,lblEducation,lblRef;
    JTextField jtxtName,jtxtMobile,jtxtEmail,jtxtEducation;
    JComboBox jcbGender,jcbCourse,jcbRef;
    JButton jbButton,jbReset;
    
    
    StudentForm(){
        JFrame frame=new JFrame("Registration Form");
        frame.setBounds(250,100,600,550);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // setting Background color of frame
        Container con=frame.getContentPane();
        con.setLayout(null);
        con.setBackground(Color.yellow);
        
        JLabel lblHead=new JLabel("Student Form");
        lblHead.setBounds(200,5,250,40);
        con.add(lblHead);
        Font f=new Font("serif",Font.BOLD,30);
        lblHead.setFont(f);
        
        Font f1=new Font("serif",Font.BOLD,16);
        
        
        JLabel lblName=new JLabel("Name :");
        lblName.setBounds(50,80,100,30);
        con.add(lblName);
        lblName.setFont(f1);
        
        JLabel lblGender=new JLabel("Gender :");
        lblGender.setBounds(50,120,120,30);
        con.add(lblGender);
        lblGender.setFont(f1);
        
        JLabel lblMobile=new JLabel("Mobile No :");
        lblMobile.setBounds(50,160,140,30);
        con.add(lblMobile);
        lblMobile.setFont(f1);
        
        JLabel lblEmail=new JLabel("Email :");
        lblEmail.setBounds(50,200,160,30);
        con.add(lblEmail);
        lblEmail.setFont(f1);
        
        JLabel lblCourse=new JLabel("Course :");
        lblCourse.setBounds(50,240,200,30);
        con.add(lblCourse);
        lblCourse.setFont(f1);
        
        JLabel lblEducation=new JLabel("Education :");
        lblEducation.setBounds(50,280,240,30);
        con.add(lblEducation);
        lblEducation.setFont(f1);
        
        JLabel lblRef=new JLabel("Reference :");
        lblRef.setBounds(50,320,260,30);
        con.add(lblRef);
        lblRef.setFont(f1);
        
        jtxtName=new JTextField();
        jtxtName.setBounds(160,85,160,20);
        con.add(jtxtName);
        jtxtName.setFont(f1);
        
        String[] gen={"--select--","Male","Female"};
        jcbGender=new JComboBox(gen);
        jcbGender.setBounds(160,125,160,20);
        con.add(jcbGender);
        jcbGender.setFont(f1);
        
        jtxtMobile=new JTextField();
        jtxtMobile.setBounds(160,165,160,20);
        con.add(jtxtMobile);
        jtxtMobile.setFont(f1);
        
        jtxtEmail=new JTextField();
        jtxtEmail.setBounds(160,205,160,20);
        con.add(jtxtEmail);
        jtxtEmail.setFont(f1);
        
        String[] course={"--select--","RS-CIT","C","C++","Java(J2SE)","Cloud computing"};
        jcbCourse=new JComboBox(course);
        jcbCourse.setBounds(160,245,160,20);
        con.add(jcbCourse);
        jcbCourse.setFont(f1);
        
        jtxtEducation=new JTextField();
        jtxtEducation.setBounds(160,285,160,20);
        con.add(jtxtEducation);
        jtxtEducation.setFont(f1);
        
        String[] ref={"--select--","Newspaper","Friends","Pamphlet","Social media","website"};
        jcbRef=new JComboBox(ref);
        jcbRef.setBounds(160,325,160,20);
        con.add(jcbRef);
        jcbRef.setFont(f1);
        
        
         // Step 4 : Creating JButton for Sumbit
           this.jbButton=new JButton("Sumbit");
           jbButton.setBounds(60,395,90,20); 
           con.add(jbButton);
           jbButton.setBackground(Color.PINK);
           jbButton.setFont(f1);
           
           // Step 5 : Creating JButton for Sumbit
           this.jbReset=new JButton("Reset");
           jbReset.setBounds(200,395,90,20); 
           con.add(jbReset);
           jbReset.setBackground(Color.PINK);
           jbReset.setFont(f1);
        
            jbButton.addActionListener(this);
            jbReset.addActionListener(this);
        
        
    }
   
    public static void main(String[] args) {
        
        new StudentForm();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==jbButton){
             
              if((jtxtName.getText().equals("")||jcbGender.getSelectedItem().equals("")||jtxtMobile.getText().equals("")||jtxtEmail.getText().equals(""))||jcbCourse.getSelectedItem().equals("")||jtxtEducation.getText().equals("")||jcbRef.getSelectedItem().equals("")){
             
                JOptionPane.showMessageDialog(this,"Fill mandatory fields","Error Message",JOptionPane.ERROR_MESSAGE);
          
            }
            
            else{
                    
                String name=jtxtName.getText();
                String gender=(String)jcbGender.getSelectedItem();
                String mobile=jtxtMobile.getText();
                String email=jtxtEmail.getText();
                String cou=(String)jcbCourse.getSelectedItem();
                String education=jtxtEducation.getText();
                String ref1=(String)jcbRef.getSelectedItem(); 
             
                JOptionPane.showMessageDialog(this,"Data Registered Successfully");
          
                jtxtName.setText("");
                jcbGender.setSelectedIndex(0);
                jtxtMobile.setText("");
                jtxtEmail.setText("");
                jcbCourse.setSelectedIndex(0);
                jtxtEducation.setText("");
                jcbRef.setSelectedIndex(0);
                
                   
                    
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydbase","root","");
                PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
                
                
                
                
                ps.setString(1,name);
                ps.setString(2,gender);
                ps.setString(3,mobile);
                ps.setString(4,email);
                ps.setString(5, cou);
                ps.setString(6, education);
                ps.setString(7, ref1);
                
               int i=ps.executeUpdate();
                System.out.println(i+"record affected");
            }catch(Exception ex){
                System.out.println("Problem :"+ex);
            }
                    }
                     

        }
        
    }
      
}
