package DAO;


import Database.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.loaisanpham;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lythanhphat9523
 */
public class loaisanphamDAO implements iDAO<loaisanpham> {

    @Override
    public int insert(loaisanpham a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(loaisanpham a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<loaisanpham> findAll() {
        List<loaisanpham> list=new ArrayList<>();
        try(Connection conn=new DataBase().getConnection()){
            Statement st=conn.createStatement();
            String query="select * from Loaisanpham";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                String maloai=rs.getString("MaLoai");
                String tenloai=rs.getString("TenLoai");
                loaisanpham lsp=new loaisanpham(maloai,tenloai);
                list.add(lsp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public loaisanpham findById(String id) {
        loaisanpham lsp=new loaisanpham();
        try(Connection conn= new DataBase().getConnection()){
            Statement st = conn.createStatement();
            String query="select * from LoaiSanPham where MaLoai='"+id+"'";
            ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
                String maloai = rs.getString("MaLoai");
                String tenloai = rs.getString("TenLoai");

                lsp= new loaisanpham(maloai, tenloai);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lsp;
    }
    
}
