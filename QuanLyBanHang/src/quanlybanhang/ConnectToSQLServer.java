/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class ConnectToSQLServer {
    public Connection conn ;
   
   public static Connection getConnection() {
        Connection conn = null ;
       try {
         String url = "jdbc:mysql://localhost:3306/mysqli_web?zeroDateTimeBehavior=CONVERT_TO_NULL";
        var user = "root";
        var password = "";
        conn = DriverManager.getConnection(url,user,password);
        if(conn==null){
            System.out.println("Kết nối MYSQL thành công");
            }else{
              System.out.println("Kết nối thành công !");
          }
     } catch (Exception e) {
          System.out.println(e.toString());
           e.printStackTrace();// TODO: handle exception
        }
        
    
//        Connection conn = null ;
//        try {
//            //databaseName=QLBH
//            String url = "jdbc:mysql://localhost:3306;";
//            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String username = "root";
//            String password = "";
//            conn = DriverManager.getConnection(url, username, password);
//            if(conn==null){
//                System.out.println("Kết nối không thành công");
//            }else{
//                System.out.println("Kết nối thành công !");
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            e.printStackTrace();// TODO: handle exception
//        }
       return conn;
    }
    public static void closeConnection(java.sql.Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    
    //đóng kết nối
    public void close() throws SQLException{
        if(this.conn!=null)
            this.conn.close();
    }
    /*Test xem SQL có liên kết dc không
    
    public static void main(String[] args) {
        Connection con=getConnection();
        if(con!=null){
            System.out.println("Ket noi thanh cong");
        }else{
            System.out.println("Ket noi that bai");
        }
    }

   /* public static void closeConnection(java.sql.Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
     public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    //Thực thi INSERT, DELETE, UPDATE
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
    
    /* Test xem SQL có liên kết dc không
    
    public static void main(String[] args) {
        Connection con=getConnection();
        if(con!=null){
            System.out.println("Ket noi thanh cong");
        }else{
            System.out.println("Ket noi that bai");
        }
    }*/

   
    
}
