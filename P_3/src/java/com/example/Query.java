package com.example;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Query {
    public static Connection con;

    static {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "wreck");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //INSERT
    public static void insert(int id,String name,String email,String branch,String gender,String dob,String year,String phone) throws Exception
    {
        String sql="INSERT INTO students(id, name, email, branch, gender, dob, year, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setString(3,email);
        ps.setString(4,branch);
        ps.setString(5,gender);
        ps.setString(6,dob);
        ps.setString(7,year);
        ps.setString(8,phone);
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }
    }

    //DELETE
    public static void delete(int id) throws Exception
    {

        String sql="DELETE FROM STUDENTS WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully.");
        } else {
            System.out.println("Failed to delete data.");
        }
    }
    
    public static void setStrings(PreparedStatement stmt,Connection con,int id,String value,String query) throws Exception
    {
        stmt=con.prepareStatement(query);
        stmt.setString(1, value);
        stmt.setInt(2,id);
        stmt.execute();        
    }
    

    //SEARCH
   public static String searchQuery = "select * from students where id=?";
   
   
   //UPDATE
    public static void updateName(int id,String name) throws SQLException 
    {
       String sql = "update students set name=? where id=?";
       PreparedStatement stmt =con.prepareStatement(sql);
       stmt.setString(1, name);
       stmt.setInt(2,id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
  
    }
    
    public static void updateEmail(int id,String email) throws SQLException 
    {
       String sql = "update students set email=? where id=?";
       PreparedStatement stmt =con.prepareStatement(sql);
       stmt.setString(1, email);
       stmt.setInt(2,id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
  
    }
    
    public static void updateBranch(int id,String branch) throws SQLException 
    {
       String sql = "update students set branch=? where id=?";
       PreparedStatement stmt =con.prepareStatement(sql);
       stmt.setString(1, branch);
       stmt.setInt(2,id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
  
    }
    
    public static void updateGender(int id,String gender) throws SQLException 
    {
       String sql = "update students set gender=? where id=?";
       PreparedStatement stmt =con.prepareStatement(sql);
       stmt.setString(1, gender);
       stmt.setInt(2,id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
  
    }
    
    public static void updateDOB(int id,String dob) throws SQLException 
    {
       String sql = "update students set dob=? where id=?";
       PreparedStatement stmt =con.prepareStatement(sql);
       stmt.setString(1, dob);
       stmt.setInt(2,id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
  
    }
    
    public static void updateYear(int id,String year) throws SQLException 
    {
       String sql = "update students set year=? where id=?";
       PreparedStatement stmt =con.prepareStatement(sql);
       stmt.setString(1, year);
       stmt.setInt(2,id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
  
    }
    
    public static void updatePhone(int id,String phone) throws SQLException 
    {
       String sql = "update students set phone=? where id=?";
       PreparedStatement stmt =con.prepareStatement(sql);
       stmt.setString(1, phone);
       stmt.setInt(2,id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
  
    }
       
}

