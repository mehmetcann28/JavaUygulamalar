package GroupWork.Work1.entities;

import GroupWork.Work1.Sabit;
import GroupWork.Work1.Urun;
import GroupWork.Work1.utilities.enums.ECihazTipi;
import GroupWork.Work1.utilities.enums.EKategori;

public class ElektronikUrunleri extends Urun {
	
	private Integer pilOmru;
	private Double calismaVoltaji;
	private ECihazTipi cihazTipi;
	
	public ElektronikUrunleri(String ad, Double fiyat, String aciklama, EKategori kategori, Integer adet, Integer pilOmru, Double calismaVoltaji, ECihazTipi cihazTipi) {
		super(ad, (Sabit.formatAndParseDouble(fiyat)), aciklama, kategori, adet);
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