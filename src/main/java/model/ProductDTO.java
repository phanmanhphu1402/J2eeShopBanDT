package model;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private chitietsanpham sanpham;
    private int soluongAdd;

    public ProductDTO() {
        super();
    }

    public ProductDTO(chitietsanpham sanpham) {
        super();
        this.sanpham = sanpham;
        this.soluongAdd = 1;
    }

    public chitietsanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(chitietsanpham sanpham) {
        this.sanpham = sanpham;
    }

    public int getSoluong() {
        return soluongAdd;
    }

    public void setSoluong(int soluong) {
        this.soluongAdd = soluong;
    }

}
