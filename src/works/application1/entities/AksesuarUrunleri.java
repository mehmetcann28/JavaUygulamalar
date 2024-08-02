package works.application1.entities;

import works.application1.utilities.enums.EDesen;
import works.application1.utilities.enums.EKategori;
import works.application1.utilities.enums.EMateryal;
import works.application1.utilities.enums.ETur;

public class AksesuarUrunleri extends Urun {
	private ETur tur;
	private EMateryal materyal;
	private EDesen desen;
	
	public AksesuarUrunleri(String ad, Double fiyat, String aciklama, EKategori kategori, Integer adet, ETur tur, EMateryal materyal, EDesen desen) {
		super(ad, fiyat, aciklama, kategori, adet);
		this.tur = tur;
		this.materyal = materyal;
		this.desen = desen;
	}
	
	public ETur getTur() {
		return tur;
	}
	
	public void setTur(ETur tur) {
		this.tur = tur;
	}
	
	public EMateryal getMateryal() {
		return materyal;
	}
	
	public void setMateryal(EMateryal materyal) {
		this.materyal = materyal;
	}
	
	public EDesen getDesen() {
		return desen;
	}
	
	public void setDesen(EDesen desen) {
		this.desen = desen;
	}
	
	@Override
	public String toString() {
		return super.urunOzetBilgisi();
	}
	
	@Override
	public String urunDetayBilgisi() {
		return super.urunDetayBilgisi() + " tur: " + tur + " materyal: " + materyal + " desen: " + desen;
	}
}