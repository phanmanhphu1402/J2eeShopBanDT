/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author lythanhphat9523
 */
public class nhanvien {
    private String maNV;
    private String hoTen;
    private String SDT;
    private String email;
    private Date ngaySinh;
    private String maTK;

    public nhanvien(String maNV, String hoTen, String SDT, String email, Date ngaySinh, String maTK) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.SDT = SDT;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.maTK = maTK;
    }

    @Override
    public String toString() {
        return "nhanvien{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", SDT=" + SDT + ", email=" + email + ", ngaySinh=" + ngaySinh + ", maTK=" + maTK + '}';
    }

    public nhanvien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }
    
}
