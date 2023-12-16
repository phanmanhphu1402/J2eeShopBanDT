package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.DetailOrder;
import model.sanpham;
import Database.DataBase;

public class DetailOrderDAO {

    sanphamDAO spDAO = new sanphamDAO();

    public int addDetailOrder(DetailOrder detailOrder, int stt) {
        try {
            Connection conn = DataBase.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO ChiTietDonBan (STT ,MaHDB, MaSP, DonGia, SoLuong, TongTien) VALUES ('" + stt + "','" + detailOrder.getMaHD() + "','" + detailOrder.getMaSP() + "','" + detailOrder.getDonGia() + "','" + detailOrder.getSoLuong() + "','" + detailOrder.getTongTien() + "')";
            stmt.executeQuery(sql);
            conn.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Cant connect BD");
            return 0;
        }
    }

    public ArrayList<DetailOrder> searchDetailOrder(String id) {
        ArrayList<DetailOrder> ls = new ArrayList<DetailOrder>();
        Connection conn = null;
        try {
            conn = DataBase.getConnection();
            String sql = "SELECT * FROM ChiTietDonBan WHERE MaHDB ='" + id + "'";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maSP = rs.getString("MaSP");
                int donGia = rs.getInt("DonGia");
                int soLuong = rs.getInt("SoLuong");
                int tongTien = rs.getInt("TongTien");
                DetailOrder detailOrder = new DetailOrder(maHD, maSP, donGia, soLuong, tongTien);
                ls.add(detailOrder);
            }
            conn.close();
        } catch (Exception e) {
            System.out.print("Cant connect");
        }
        return ls;
    }

    public ArrayList<DetailOrder> searchDetailOrder2(String id) {
        ArrayList<DetailOrder> ls = new ArrayList<DetailOrder>();
        Connection conn = null;
        try {
            conn = DataBase.getConnection();
            String sql = "SELECT * FROM ChiTietDonBan WHERE MaHDB ='" + id + "'";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("MaHDB");
                String maSP = rs.getString("MaSP");
                int donGia = rs.getInt("DonGia");
                int soLuong = rs.getInt("SoLuong");
                int tongTien = rs.getInt("TongTien");
                DetailOrder detailOrder = new DetailOrder(maHD, maSP, donGia, soLuong, tongTien,"123","123" /*spDAO.findById(maSP).getTenSP(), spDAO.findById(maSP).getHinhanh()*/);
                ls.add(detailOrder);
            }
            conn.close();
        } catch (Exception e) {
            System.out.print("Cant connect");
        }
        return ls;
    }
}
