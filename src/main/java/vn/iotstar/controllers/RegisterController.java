package vn.iotstar.controllers;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy thông tin từ form đăng ký
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String images = req.getParameter("images"); // Nếu có upload hình ảnh từ form

		UserModel existingUser = userService.FindByUserName(username);
		if (existingUser != null) {
			req.setAttribute("alert", "Username already exists!");
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}

		UserModel newUser = new UserModel();
		newUser.setUsername(username);
		newUser.setPassword(password);  
		newUser.setEmail(email);
		newUser.setFullname(fullname);
		newUser.setPhone(phone);
		newUser.setRoleid(1); 
		newUser.setCreateDate(new java.sql.Date(new Date().getTime())); 

		userService.insert(newUser);

		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
