/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DetailOrderDAO;
import DAO.OrderDAO;
import DAO.sanphamDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.DetailOrder;
import model.Order;
import model.khachhang;
import model.nhanvien;
import model.sanpham;

/**
 *
 * @author lythanhphat9523
 */
public class Home extends HttpServlet {

    Account acc = new Account();
    khachhang kh = new khachhang();
    nhanvien nv = new nhanvien();
    Order ord = new Order();
    OrderDAO ordDAO = new OrderDAO();
    DetailOrder dord = new DetailOrder();
    DetailOrderDAO dordDAO = new DetailOrderDAO();
    String urlSanPham = "/views/home/contents/product.jsp";
    String urlSection1 = "/views/home/components/section1.jsp";
    String urlSection2 = "/views/home/components/section2.jsp";
    String urlInfor = "/views/home/contents/infor.jsp";
    String urlChiTietDonHang = "/views/home/contents/detail_order.jsp";

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + req.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            req.setAttribute("VIEW", urlSanPham);
            req.setAttribute("SECTION1", urlSection1);
            req.setAttribute("SECTION2", urlSection2);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if (action.equals("View Info")) {
            ArrayList<Order> ls = ordDAO.searchOrderByMaKH("MKH001");
            req.setAttribute("LIST_ORDER", ls);
            req.setAttribute("VIEW", urlInfor);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if (action.equals("Detail")) {
            String maHD = req.getParameter("orderId");
            ArrayList<DetailOrder> ls = dordDAO.searchDetailOrder2(maHD);
            req.setAttribute("LIST_DETAILORDER", ls);
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            req.setAttribute("VIEW", urlChiTietDonHang);
            rd.forward(req, resp);
        }
        

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            doGet(req, resp);
        }

    }
    
}
