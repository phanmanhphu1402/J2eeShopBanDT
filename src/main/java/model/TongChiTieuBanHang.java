/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phanm
 */
public class TongChiTieuBanHang {

    private String userID;
    private double tongChiTieu;
    private double tongBanHang;

    public TongChiTieuBanHang(String userID, double tongChiTieu, double tongBanHang) {

        this.userID = userID;
        this.tongChiTieu = tongChiTieu;
        this.tongBanHang = tongBanHang;
    }

    public TongChiTieuBanHang() {

    }

    @Override
    public String toString() {
        return "TongChiTieuBanHang [userID=" + userID + ", tongChiTieu=" + tongChiTieu + ", tongBanHang=" + tongBanHang
                + "]";
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(double tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }

    public double getTongBanHang() {
        return tongBanHang;
    }

    public void setTongBanHang(double tongBanHang) {
        this.tongBanHang = tongBanHang;
    }

}
