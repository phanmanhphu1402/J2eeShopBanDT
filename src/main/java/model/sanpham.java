/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.loaisanphamDAO;

/**
 *
 * @author lythanhphat9523
 */
public class sanpham {
    private String masp;
    private String tensp;
    private String tenloai;
    private String maloai;
    private String mota;
    private String hinhanh;

    public sanpham(String masp,String maloai, String tensp, String mota, String hinhanh) {
        this.masp = masp;
        this.tensp = tensp;
        this.tenloai=new loaisanphamDAO().findById(maloai).getTenloai();
        this.mota = mota;
        this.hinhanh = hinhanh;
        this.maloai = maloai;
    }
    
    public sanpham() {
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }
    
    
}