package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginTemplate;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.services.UserService;


public class RequestHelper {
	
	private static Logger logger = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();

	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		System.out.println("Post body data: " + body);
		
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);

		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();

		logger.info("User attempted to login with username " + username);
		System.out.println("User attempted to login with username " + username);
		User u = UserService.verifyLogin(username, password);
		if (u != null) {
			HttpSession session = req.getSession();

			session.setAttribute("currentuser", u);

			PrintWriter out = res.getWriter();

			res.setContentType("application/json");

			UserDTO eDTO = UserService.convertToDTO(u);

			String jsonStr = om.writeValueAsString(eDTO);
			out.println(jsonStr);

			logger.info(username + " has successfully logged in");
			System.out.println(username + " has successfully logged in");
		} else {
			res.setContentType("application/json");
			res.setStatus(204);
			System.out.println(username + " failed to log in");
		}
		
//		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
//		String username = loginAttempt.getUsername();
//		String password = loginAttempt.getPassword();
//		
//		logger.info("User attempted to login with username " + username);
//		User e = UserService.confirmLogin(username, password);
//		if(e != null) {
//			HttpSession session = req.getSession();
//			// Gets the current session, or creates one if it did not exist
//			session.setAttribute("username", username);
//			
//			PrintWriter out = res.getWriter();
//			res.setContentType("application/json");
//			UserDTO eDTO = UserService.convertToDTO(e);
//			
//			out.println(om.writeValueAsString(eDTO));
//			
//			logger.info(username + " has successfully logged in");
//		} else {
//			res.setContentType("application/json");
//			res.setStatus(204);
//		}
	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			String username = (String) session.getAttribute("username");
			logger.info(username + " has logged out");
			session.invalidate();
		}
		
		res.setStatus(200);
	}
	
	public static void getReimb(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		Reimbursement m = new Reimbursement();
		m.setReimb_author(id);
//		User u = UserService.getUserReimb(m);
	}

}