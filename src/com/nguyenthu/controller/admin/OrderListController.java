package com.nguyenthu.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nguyenthu.model.Cart;
import com.nguyenthu.model.CartItem;
import com.nguyenthu.model.User;
import com.nguyenthu.service.CartItemService;
import com.nguyenthu.service.CartService;
import com.nguyenthu.service.UserService;
import com.nguyenthu.service.impl.CartServiceImpl;
import com.nguyenthu.service.impl.CartServiceItemImpl;
import com.nguyenthu.service.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/admin/order/list"})
public class OrderListController extends HttpServlet {
	CartItemService cartItemService=new CartServiceItemImpl();
	CartService cartService=new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<CartItem> listCartItem =cartItemService.getAll();
	req.setAttribute("listCartItem", listCartItem);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-order.jsp");
	dispatcher.forward(req, resp);
	}
	
}
