/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author lythanhphat9523
 */


public class sanphamver1  implements Serializable{
    private String maSP;   
    private String tenSP;    
    private String maLoai;
    private String mau;
    private int giaNhap;
    private int giaBan;
    private String hinhanh;
    private int soluong;
    private String mota;
    private String gia;
    DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
    
    public sanphamver1() {
    }

    public sanphamver1(String maSP, String tenSP, String maLoai, String MoTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maLoai = maLoai;
        this.mota = mota;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public sanphamver1(String maSP, String tenSP, String maLoai,String mau, int giaNhap, int giaBan, String hinhanh, int soluong, String mota) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maLoai = maLoai;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.hinhanh = hinhanh;
        this.soluong = soluong;
        this.mota = mota;
        this.mau=mau;
        this.gia = decimalFormat.format(giaBan);
    }

    public sanphamver1(String maSP, String tenSP, String maLoai, int giaNhap, int giaBan, String hinhanh, String mota) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maLoai = maLoai;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.hinhanh = hinhanh;
        this.mota = mota;
        this.gia = decimalFormat.format(giaBan);
    }
    
    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
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

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    public String getGia(){
        return gia;
    }
    
}