package uygulamalar.entities;

import uygulamalar.Urun;
import uygulamalar.utilities.enums.EKategori;
import uygulamalar.utilities.enums.EYiyecekTipi;

public class Yiyecek extends Urun {
	private EYiyecekTipi yiyecekTipi;
	
	public Yiyecek(String ad, Double fiyat, String aciklama, EKategori kategori, Integer adet, EYiyecekTipi yiyecekTipi) {
		super(ad, fiyat, aciklama, kategori, adet);
		this.yiyecekTipi = yiyecekTipi;
	}
	
	public EYiyecekTipi getYiyecekTipi() {
		return yiyecekTipi;
	}
	
	public void setYiyecekTipi(EYiyecekTipi yiyecekTipi) {
		this.yiyecekTipi = yiyecekTipi;
	}
	
	@Override
	public String toString() {
		return super.urunOzetBilgisi();
	}
	
	@Override
	public String urunDetayBilgisi() {
		return super.urunDetayBilgisi() + " yiyecek tipi : " + getYiyecekTipi();
	}
}