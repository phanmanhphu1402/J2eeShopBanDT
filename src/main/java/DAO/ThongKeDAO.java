/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Database.DBContext;
import java.util.ArrayList;
import model.ChiTietDonBan;
import java.util.List;
import model.TongChiTieuBanHang;

/**
 *
 * @author phanm
 */
public class ThongKeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public double totalMoneyDay(int day) {
        String query = "SELECT SUM(TongTien) FROM HoaDonBan WHERE DATEPART(dw, [NgayTao]) = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, day); // Set the day parameter
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            // Handle SQL exceptions appropriately
            System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
            e.printStackTrace(); // In stack trace lên console để xem chi tiết lỗi
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public double totalMoneyMonth(int month) {
        String query = "SELECT SUM(TongTien) FROM HoaDonBan WHERE MONTH(NgayTao) = ?";
        double total = 0;
        try {
            conn = new DBContext().getConnection(); // Establish connection with SQL
            ps = conn.prepareStatement(query);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            // Handle or log the exception properly, don't leave the catch block empty
            System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
            e.printStackTrace(); // In stack trace lên console để xem chi tiết lỗi
        } finally {
            // Close resources in a finally block to ensure closure
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
                e.printStackTrace(); // In stack trace lên console để xem chi tiết lỗi
            }
        }
        return total;
    }

    public List<ChiTietDonBan> getTop10SanPhamBanChay() {
        List<ChiTietDonBan> list = new ArrayList<>();
        String query = "SELECT TOP 10 MaSP, SUM(SoLuong) AS SoLuong "
                + "FROM ChiTietDonBan "
                + "GROUP BY MaSP "
                + "ORDER BY SoLuong DESC";
        try {
            conn = new DBContext().getConnection(); // Mở kết nối với SQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietDonBan(
                        rs.getString(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
            e.printStackTrace(); // In stack trace lên console để xem chi tiết lỗi
        }
        return list;
    }

    public List<TongChiTieuBanHang> getTop5KhachHang() {
        List<TongChiTieuBanHang> list = new ArrayList<>();
        String query = "SELECT TOP 5 KH.MaKH AS UserID, SUM(HDB.TongTien) AS TongChiTieu "
                + "FROM KhachHang KH "
                + "JOIN HoaDonBan HDB ON KH.MaKH = HDB.MaKH "
                + "GROUP BY KH.MaKH, KH.HoTen "
                + "ORDER BY TongChiTieu DESC";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(
                        rs.getString(1),
                        rs.getDouble(2),
                        0
                ));
//                TongChiTieuBanHang chitiet = new TongChiTieuBanHang(
//                        rs.getString(1),
//                        rs.getDouble(2)
//                );
//                list.add(chitiet);
//                System.out.println("user id: " + chitiet.getUserID() + ", tong chi tieu: " + chitiet.getTongChiTieu());
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
            e.printStackTrace(); // In stack trace lên console để xem chi tiết lỗi
        }
        return list;
    }

    public List<TongChiTieuBanHang> getTop5NhanVien() {
        List<TongChiTieuBanHang> list = new ArrayList<>();
        String query = "SELECT TOP 5 NhanVien.MaNV, SUM(HoaDonBan.TongTien) AS DoanhThu "
                + "FROM NhanVien "
                + "INNER JOIN HoaDonBan ON NhanVien.MaNV = HoaDonBan.MaNV "
                + "GROUP BY NhanVien.MaNV, NhanVien.HoTen "
                + "ORDER BY SUM(HoaDonBan.TongTien) DESC";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(
                        rs.getString(1),
                        0,
                        rs.getDouble(2)
                ));
//                TongChiTieuBanHang chitiet = new TongChiTieuBanHang(
//                        rs.getString(1),
//                        0,
//                        rs.getDouble(2)
//                );
//                list.add(chitiet);
//                System.out.println("user id: " + chitiet.getUserID() + ", tong chi tieu: " + chitiet.getTongChiTieu());
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
            e.printStackTrace(); // In stack trace lên console để xem chi tiết lỗi
        }
        return list;
    }

    public int countAllProduct() {
        String query = "select count(*) from sanpham";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int SumAllProduct() {
        String query = "SELECT SUM(TongTien) FROM ChiTietDonBan;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int CountAllBill() {
        String query = "select count(*) from hoadonban;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
