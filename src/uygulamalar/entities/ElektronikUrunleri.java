package uygulamalar.entities;

import uygulamalar.Urun;
import uygulamalar.utilities.enums.ECihazTipi;
import uygulamalar.utilities.enums.EKategori;

public class ElektronikUrunleri extends Urun {
	
	private Integer pilOmru;
	private Double calismaVoltaji;
	private ECihazTipi cihazTipi;
	
	public ElektronikUrunleri(String ad, Double fiyat, String aciklama, EKategori kategori, Integer adet, Integer pilOmru, Double calismaVoltaji, ECihazTipi cihazTipi) {
		super(ad, fiyat, aciklama, kategori, adet);
		this.pilOmru = pilOmru;
		this.calismaVoltaji = calismaVoltaji;
		this.cihazTipi = cihazTipi;
	}
	
	public Integer getPilOmru() {
		return pilOmru;
	}
	
	public void setPilOmru(Integer pilOmru) {
		this.pilOmru = pilOmru;
	}
	
	public Double getCalismaVoltaji() {
		return calismaVoltaji;
	}
	
	public void setCalismaVoltaji(Double calismaVoltaji) {
		this.calismaVoltaji = calismaVoltaji;
	}
	
	
	@Override
	public String toString() {
		return super.urunOzetBilgisi();
	}
	
	@Override
	public String urunDetayBilgisi() {
		return super.urunDetayBilgisi()+" pilOmru :"+getPilOmru()+" calismaVoltajı : "+getCalismaVoltaji();
	}
}