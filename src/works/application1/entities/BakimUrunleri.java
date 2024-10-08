package works.application1.entities;

import works.application1.utilities.enums.EBakimUrunleriTipler;
import works.application1.utilities.enums.EKategori;

public class BakimUrunleri extends Urun {
	private EBakimUrunleriTipler tipler;
	
	public BakimUrunleri(String ad, Double fiyat, String aciklama, EKategori kategori, Integer adet, EBakimUrunleriTipler tipler ) {
		super(ad, fiyat, aciklama, kategori, adet);
		this.tipler=tipler;
	}
	
	public EBakimUrunleriTipler getTipler() {
		return tipler;
	}
	
	public void setTipler(EBakimUrunleriTipler tipler) {
		this.tipler = tipler;
	}
	@Override
	public String toString() {
		return super.urunOzetBilgisi();
	}
	public String urunDetayBilgisi() {
		return super.urunDetayBilgisi()+ " tipler : "+getTipler();
	}
}