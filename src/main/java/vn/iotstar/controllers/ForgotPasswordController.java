package vn.iotstar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = { "/forgotPassword" })
public class ForgotPasswordController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    IUserService userService = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	 req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");
        
        String alertMsg = "";

        if (email.isEmpty() || newPassword.isEmpty()) {
            alertMsg = "Email và mật khẩu không được để trống";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            return;
        }
        
        UserModel user = userService.FindByEmail(email);
        if (user != null) {
            user.setPassword(newPassword);
            userService.update(user); 
            resp.sendRedirect("/ltwebct2/login"); 
        } else {
            alertMsg = "Không tìm thấy email trong hệ thống";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
        }
    }
}
