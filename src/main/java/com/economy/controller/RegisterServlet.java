package com.economy.controller;

import java.io.IOException;

import com.economy.bean.User;
import com.economy.dao.RegisterDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		User user = new User(name, mail, password);
		String result = RegisterDao.registerUser(user);
		if (result.equals("Fail")) {
			response.getWriter().append("Fail");
		} else {
			response.getWriter().append("Success");
		}
	}

}
