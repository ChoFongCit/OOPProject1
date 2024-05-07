package pong.controller;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccess {
    private static DataAccess dataAccess = new DataAccess();
    Connection conn =  null;
    String url ;
    String user   ;
    String password    ;
    private DataAccess(){
         url = "jdbc:mysql://localhost:3306/mysql";
         user = "root";
         password = "root";
    }
    public static DataAccess getInstance(){
        return dataAccess;
    }
    public void saveDatabase(){
        try{
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to the database!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
