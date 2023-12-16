/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.chitietsanphamDAO;
import DAO.sanphamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.chitietsanpham;
import model.sanpham;

/**
 *
 * @author lythanhphat9523
 */
public class CT_Sua extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CT_Sua</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CT_Sua at " + req.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        processRequest(req, resp);
    } 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String masp=req.getParameter("masp");
        String buttonClicked = req.getParameter("action");
        if("submit".equals(buttonClicked)) {
            String mact=req.getParameter("mact");
            String mau=req.getParameter("mau");
            int gianhap=Integer.parseInt(req.getParameter("gianhap"));
            int giaban=Integer.parseInt(req.getParameter("giaban"));
            int soluong=Integer.parseInt(req.getParameter("soluong"));
            chitietsanpham sp=new chitietsanpham(mact,masp,mau,gianhap,giaban,soluong);
            new chitietsanphamDAO().update(sp);
            resp.sendRedirect("Chi-tiet?id="+masp);
        }else if ("cancel".equals(buttonClicked)) {
            resp.sendRedirect("Chi-tiet?id="+masp);
        }
    }


}
