package GroupWork.Work1;
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
//			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat *
//			urunlerAdet));
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

import GroupWork.Work1.entities.*;

import java.util.ArrayList;

public class Sepet {
	private static Integer sepetIdCount = 0;
	private Integer sepetId;
	ArrayList<Urun> sepetList;
	private ArrayList<Urun> giyimUrunleri = new ArrayList<>();
	private ArrayList<Integer> giyimAdetleri = new ArrayList<>();
	private ArrayList<Urun> aksesuarUrunleri = new ArrayList<>();
	private ArrayList<Integer> aksesuarAdetleri = new ArrayList<>();
	private ArrayList<Urun> elektronikUrunleri = new ArrayList<>();
	private ArrayList<Integer> elektronikAdetleri = new ArrayList<>();
	private ArrayList<Urun> bakimUrunleri = new ArrayList<>();
	private ArrayList<Integer> bakimAdetleri = new ArrayList<>();
	private ArrayList<Urun> yiyecekUrunleri = new ArrayList<>();
	private ArrayList<Integer> yiyecekAdetleri = new ArrayList<>();
	
	
	public Sepet() {
		this.sepetList = new ArrayList<>();
		this.sepetId = ++sepetIdCount;
	}
	
	public ArrayList<Urun> sepeteUrunEkle(Urun urun) {
		sepetList.add(urun);
		return sepetList;
	}
	
	public ArrayList<Urun> sepettekiUrunleriListele() {
		giyimUrunleri.clear();
		giyimAdetleri.clear();
		aksesuarUrunleri.clear();
		aksesuarAdetleri.clear();
		bakimUrunleri.clear();
		bakimAdetleri.clear();
		yiyecekUrunleri.clear();
		yiyecekAdetleri.clear();
		elektronikUrunleri.clear();
		elektronikAdetleri.clear();
		
		for (Urun urun : sepetList) {
			if (urun instanceof GiyimUrunleri) {
				if (giyimUrunleri.contains(urun)) {
					int index = giyimUrunleri.indexOf(urun);
					giyimAdetleri.set(index, giyimAdetleri.get(index) + 1);
				}
				else {
					giyimUrunleri.add(urun);
					giyimAdetleri.add(1);
				}
			}
			else if (urun instanceof AksesuarUrunleri) {
				if (aksesuarUrunleri.contains(urun)) {
					int index = aksesuarUrunleri.indexOf(urun);
					aksesuarAdetleri.set(index, aksesuarAdetleri.get(index) + 1);
				}
				else {
					aksesuarUrunleri.add(urun);
					aksesuarAdetleri.add(1);
				}
			}
			else if (urun instanceof Yiyecek) {
				if (yiyecekUrunleri.contains(urun)) {
					int index = yiyecekUrunleri.indexOf(urun);
					yiyecekAdetleri.set(index, yiyecekAdetleri.get(index) + 1);
				}
				else {
					yiyecekUrunleri.add(urun);
					yiyecekAdetleri.add(1);
				}
			}
			else if (urun instanceof BakimUrunleri) {
				if (bakimUrunleri.contains(urun)) {
					int index = bakimUrunleri.indexOf(urun);
					bakimAdetleri.set(index, bakimAdetleri.get(index) + 1);
				}
				else {
					bakimUrunleri.add(urun);
					bakimAdetleri.add(1);
				}
			}
			else if (urun instanceof ElektronikUrunleri) {
				if (elektronikUrunleri.contains(urun)) {
					int index = elektronikUrunleri.indexOf(urun);
					elektronikAdetleri.set(index, elektronikAdetleri.get(index) + 1);
				}
				else {
					elektronikUrunleri.add(urun);
					elektronikAdetleri.add(1);
				}
			}
		}
		double toplam = 0;
		System.out.print("\nGiyim Ürünleri:");
		for (int i = 0; i < giyimUrunleri.size(); i++) {
			Urun urun = giyimUrunleri.get(i);
			int urunlerAdet = giyimAdetleri.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.print("\nAksesuar Ürünleri:");
		for (int i = 0; i < aksesuarUrunleri.size(); i++) {
			Urun urun = aksesuarUrunleri.get(i);
			int urunlerAdet = aksesuarAdetleri.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.print("\nYiyecek Ürünleri:");
		for (int i = 0; i < yiyecekUrunleri.size(); i++) {
			Urun urun = yiyecekUrunleri.get(i);
			int urunlerAdet = yiyecekAdetleri.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.print("\nBakım Ürünleri:");
		for (int i = 0; i < bakimUrunleri.size(); i++) {
			Urun urun = bakimUrunleri.get(i);
			int urunlerAdet = bakimAdetleri.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.print("\nElektronik Ürünleri:");
		for (int i = 0; i < elektronikUrunleri.size(); i++) {
			Urun urun = elektronikUrunleri.get(i);
			int urunlerAdet = elektronikAdetleri.get(i);
			double fiyat = urun.getFiyat();
			System.out.println("urunAd : " + urun.getAd() + " urun adet : " + urunlerAdet + " fiyat : " + (fiyat * urunlerAdet));
			toplam += urun.getFiyat() * urunlerAdet;
		}
		System.out.println("\nToplam fiyat : " + toplam);
		return sepetList;
	}
	
	public void sepetiOnayla() {
		for (Urun urun : sepetList) {
			urun.setAdet(urun.getAdet() - 1);
		}
		sepetList.clear();
		System.out.println("Sepet onaylandi ve satin alma gerceklesti.");
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
		}
		else {
			System.out.println("Bu ürün sepetinizde bulunmamaktadır.");
		}
		
		return sepetList;
	}
}