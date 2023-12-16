package model;

import java.io.Serializable;

public class ProductDTO implements Serializable{
	private sanpham sanpham;
	private int soluong;
	
	public ProductDTO() {
		super();
	}

	public ProductDTO(sanpham sanpham) {
		super();
		this.sanpham = sanpham;
		this.soluong = 1;
	}

	public sanpham getSanpham() {
		return sanpham;
	}

	public void setSanpham(sanpham sanpham) {
		this.sanpham = sanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	
	
	
}
