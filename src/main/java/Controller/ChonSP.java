/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.chitietsanphamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.chitietsanpham;

/**
 *
 * @author lythanhphat9523
 */
public class ChonSP extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChonSP</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChonSP at " + req.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        String masp=req.getParameter("masp");
        int luachon=Integer.parseInt(req.getParameter("choise"));
        List<chitietsanpham> list=new chitietsanphamDAO().findByIdList(masp);
        chitietsanpham ct=list.get(luachon);
        req.setAttribute("choise", luachon);
        req.setAttribute("ct", ct);
        req.setAttribute("masp", masp);
        req.setAttribute("list", list);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    } 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        String masp=req.getParameter("id");
        System.out.println("Đây là mã: "+masp);
        int a = Integer.parseInt(req.getParameter("selectedColor"));
        List<chitietsanpham> list=new chitietsanphamDAO().findByIdList(masp);
        chitietsanpham ct=list.get(a);
        req.setAttribute("choise", a);
        req.setAttribute("ct", ct);
        req.setAttribute("masp", masp);
        req.setAttribute("list", list);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }


}
