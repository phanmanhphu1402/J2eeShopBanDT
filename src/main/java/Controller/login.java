/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Account;

/**
 *
 * @author thine
 */
@WebServlet(name="login", urlPatterns={"/login"})
public class login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try {
           String user = request.getParameter("username");
           String pass = request.getParameter("password");
           AccountDAO accountDAO = new AccountDAO();
           Account a = accountDAO.checkLogin(user, pass);
           if (a == null) {
               response.sendRedirect("login.jsp");
           } else {
               
            HttpSession session = request.getSession();
               System.out.println("a"+a.getQuyen()+a.getUsername());
            session.setAttribute("loginSuccessMessage", "Đăng nhập thành công!");
            session.setAttribute("loginUserID", a.getUserID());
               // response.sendRedirect("qlac");
               switch (a.getQuyen()) {
                   case 1:
                   case 2:
                       session.setAttribute("loginSuccessMessage", "Xin chào quản trị viên!");
                       response.sendRedirect("qlac");
                       break;
                   case 3:
                       response.sendRedirect("/Trang-chu");
                       break;
                   default:
                       response.sendRedirect("/Trang-chu");
                       break;
               }
  
           }
           
          } catch (IOException e) {
                    // Xử lý ngoại lệ nếu cần thiết  
                }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        processRequest(request, response);    
    } 
    
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
