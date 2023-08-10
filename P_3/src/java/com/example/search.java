/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example;

import static com.example.Query.con;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rajda
 */
@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        int search_id = Integer.parseInt(req.getParameter("view_data"));
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "wreck");
        
        PreparedStatement stmt;
        stmt = con.prepareStatement(Query.searchQuery);
        stmt.setInt(1, search_id);
        ResultSet rs = stmt.executeQuery();
       
        boolean flag = false;
        
        PrintWriter out = response.getWriter();
        out.println("<p>Student Data</p>");
        out.println("<html><head><style>p{font-weight:700;font-size:30px;text-align: center;}table{ margin-left: auto;margin-right:auto;}th,tr,td{font-size:20px;text-align: center;}</style></head><body>");
        out.println("<table border=4 width=60% height=20%>");  
        out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Branch</th><th>Gender</th><th>DOB</th><th>Year</th><th>Phone</th><tr>");  
        while (rs.next()) 
        {  
            flag=true;
            out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("name") + "</td><td>" + rs.getString("email") + "</td><td>" + rs.getString("branch") + "</td><td>" + rs.getString("gender") + "</td><td>" + rs.getString("dob") + "</td><td>" + rs.getString("year") + "</td><td>" + rs.getString("phone") + "</td></tr>");   
        }  
        out.println("</table>");  
        if(!flag)
        {
            out.println("<script>alert('Data Does Not Exist! Try Again :)');window.location.replace('index.html');</script>");
        }

        out.println("</body></html>");
    }
 
        
         // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
       {
            processRequest(request, response);
       }
       catch(Exception e){} 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
       {
            processRequest(request, response);
       }
       catch(Exception e){} 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
