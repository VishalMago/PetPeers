package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.Pet;
import com.model.User;
import com.service.LoginValidator;
import com.service.PetValidator;
import com.service.UserValidator;

public class MainsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		if(request.getParameter("jspPage").equals("userregn.jsp")){
			response.setContentType("text/html");
			String confirmPassword=request.getParameter("confirmPassword");
			User user=new User();
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			UserValidator registrationValidate =new UserValidator();
			if(registrationValidate.validate(user, confirmPassword)){
				out.print("<h1>You are successfully registered. Please ");
				out.print("</h1>");
				out.print("<a href='/PetPeer/views/jsp/login.jsp'>sign in</a>");
			}
			else{
				out.print("<font style=\"color:red\">"+"Error");
			}
		}
		else if(request.getParameter("jspPage").equals("login.jsp")){
			response.setContentType("text/html");
			User user=new User();
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			LoginValidator loginValidator=new LoginValidator();
			if(loginValidator.validate(user)){
				HttpSession session = request.getSession();
				session.setAttribute("user", user.getUserName());
				//setting session to expire in 30 minutes
				session.setMaxInactiveInterval(30*60);
		        response.sendRedirect("/PetPeer/PetDetails");
			}
			else{
				out.println("<font color=red>Either user name or password is wrong.</font>");
			}
		}
		else if(request.getParameter("jspPage").equals("logout.jsp")){
			response.setContentType("text/html");
			request.getSession(false).setAttribute("user", null);
			request.getSession().invalidate();
	        response.sendRedirect("/PetPeer/views/jsp/login.jsp");
		}
		else if(request.getParameter("jspPage").equals("pet_form.jsp")){
			response.setContentType("text/html");
			Pet pet=new Pet();
			pet.setPetName(request.getParameter("name"));
			pet.setPetAge(Integer.parseInt(request.getParameter("age")));
			pet.setPetPlace(request.getParameter("place"));
			PetValidator petValidator =new PetValidator();
			if(petValidator.validate(pet)){
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Saved Successfully');");  
				out.println("location='/PetPeer/views/jsp/pet_form.jsp';");
				out.println("</script>");
			}
			else{
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Invalid Details');");  
				out.println("location='/PetPeer/views/jsp/pet_form.jsp';");
				out.println("</script>");
			}
		}
		
		
	}

}
