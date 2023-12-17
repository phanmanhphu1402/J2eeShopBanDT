/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.ThongKeDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Account;
import model.Order;

/**
 *
 * @author phanm
 */
@WebServlet(name = "StatisticControl", urlPatterns = {"/admin"})
public class StatisticController extends HttpServlet {

    String urlThongKeAdmin = "/views/admin/contents/Statistic.jsp";
    String urlAdmin = "/admin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
//        Account a = (Account) session.getAttribute("acc");
//        int uID;
//        AccountDAO dao = new AccountDAO();
//        if (a == null) {
//            response.sendRedirect("login");
//            return;
//        }
//        uID = a.getUserID();
//        int checkisAdmin = dao.checkAccountAdmin(uID);
//        if (checkisAdmin == 3) {
//            response.sendRedirect("login");
//            return;
//        }

        ThongKeDAO thongke = new ThongKeDAO();
        int allProduct = thongke.countAllProduct();
        request.setAttribute("allProduct", allProduct);

        int sumAllProduct = thongke.SumAllProduct();
        request.setAttribute("sumAllProduct", sumAllProduct);
        
        int countAllBill = thongke.CountAllBill();
        request.setAttribute("countAllBill", countAllBill);

        request.setAttribute("VIEW", urlThongKeAdmin);
        request.getRequestDispatcher(urlAdmin).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
