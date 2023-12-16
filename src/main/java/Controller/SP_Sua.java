/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.sanphamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.sanpham;

/**
 *
 * @author lythanhphat9523
 */
@WebServlet(name="SP_Sua", urlPatterns={"/Sua-san-pham"})
public class SP_Sua extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SP_Sua</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SP_Sua at " + req.getContextPath () + "</h1>");
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
        String buttonClicked = req.getParameter("action");
        if("submit".equals(buttonClicked)) {
            String tensp=req.getParameter("tensp");
            String loai=req.getParameter("loai");
            String mota=req.getParameter("mota");
            String masp=req.getParameter("masp");
            String hinhanh=req.getParameter("hinhanh");
            sanpham sp=new sanpham(masp,loai,tensp,mota,hinhanh);
            new sanphamDAO().update(sp);
            resp.sendRedirect("Danh-sach-san-pham");

        }else if ("cancel".equals(buttonClicked)) {
            resp.sendRedirect("Danh-sach-san-pham");
        }
    }


}
