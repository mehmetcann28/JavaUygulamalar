package uygulamalar;
//
//import java.util.ArrayList;
//
//public class Sepet {
//	private static Integer sepetIdCount = 0;
//	private Integer sepetId;
//	ArrayList<Urun> sepetList;
//	ArrayList<Urun> uniqueUrunler;
//	ArrayList<Integer> urunAdetleri;
//
//	public Sepet() {
//		this.sepetList = new ArrayList<>();
//		this.sepetId = ++sepetIdCount;
//		this.uniqueUrunler=new ArrayList<>();
//		this.urunAdetleri=new ArrayList<>();
//	}
//
//	public ArrayList<Urun> sepeteUrunEkle(Urun urun) {
//		sepetList.add(urun);
//		return sepetList;
//	}
//
//	//	public ArrayList<Urun> sepettekiUrunleriListele(){
////		double toplam=0;
////		for (int i = 0; i < sepetList.size(); i++) {
////			System.out.println(sepetList.get(i).getFiyat());
////			toplam=toplam+sepetList.get(i).getFiyat();
////		}
////		System.out.println("Toplam fiyat : "+toplam);
////		return sepetList;
////	}
//	public ArrayList<Urun> sepettekiUrunleriListele() {
//		uniqueUrunler.clear();
//		urunAdetleri.clear();
//
//		for (Urun urun : sepetList) {
//			if (uniqueUrunler.contains(urun)) {
//				int index = uniqueUrunler.indexOf(urun);
//				urunAdetleri.set(index, urunAdetleri.get(index) + 1);
//			} else {
//				uniqueUrunler.add(urun);
//				urunAdetleri.add(1);
//			}
//		}
//
//		double toplam = 0;
//		for (int i = 0; i < uniqueUrunler.size(); i++) {
//			Urun urun = uniqueUrunler.get(i);
//			int urunlerAdet = urunAdetleri.get(i);
//			double fiyat = urun.getFiyat();
//			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
//			toplam += urun.getFiyat() * urunlerAdet;
//		}
//		System.out.println(" Toplam fiyat : " + toplam);
//		return sepetList;
//	}
//	public ArrayList<Urun> sepettenUrunCikart(Urun urun){
//		if(sepetList.remove(urun)) {
//			int index = uniqueUrunler.indexOf(urun);
//			if (index != -1) {
//				int mevcutAdet = urunAdetleri.get(index);
//				if (mevcutAdet > 1) {
//					urunAdetleri.set(index, mevcutAdet - 1);
//				} else {
//					uniqueUrunler.remove(index);
//					urunAdetleri.remove(index);
//				}
//			}
//		}
//		return sepetList;
//	}
//}

import uygulamalar.entities.AksesuarUrunleri;
import uygulamalar.entities.GiyimUrunleri;

import java.util.ArrayList;

public class Sepet {
	private static Integer sepetIdCount = 0;
	private Integer sepetId;
	ArrayList<Urun> sepetList;
	private ArrayList<Urun> uniqueUrunler = new ArrayList<>();
	private ArrayList<Integer> urunAdetleri = new ArrayList<>();
	private ArrayList<Urun> uniqueAksesuarlar = new ArrayList<>();
	private ArrayList<Integer> aksesuarAdetleri = new ArrayList<>();
	
	public Sepet() {
		this.sepetList = new ArrayList<>();
		this.sepetId = ++sepetIdCount;
	}
	
	public ArrayList<Urun> sepeteUrunEkle(Urun urun) {
		sepetList.add(urun);
		return sepetList;
	}
	
	public ArrayList<Urun> sepettekiUrunleriListele() {
		uniqueUrunler.clear();
		urunAdetleri.clear();
		uniqueAksesuarlar.clear();
		aksesuarAdetleri.clear();
		
		for (Urun urun : sepetList) {
			if (urun instanceof GiyimUrunleri) {
				if (uniqueUrunler.contains(urun)) {
					int index = uniqueUrunler.indexOf(urun);
					urunAdetleri.set(index, urunAdetleri.get(index) + 1);
				} else {
					uniqueUrunler.add(urun);
					urunAdetleri.add(1);
				}
			} else if (urun instanceof AksesuarUrunleri) {
				if (uniqueAksesuarlar.contains(urun)) {
					int index = uniqueAksesuarlar.indexOf(urun);
					aksesuarAdetleri.set(index, aksesuarAdetleri.get(index) + 1);
				} else {
					uniqueAksesuarlar.add(urun);
					aksesuarAdetleri.add(1);
				}
			}
		}
		
		double toplam = 0;
		System.out.println("Giyim Ürünleri:");
		for (int i = 0; i < uniqueUrunler.size(); i++) {
			Urun urun = uniqueUrunler.get(i);
			int urunlerAdet = urunAdetleri.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.println("Aksesuar Ürünleri:");
		for (int i = 0; i < uniqueAksesuarlar.size(); i++) {
			Urun urun = uniqueAksesuarlar.get(i);
			int urunlerAdet = aksesuarAdetleri.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.println(" Toplam fiyat : " + toplam);
		return sepetList;
	}
	
	public ArrayList<Urun> sepettenUrunCikart(Urun urun) {
		if (urun == null) {
			System.out.println("Bu ID'ye sahip bir ürün bulunamadı.");
			return sepetList;
		}
		
		int urunIndex = -1;
		for (int i = 0; i < sepetList.size(); i++) {
			if (sepetList.get(i).equals(urun)) {
				urunIndex = i;
				break;
			}
		}
		
		if (urunIndex != -1) {
			sepetList.remove(urunIndex);
			urun.setAdet(urun.getAdet() + 1);  // Ürünün adedini geri ekleyelim
			System.out.println(urun.getAd() + " adlı üründen bir adet çıkarıldı");
		} else {
			System.out.println("Bu ürün sepetinizde bulunmamaktadır.");
		}
		
		return sepetList;
	}
}