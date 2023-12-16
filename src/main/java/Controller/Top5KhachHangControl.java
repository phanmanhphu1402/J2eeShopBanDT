/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.KhachHangDAO;
import DAO.ThongKeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TongChiTieuBanHang;
import model.khachhang;
import java.util.List;

/**
 *
 * @author phanm
 */
@WebServlet(name = "Top5KhachHangControl", urlPatterns = {"/top5khachhang"})
public class Top5KhachHangControl extends HttpServlet {
    String urlTop5KhachHang = "/views/admin/contents/Top5KhachHang.jsp";
    String urlAdmin = "/admin.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        ThongKeDAO thongke = new ThongKeDAO();
        KhachHangDAO khachhang = new KhachHangDAO();
        List<khachhang> listKhachHang = khachhang.GetAllKhachHang();
        List<TongChiTieuBanHang> listTop5KhachHang = thongke.getTop5KhachHang();
        
        request.setAttribute("listAllAccount", listKhachHang);
        request.setAttribute("listTop5KhachHang", listTop5KhachHang);
        request.setAttribute("VIEW", urlTop5KhachHang);
        request.getRequestDispatcher(urlAdmin).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
