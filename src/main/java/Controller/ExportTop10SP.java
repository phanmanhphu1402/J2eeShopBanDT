/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ThongKeDAO;
import DAO.sanphamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import model.ChiTietDonBan;
import model.sanphamver1;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 *
 * @author phanm
 */
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet(name = "ExportTop10SP", urlPatterns = {"/ExportTop10SP"})
public class ExportTop10SP extends HttpServlet {

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

        ThongKeDAO thongke = new ThongKeDAO();
        sanphamDAO sanpham = new sanphamDAO();
        List<sanphamver1> listSanPham = sanpham.GetAllSP();
        List<ChiTietDonBan> listTop10Product = thongke.getTop10SanPhamBanChay();

        int maximum = 2147483647;
        int minimum = 1;

        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;

        FileOutputStream file = new FileOutputStream("C:\\EXPORTWEB\\" + "top-10-san-pham-ban-chay-" + Integer.toString(randomNum) + ".xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet workSheet = workbook.createSheet("1");
        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3;
        XSSFCell cell4;
        XSSFCell cell5;
        XSSFCell cell6;
        XSSFCell cell7;
        XSSFCell cell8;
        XSSFCell cell9;
        XSSFCell cell10;
        XSSFCell cell11;

        row = workSheet.createRow(0);
        cell0 = row.createCell(0);
        cell0.setCellValue("Mã Sản Phẩm");
        cell1 = row.createCell(1);
        cell1.setCellValue("Tên Sản Phẩm");
        cell2 = row.createCell(2);
        cell2.setCellValue("Mã Loại");
        cell3 = row.createCell(3);
        cell3.setCellValue("Giá Nhập");
        cell4 = row.createCell(4);
        cell4.setCellValue("Giá Bán");
        cell5 = row.createCell(5);
        cell5.setCellValue("Hình Ảnh");
        cell5 = row.createCell(6);
        cell5.setCellValue("Số Lượng");
        cell5 = row.createCell(7);
        cell5.setCellValue("Mô Tả");
        cell5 = row.createCell(8);
        cell5.setCellValue("Giá");
        cell5 = row.createCell(9);
        cell5.setCellValue("Số lượng đã bán");

        int i = 0;
        for (ChiTietDonBan soluong : listTop10Product) {
            for (sanphamver1 pro : listSanPham) {
                if (soluong.getMaSp().equals(pro.getMaSP())) {
                    i = i + 1;
                    row = workSheet.createRow(i);
                    cell0 = row.createCell(0);
                    cell0.setCellValue(pro.getMaSP());
                    cell1 = row.createCell(1);
                    cell1.setCellValue(pro.getTenSP());
                    cell2 = row.createCell(2);
                    cell2.setCellValue(pro.getMaLoai());
                    cell3 = row.createCell(3);
                    cell3.setCellValue(pro.getGiaNhap());
                    cell4 = row.createCell(4);
                    cell4.setCellValue(pro.getGiaBan());
                    cell4 = row.createCell(5);
                    cell4.setCellValue(pro.getHinhanh());
                    cell4 = row.createCell(6);
                    cell4.setCellValue(pro.getSoluong());
                    cell4 = row.createCell(7);
                    cell4.setCellValue(pro.getMota());
                    cell4 = row.createCell(8);
                    cell4.setCellValue(pro.getGia());
                    cell4 = row.createCell(9);
                    cell4.setCellValue(soluong.getSoLuong());
                }
            }
        }

        workbook.write(file);
        workbook.close();
        file.close();

        request.setAttribute("mess", "Đã xuất file Excel thành công!");
        request.getRequestDispatcher("top10").forward(request, response);
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