/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.DBContext;
import Database.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.nhanvien;

/**
 *
 * @author phanm
 */
public class NhanVienDAO {
    public List<nhanvien> GetAllNhanVien() {
        List<nhanvien> list = new ArrayList<>();
        try {
            Connection conn = DataBase.getConnection();
            
            Statement st = conn.createStatement();
            
            String query = "select * from nhanvien";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new nhanvien(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDate(6),
                rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage()); // In thông báo lên console
            e.printStackTrace();
        }
        return list;
    }    
    
    public nhanvien searchNhanVienByMaTK(int i) {
        String sql = "SELECT * FROM NhanVien WHERE MaTK = ?";
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, i);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new nhanvien(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
