package model;

public class DetailOrder {

    private String maHD;
    private String maSP;
    private int donGia;
    private int soLuong;
    private int tongTien;
    private String tenSP;
    private String hinhanh;
    private String mau;

    public DetailOrder(String maHD, String maSP, int donGia, int soLuong, int tongTien) {
        super();
        this.maHD = maHD;
        this.maSP = maSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public DetailOrder(String maHD, String maSP, int donGia, int soLuong, int tongTien, String tenSP, String hinhanh, String mau) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tenSP = tenSP;
        this.hinhanh = hinhanh;
        this.mau = mau;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public DetailOrder() {
        super();
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

}
