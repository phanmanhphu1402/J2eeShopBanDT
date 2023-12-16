/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author thine
 */
@WebServlet(name="UpdateAccountServlet", urlPatterns={"/UpdateAccountServlet"})
public class UpdateAccountServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateAccountServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAccountServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        int newQuyen = Integer.parseInt(request.getParameter("newQuyen"));
        int newTrangThai = Integer.parseInt(request.getParameter("newTrangThai"));

        AccountDAO accountDAO = new AccountDAO();
        Account updatedAccount = accountDAO.getAccountById(userId);
        if (updatedAccount != null) {
            updatedAccount.setUsername(newUsername);
            updatedAccount.setPassword(newPassword);
            updatedAccount.setQuyen(newQuyen);
            updatedAccount.setTrangThai(newTrangThai);
            accountDAO.updateAccount(updatedAccount); // Phương thức updateAccount cần được cài đặt trong DAO

            // Chuyển hướng trở lại trang QLAccount.jsp
            response.sendRedirect("AccountServletManager");
        } else {
            // Xử lý khi không tìm thấy tài khoản để cập nhật
            // Có thể chuyển hướng đến trang thông báo lỗi
        }
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
