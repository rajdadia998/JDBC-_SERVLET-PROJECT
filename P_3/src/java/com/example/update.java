/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rajda
 */
@WebServlet(name = "update", urlPatterns = {"/update"})
public class update extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try  {
            String enroll=req.getParameter("id");
            String name=req.getParameter("name");
            String email=req.getParameter("email");
            String branch=req.getParameter("branch");
            String gender=req.getParameter("gender");
            String dob=req.getParameter("dob");
            String year=req.getParameter("year");
            String phone=req.getParameter("phone");
            
            boolean name_c = Boolean.parseBoolean(req.getParameter("u_name"));
            boolean email_c = Boolean.parseBoolean(req.getParameter("u_email"));
            boolean branch_c = Boolean.parseBoolean(req.getParameter("u_branch"));
            boolean gender_c = Boolean.parseBoolean(req.getParameter("u_gender"));
            boolean dob_c = Boolean.parseBoolean(req.getParameter("u_dob"));
            boolean year_c = Boolean.parseBoolean(req.getParameter("u_year"));
            boolean phone_c =Boolean.parseBoolean( req.getParameter("u_phone"));
            
            int id = Integer.parseInt(enroll);
              if(name_c)
            {
                Query.updateName(id, name);
            }
            if(email_c)
            {
                Query.updateEmail(id, email);
            }
            if(branch_c)
            {
                Query.updateBranch(id, branch);
            }
            if(gender_c)
            {
                Query.updateGender(id, gender);
            }
            if(dob_c)
            {
                Query.updateDOB(id, dob);
            }
            if(year_c)
            {
                Query.updateYear(id, year);
            }
            if(phone_c)
            {
                Query.updatePhone(id, phone);
            }
                PrintWriter out = response.getWriter();
        out.println("<html><head><style>p{font-weight:200;font-size:20px;}span{font-weight:700;font-size:20px;}</style></head><body>");


        out.println("<script>"
                + "alert('Data Updated Successfully');"
                + "window.location.replace('index.html');"
                + "</script>");
        out.println("</body></html>");
        }
        catch(NumberFormatException | SQLException e){}
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
       {
            processRequest(request, response);
       }
       catch(Exception e){} 
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
       {
            processRequest(request, response);
       }
       catch(Exception e){} 
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
