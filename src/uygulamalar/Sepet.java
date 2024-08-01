package uygulamalar;

import java.util.ArrayList;
import uygulamalar.entities.Urun;
import uygulamalar.kullaniciIslemleri.entities.BaseEntity;

public class Sepet extends BaseEntity {
	private static Integer sepetIdCount = 0;
	private Integer kullaniciId; // Sepeti kullanıcı ile ilişkilendirmek için kullanıcı ID'si
	ArrayList<Urun> sepetList;
	ArrayList<Urun> uniqueUrunler;
	ArrayList<Integer> adet;
	
	public Sepet() {
		this.sepetList = new ArrayList<>();
		this.uniqueUrunler = new ArrayList<>();
		this.adet = new ArrayList<>();
		this.id = ++sepetIdCount;
	}
	
	public Integer getKullaniciId() {
		return kullaniciId;
	}
	
	public void setKullaniciId(Integer kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	
	public ArrayList<Urun> sepettenUrunCikart(Urun urun) {
		if (sepetList.remove(urun)) {
			int index = uniqueUrunler.indexOf(urun);
			if (index != -1) {
				int mevcutAdet = adet.get(index);
				if (mevcutAdet > 1) {
					adet.set(index, mevcutAdet - 1);
				} else {
					uniqueUrunler.remove(index);
					adet.remove(index);
				}
			}
		}
		return sepetList;
	}
	
	public ArrayList<Urun> sepeteUrunEkle(Urun urun) {
		sepetList.add(urun);
		return sepetList;
	}
	
	public void sepetiOnayla() {
		for (Urun urun : sepetList) {
			urun.setAdet(urun.getAdet() - 1);
		}
		sepetList.clear();
		System.out.println("Sepet onaylandi. Satin alim gerceklesti.");
	}
	
	public ArrayList<Urun> sepettekiUrunleriListele() {
		uniqueUrunler.clear();
		adet.clear();
		
		for (Urun urun : sepetList) {
			if (uniqueUrunler.contains(urun)) {
				int index = uniqueUrunler.indexOf(urun);
				adet.set(index, adet.get(index) + 1);
			} else {
				uniqueUrunler.add(urun);
				adet.add(1);
			}
		}
		
		double toplam = 0;
		for (int i = 0; i < uniqueUrunler.size(); i++) {
			Urun urun = uniqueUrunler.get(i);
			int urunlerAdet = adet.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("Urun ID'si: " + urun.getUrunId() + "\t|\t" + " Urun Adi: " + urun.getAd() + "\t|\t" + " Urun Adedi: " + urunlerAdet + "\t|\t" + " Urun Birim Fiyat: " + fiyat+" * "+urunlerAdet+" : "+(fiyat*urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.println("Toplam fiyat: " + toplam);
		return sepetList;
	}
}