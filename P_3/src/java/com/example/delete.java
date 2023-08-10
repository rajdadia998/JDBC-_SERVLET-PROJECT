package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class delete extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, Exception {
        resp.setContentType("text/html;charset=UTF-8");
        try  {
            String id = req.getParameter("id");
             Query.delete(Integer.parseInt(id));
            PrintWriter out = resp.getWriter();
            out.println("<html><head><style>p{font-weight:200;font-size:20px;}span{font-weight:700;font-size:20px;}</style></head><body>");

            out.println("<script>"
                + "alert('Data Deleted Successfully');"
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
    }

}
