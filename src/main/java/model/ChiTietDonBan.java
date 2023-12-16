/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phanm
 */
public class ChiTietDonBan {
       private String maSp;
       private int soLuong;

    public ChiTietDonBan(String maSp, int soLuong) {
        this.maSp = maSp;
        this.soLuong = soLuong;
    }
    
    public ChiTietDonBan(){}

    	@Override
	public String toString() {
		return "ChiTietDonBan [maSp=" + maSp + ", soLuong=" + soLuong + "]";
	}
    
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
       
}
