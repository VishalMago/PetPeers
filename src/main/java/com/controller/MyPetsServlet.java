package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.MyPetsDao;
import com.model.Pet;
import com.model.User;


public class MyPetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User user=new User();
		user.setUserName(request.getSession().getAttribute("user").toString());
		MyPetsDao myPetsDao=new MyPetsDao();
		List<Pet> petList=myPetsDao.readPet(user);
		request.setAttribute("pet",petList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/jsp/my_pets.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
