package com.study.product.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignupPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿으로 JSP 접근(경로를 숨길 수 있음)
		request.setAttribute("key4", "value4");
		
		ServletContext application = request.getServletContext();
		application.setAttribute("key1", "value1");
		application.setAttribute("key2", "value2");
		application.setAttribute("key3", "value3");
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1000 * 60 * 60);
		session.setAttribute("key7", "value7");
		session.setAttribute("key8", "value8");
		session.setAttribute("key9", "value9");
		
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
