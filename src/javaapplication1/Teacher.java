/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SONY
 */
public class Teacher {
    private static Connection con;
    static{
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
     
    int[][] t1_flag=new int[6][6];
    int[][] t2_flag=new int[6][6];
    int[][] t3_flag=new int[6][6];
    int[][] t4_flag=new int[6][6];
    int[][] t5_flag=new int[6][6];
    int[][] t6_flag=new int[6][6];
    int[][] t7_flag=new int[6][6];
    int[][] t8_flag=new int[6][6];
    String t1,t2,t3,t4,t5,t6,t7,t8;
    
    static Connection getConnection() throws ClassNotFoundException, SQLException{
         return con;
    }
    static ResultSet fetchResult(String cls) throws SQLException{
        Statement stmt;
        ResultSet rs=null;
       
            stmt = con.createStatement();  
            String sql="select first_name,last_name,count from teacher t,allotment a where t.id=a.id and a.cls='"+cls+"';";
            rs=stmt.executeQuery(sql);
            //System.out.println();
        return rs;
      
    }
    
}
