package model;

import java.util.Date;

public class Order {
	private String maHD;
	private String maNV;
	private String maKH;
	private String maKM;
	private int tongTien;
	private Date ngayTao;
	public Order(String maHD, String maNV, String maKH, String maKM, int tongTien, Date ngayTao) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maKM = maKM;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
	}

	public Order() {
		super();
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	
}
