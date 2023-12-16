/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author thine
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("u" + username);
        System.out.println("p" + password);

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            // Trả về thông báo lỗi
            PrintWriter out = response.getWriter();
            out.println("Tên đăng nhập và mật khẩu không được để trống!");
        } else {
            try {
                AccountDAO accountDAO = new AccountDAO();
                Account user = accountDAO.findByUsername(username);
                if (user == null) {
                    boolean isRegistered = accountDAO.registerAccount(username, password);
                    if (isRegistered) {
                        request.setAttribute("successMessage", "Đăng ký thành công!"); // Thiết lập thông điệp thành công
                        response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập nếu đăng ký thành công
                    } else {
                        response.sendRedirect("register"); // Chuyển hướng đến trang đăng ký nếu có lỗi
                    }
                } else {
                    response.getWriter().println("Username da~ ton tai trong he thong");
                }

            } catch (SQLException ex) {

            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
