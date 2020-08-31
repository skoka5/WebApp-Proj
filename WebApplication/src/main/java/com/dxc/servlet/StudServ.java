package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.beans.Student;
import com.dxc.dao.StudentJdbcDAO;
import com.dxc.service.StudentServiceImpl;


public class StudServ extends HttpServlet {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");}
	private StudentServiceImpl studentServiceImpl;

    public void init() {
        studentServiceImpl = new StudentServiceImpl();
    }
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        studentServiceImpl.delete(id);
        
           response.sendRedirect("Stud.jsp");  
        
    }

    



}