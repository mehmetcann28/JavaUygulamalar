package uygulamalar;

import java.util.ArrayList;

import uygulamalar.entities.Urun;
import uygulamalar.kullaniciIslemleri.entities.BaseEntity;
import uygulamalar.kullaniciIslemleri.entities.Kullanici;
import uygulamalar.kullaniciIslemleri.utility.DatabaseManager;

public class Sepet extends BaseEntity {
	private static Integer sepetIdCount=0;
	private Integer sepetId;
	private Integer kullaniciId=-1;
	ArrayList<Urun> sepetList;
	ArrayList<Urun>uniqueUrunler;
	ArrayList<Integer>adet;
	
	DatabaseManager<Kullanici> kullaniciList=new DatabaseManager<>();
	
	public Sepet() {
		this.sepetList = new ArrayList<>();
		this.uniqueUrunler=new ArrayList<>();
		this.adet=new ArrayList<>();
		this.sepetId=++sepetIdCount;
		
	}
	
	public Integer getSepetId() {
		return sepetId;
	}
	
	public Integer getKullaniciId() {
		return kullaniciId;
	}
	
	public void setKullaniciId(Integer kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	
	public ArrayList<Urun> sepettenUrunCikart(Urun urun){
		if(sepetList.remove(urun)) {
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
	public ArrayList<Urun> sepeteUrunEkle(Urun urun){
		sepetList.add(urun);
		return sepetList;
	}
	public void sepetiOnayla(){
		for (Urun urun : sepetList) {
			urun.setAdet(urun.getAdet() - 1);
		}
		sepetList.clear();
		System.out.println("Sepet onaylandi. Satin alim gerceklesti.");
		
		
	}
	
	public ArrayList<Urun> sepettekiUrunleriListele() {
		uniqueUrunler.clear();
		adet.clear();
		
		// Unique ürünleri ve adetlerini güncelle
		for (Urun urun : sepetList) {
			if (uniqueUrunler.contains(urun)) {
				int index = uniqueUrunler.indexOf(urun);
				adet.set(index, adet.get(index) + 1);
			} else {
				uniqueUrunler.add(urun);
				adet.add(1);
			}
		}
		
		// Unique ürünleri ve adetlerini yazdýr
		double toplam = 0;
		for (int i = 0; i < uniqueUrunler.size(); i++) {
			Urun urun = uniqueUrunler.get(i);
			int urunlerAdet = adet.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("Urun ID'si: " + urun.getUrunId() + "\t|\t" + " Urun Adi: " + urun.getAd() + "\t|\t" + " Urun Adedi: " + urunlerAdet + "\t|\t" + " Urun Birim Fiyat: " + fiyat+"\t|\t" +"Urun Toplam Fiyat : "+(urunlerAdet*fiyat));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.println("Toplam fiyat: " + toplam);
		return sepetList;
	}
	
	@Override
	public String toString() {
		return "Sepet{" + "sepetId=" + getSepetId() + ", kullaniciId=" + getKullaniciId() + ", sepetList=" + sepetList + ", uniqueUrunler=" + uniqueUrunler + ", adet=" + adet + ", kullaniciList=" + kullaniciList + '}';
	}
}