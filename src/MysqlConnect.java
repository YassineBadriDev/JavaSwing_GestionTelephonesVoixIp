/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yassine
 */
import java.sql.*;
import javax.swing.*;

public class MysqlConnect {
    Connection conn =null;
    public static Connection ConnectDB(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mysl","root","");
   // JOptionPane.showMessageDialog(null,"acces succes DB");
    return conn;
    
    
    }
    catch(Exception e){JOptionPane.showMessageDialog(null, "erreur conn BD");}
        return null;
    
    
    
    }
}

