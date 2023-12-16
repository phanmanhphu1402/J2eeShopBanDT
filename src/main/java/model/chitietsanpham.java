/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author lythanhphat9523
 */


public class chitietsanpham extends sanpham implements Serializable {
    private String mact;
    private String mau;
    private int giaNhap;
    private int giaBan;
    private int soluong;
    private String giaIm;
    private String gia;
    DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
    
    public chitietsanpham() {
    }
    
    public chitietsanpham(String mact,String masp, String mau, int giaNhap, int giaBan, int soluong) {
        super(masp,null,null,null,null);
        this.mact = mact;
        this.mau = mau;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soluong = soluong;
        this.gia = decimalFormat.format(giaBan);
        this.giaIm = decimalFormat.format(giaNhap);
    }
    
    

    public chitietsanpham(String mact,String mau, int giaNhap, int giaBan, int soluong, String masp, String maloai, String tensp, String mota, String hinhanh) {
        super(masp, maloai, tensp, mota, hinhanh);
        this.mau = mau;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soluong = soluong;
        this.gia = decimalFormat.format(giaBan);
        this.giaIm = decimalFormat.format(giaNhap);
        this.mact=mact;
    }
    
    

    public String getMact() {
        return mact;
    }

    public void setMact(String mact) {
        this.mact = mact;
    }

    

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

   

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    
    public String getGia(){
        return gia;
    }
    
    public void setGia(int gia) {
        this.gia = decimalFormat.format(gia);
    }

    public String getGiaIm() {
        return giaIm;
    }

    public void setGiaIm(int gia) {
        this.giaIm = decimalFormat.format(gia);
    }
    
}
