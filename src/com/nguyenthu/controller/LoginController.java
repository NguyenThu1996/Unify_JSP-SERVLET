package com.nguyenthu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nguyenthu.model.User;
import com.nguyenthu.service.UserService;
import com.nguyenthu.service.impl.UserServiceImpl;
import com.nguyenthu.util.Constant;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath()+ "/waiting");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath()+ "/waiting");
					return;
				}
			}
		}

		req.getRequestDispatcher("view/client/view/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String username = req.getParameter("username");
	        
	        String password = req.getParameter("password");
	        
	        User _user = new User();
	        _user.setUsername(username);
	        _user.setPassword(password);
	        
	        boolean isRememberMe = false;
	        String remember = req.getParameter("remember");
	        
	        if("on".equals(remember)){
	            isRememberMe = true;
	        }
	        String alertMsg="";
	        
	        if(username.isEmpty() || password.isEmpty()){
	            alertMsg = "Username and password can't be empty!";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);
	            return;
	        }
             UserService service = new UserServiceImpl();
             User user = service.login(_user);
             
 	        if(user!=null && (user.getRoleId() == 1 || user.getRoleId() ==2)){
 	            HttpSession session = req.getSession(true);
 	            session.setAttribute("account", user);
 	            if(isRememberMe){
 	                saveRemeberMe(resp, username);
 	            }
 	            resp.sendRedirect(req.getContextPath()+"/waiting");
 	        }else{
 	            alertMsg = "Username or password isn't correct";
 	            req.setAttribute("alert", alertMsg);
 	            req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);
 	        }
	    }
	    
	    private void saveRemeberMe(HttpServletResponse response, String username){
	        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
	        cookie.setMaxAge(30*60);
	        response.addCookie(cookie);
	    }
	}


