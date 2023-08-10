/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rajda
 */
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, Exception {
        resp.setContentType("text/html;charset=UTF-8");
        try  {
            String id=req.getParameter("id");
            String name=req.getParameter("name");
            String email=req.getParameter("email");
            String branch=req.getParameter("branch");
            String gender=req.getParameter("gender");
            String dob=req.getParameter("dob");
            String year=req.getParameter("year");
            String phone=req.getParameter("phone");
            Query.insert(Integer.parseInt(id), name, email, branch, gender, dob, year, phone);
            PrintWriter out = resp.getWriter();
        out.println("<html><head><style>p{font-weight:200;font-size:20px;}span{font-weight:700;font-size:20px;}</style></head><body>");

        out.println("<script>"
                + "alert('Data Inserted Successfully');"
                + "window.location.replace('index.html');"
                + "</script>");
            out.println("</body></html>");

        }
        catch(Exception e){}
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
