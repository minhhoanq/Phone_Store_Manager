/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Minh Hoanfg
 */
public class dbConnect {
    public static Connection getConnection() throws SQLException{
        try { 
            Connection cons = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //giao thức TLS - Transport Layer Security, mô hình thuật toán RSA
            cons = (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databasename=db_QLCHDT; user=sa; password=123456789;" + 
                    "encrypt=true; trustServerCertificate=true; sslProtocol=TLSv1.2");
            return cons;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) throws SQLException, IOException {
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    }
}
