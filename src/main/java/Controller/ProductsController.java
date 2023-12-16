/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.sanphamDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import model.sanpham;

/**
 *
 * @author lythanhphat9523
 */
@WebServlet("/ProductsController")
public class ProductsController extends HttpServlet {

    String urlSanPhamAdmin = "/views/admin/contents/products.jsp";
    String urlChiTietDonHangAdmin = "/views/admin/contents/detail_order.jsp";
    String urlAdmin = "/admin.jsp";
//    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = resp.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ProductsController</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ProductsController at " + req.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(urlAdmin);
        req.setAttribute("VIEW", urlSanPhamAdmin);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(urlAdmin);
        req.setAttribute("VIEW", urlSanPhamAdmin);
        rd.forward(req, resp);
    }

}
