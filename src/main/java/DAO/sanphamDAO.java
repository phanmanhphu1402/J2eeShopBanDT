/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.chitietsanpham;
import model.sanpham;
import model.sanphamver1;

/**
 *
 * @author lythanhphat9523
 */
public class sanphamDAO implements iDAO<sanpham> {

    @Override
    public int insert(sanpham sp) {
        try (Connection conn = DataBase.getConnection()) {
            String sql = "insert into SanPham values('SP' + RIGHT('000' + CAST((SELECT COUNT(*) + 1 FROM SanPham) AS VARCHAR(3)), 3),?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, sp.getMasp());
                pstmt.setString(2, sp.getTensp());
                pstmt.setString(3, sp.getMaloai());
                pstmt.setString(4, sp.getMota());
                pstmt.setString(5, sp.getHinhanh());
                pstmt.executeUpdate();
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(sanpham sp) {
        try (Connection conn = DataBase.getConnection()) {
            String sql = "update SanPham set TenSP=?,MaLoai=?,HinhAnh=?,MoTa=? where MaSP='"+sp.getMasp()+"'";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, sp.getTensp());
                pstmt.setString(2, sp.getMaloai());
                pstmt.setString(4, sp.getMota());
                pstmt.setString(3, sp.getHinhanh());
                pstmt.executeUpdate();
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(String sp) {
        List<chitietsanpham> list = new chitietsanphamDAO().findByIdList(sp);
        if (list != null) {
            for (sanpham a : list) {
                new chitietsanphamDAO().deleteByMaSP(a.getMasp());
            }
        }
        try (Connection conn = new DataBase().getConnection()) {
            Statement st = conn.createStatement();
            String query = "delete from SanPham where MaSP = '" + sp + "'";
            return st.executeUpdate(query);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<sanpham> findAll() {
        List<sanpham> list = new ArrayList<>();
        try (Connection conn = DataBase.getConnection()) {
            Statement st = conn.createStatement();

            String query = "select * from SanPham";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                String maloai = rs.getString("MaLoai");
                String hinhanh = rs.getString("HinhAnh");
                String mota = rs.getString("MoTa");
                sanpham sp = new sanpham(masp, maloai, tensp, mota, hinhanh);
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public sanpham findById(String id) {
        sanpham sp=new sanpham();
        try (Connection conn = DataBase.getConnection()) {
            Statement st = conn.createStatement();

            String query = "select * from SanPham where MaSP = '" + id + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                String maloai = rs.getString("MaLoai");
                String hinhanh = rs.getString("HinhAnh");
                String mota = rs.getString("MoTa");
                sp = new sanpham(masp, maloai, tensp, mota, hinhanh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public List<sanpham> findAllByMaSP(String Masp) {
        List<sanpham> list = new ArrayList<>();
        try (Connection conn = DataBase.getConnection()) {
            Statement st = conn.createStatement();

            String query = "select * from SanPham where MaSP like '%" + Masp + "%'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                String maloai = rs.getString("MaLoai");
                String hinhanh = rs.getString("HinhAnh");
                String mota = rs.getString("MoTa");
                sanpham sp = new sanpham(masp, maloai, tensp, mota, hinhanh);
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<sanpham> findAllByName(String Tensp) {
        List<sanpham> list = new ArrayList<>();
        try (Connection conn = DataBase.getConnection()) {
            Statement st = conn.createStatement();

            String query = "select * from SanPham where TenSP like '%" + Tensp + "%'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String tensp = rs.getString("TenSP");
                String maloai = rs.getString("MaLoai");
                String hinhanh = rs.getString("HinhAnh");
                String mota = rs.getString("MoTa");
                sanpham sp = new sanpham(masp, maloai, tensp, mota, hinhanh);
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<sanphamver1> GetAllSP() {
        List<sanphamver1> list = new ArrayList();
        try {
            Connection conn = DataBase.getConnection();

            Statement st = conn.createStatement();

            String query = "select sp.MaSP,sp.TenSP,lsp.TenLoai,ct.Mau,ct.GiaNhap,ct.GiaBan,ct.HinhAnh,ct.SoLuong,sp.MoTa from SanPham sp join ChiTietSanPham ct on sp.MaSP=ct.MaSP join Loaisanpham lsp on lsp.MaLoai=sp.MaLoai";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                String maLoai = rs.getString("TenLoai");
                String mau=rs.getString("Mau");
                int giaNhap = rs.getInt("GiaNhap");
                int giaBan = rs.getInt("GiaBan");
                int soLuong = rs.getInt("SoLuong");
                String hinhAnh = rs.getString("HinhAnh");
                String MoTa = rs.getString("MoTa");

                sanphamver1 sp = new sanphamver1(maSP, tenSP, maLoai,mau, giaNhap, giaBan, hinhAnh, soLuong, MoTa);
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
