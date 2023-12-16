package model;

public class KhuyenMai {
	private String maKM;
	private float tileKM;
	public KhuyenMai(String maKM, float tileKM) {
		super();
		this.maKM = maKM;
		this.tileKM = tileKM;
	}
	public KhuyenMai() {
		super();
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public float getTileKM() {
		return tileKM;
	}
	public void setTileKM(float tileKM) {
		this.tileKM = tileKM;
	}
	
}
