package com.nguyenthu.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nguyenthu.model.Category;
import com.nguyenthu.model.Product;
import com.nguyenthu.model.User;
import com.nguyenthu.service.CategoryService;
import com.nguyenthu.service.ProductService;
import com.nguyenthu.service.UserService;
import com.nguyenthu.service.impl.CategoryServiceImpl;
import com.nguyenthu.service.impl.ProductServiceImpl;
import com.nguyenthu.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> proList = productService.getAll();
		req.setAttribute("proList", proList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-product.jsp");
		dispatcher.forward(req, resp);
	}

}
