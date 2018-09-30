package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BuyPetDao;
import com.model.User;

public class BuyPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		BuyPetDao buyPetDao=new BuyPetDao();
		User user=new User();
		user.setUserName(request.getSession().getAttribute("user").toString());
		if(buyPetDao.update(user,Integer.parseInt(request.getParameter("petId")))){
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Saved Successfully');");  
			out.println("location='/PetPeer/MyPets';");
			out.println("</script>");
		}
	}

}
