package model;

import java.util.HashMap;

public class Cart extends HashMap{
	public void addCart(ProductDTO sanpham) {
		String key = sanpham.getSanpham().getMasp();
		if(this.containsKey(key)) {
			int soluongCu = ((ProductDTO)this.get(key)).getSoluong();
			((ProductDTO)this.get(key)).setSoluong(soluongCu+1);
		}else {
			this.put(sanpham.getSanpham().getMasp(), sanpham);
		}
	}
	
	public boolean removeCart(String code) {
		if(this.containsKey(code)) {
			this.remove(code);
			return true;
		}
		return false;
	}
        
        public void updateCart(String code, int quantity) {
		((ProductDTO)this.get(code)).setSoluong(quantity);
	}
	
	public Cart() {
		super();
	}
}
