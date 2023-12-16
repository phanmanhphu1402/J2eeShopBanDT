/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lythanhphat9523
 */

public class khachhang implements Serializable{
    private String maKH;
    private String hoTen;
    private String SDT;
    private String email;
    private Date ngaySinh;
    private String maTK;

    public khachhang(String maKH, String hoTen, String SDT, String email, Date ngaySinh, String maTK) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.SDT = SDT;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.maTK = maTK;
    }

    public khachhang() {
    }
 
    @Override
    public String toString() {
        return "khachhang{" + "maKH=" + maKH + ", hoTen=" + hoTen + ", SDT=" + SDT + ", email=" + email + ", ngaySinh=" + ngaySinh + ", maTK=" + maTK + '}';
    }
    
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    
}
