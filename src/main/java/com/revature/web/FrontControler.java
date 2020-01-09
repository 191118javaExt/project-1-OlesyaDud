package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginTemplate;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.services.UserService;
import com.revature.util.RequestHelper;

public class FrontControler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(FrontControler.class);

	private static ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		String reqType = req.getParameter("type");
		System.out.println("Incoming request: " + reqType);
		if (reqType.equals("getreimb")) {
			RequestHelper.getReimb(req, res);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String reqType = req.getParameter("type");
		System.out.println("Incoming request: " + reqType);
		if (reqType.equals("login")) {
			RequestHelper.processLogin(req, res);
		}else if (reqType.equals("logout")) {
			RequestHelper.processLogout(req, res);
		}
	}
}
