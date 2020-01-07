//package com.revature.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.models.User;
//import com.revature.models.UserDTO;
//import com.revature.services.UserService;
//
//public class UserServlet extends HttpServlet {
//	
//	private static ObjectMapper om = new ObjectMapper();
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse res)
//		throws ServletException, IOException {
//		res.setContentType("application/json");
//		List<User> all = UserService.findAll();
//		List<UserDTO> allDTO = new ArrayList<>();
//		
//		for(User e : all) {
//			allDTO.add(new UserDTO(e.getUser_id(),
//					e.getFirst_name(),
//					e.getLast_name(),
//					e.getUsername(),
//					e.getPassword()));
//		}
//		
//		String json = om.writeValueAsString(all);
//		
//		PrintWriter out = res.getWriter();
//		out.println(json);
//	}
//}