package works.application1;

import works.application1.entities.Urun;
import works.application1.kullaniciIslemleri.entities.Kullanici;

import java.util.ArrayList;


public class Sepet {
	private static Integer sepetIdCount = 0;
	private Integer sepetId;
	private ArrayList<Urun> sepetList;
	private ArrayList<Urun> uniqueUrunler;
	private ArrayList<Integer> adet;
	
	public Sepet() {
		this.sepetList = new ArrayList<>();
		this.uniqueUrunler = new ArrayList<>();
		this.adet = new ArrayList<>();
		this.sepetId = ++sepetIdCount;
	}
	
	public Integer getSepetId() {
		return sepetId;
	}
	
	public ArrayList<Urun> getSepetList() {
		return sepetList;
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
			System.out.println("Urun ID'si: " + urun.getUrunId() + "\t|\t" + " Urun Adi: " + urun.getAd() + "\t|\t" + " Urun Adedi: " + urunlerAdet + "\t|\t" + " Urun Birim Fiyat: " + fiyat + " * " + urunlerAdet + " : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.println("Toplam fiyat: " + toplam);
		return sepetList;
	}
}