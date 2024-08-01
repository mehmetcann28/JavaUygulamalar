package uygulamalar;
//
//import java.util.Scanner;
//
//public class Runner {
//	static Scanner scanner = new Scanner(System.in);
//	static Sepet sepet=new Sepet();
//
//	public static void main(String[] args) {
//		GiyimUrunleri urun1 =
//				new GiyimUrunleri("T-shirt", 50d, "Aciklama", EKategori.GIYIM, 15, EBeden.M, ERenk.KIRMIZI);
//		GiyimUrunleri urun2 =
//				new GiyimUrunleri("Pantolon", 150d, "Aciklama2", EKategori.GIYIM, 10, EBeden.L, ERenk.SIYAH);
//		GiyimUrunleri urun3 =
//				new GiyimUrunleri("Gomlek", 250d, "Aciklama3", EKategori.GIYIM, 100, EBeden.XL, ERenk.YESIL);
//		AksesuarUrunleri aksesuar1 =
//				new AksesuarUrunleri("Kolye", 100d, "Altın Kolye", EKategori.AKSESUAR, 5, ETur.KOLYE, EMateryal.ALTIN, EDesen.DUZ);
//		AksesuarUrunleri aksesuar2 =
//				new AksesuarUrunleri("Saat", 200d, "Gümüş Saat", EKategori.AKSESUAR, 3, ETur.SAAT, EMateryal.GUMUS, EDesen.CIZGILI);
//		menu();
//	}
//
//	public static void menu() {
//		int secim = -1;
//		do {
//			System.out.println("### SEPET UYGULUMASI ###");
//			System.out.println("1- Urunleri listele");
//			System.out.println("2- Sepete urun ekle");
//			System.out.println("3- Sepeti goruntule");
//			System.out.println("4- Sepetten urun cikar");
//			System.out.print("Lutfen bir secim yapiniz : ");
//			try {
//				secim = scanner.nextInt();
//			}
//			catch (Exception e) {
//				System.out.println("Gecerli bir secim yapiniz.");
//			}
//			finally {
//				scanner.nextLine();
//			}
//			sepetFunctions(secim);
//		} while (secim != 0);
//	}
//
//	private static int sepetFunctions(int secim) {
//		switch (secim) {
//			case 1: {
//				Urun.urunArrayList.forEach(System.out::println);
//				break;
//			}
//			case 2: {
//				Urun.urunArrayList.forEach(System.out::println);
//				System.out.print("Secmek istediginiz urunun ID'sini giriniz : ");
//				int id = scanner.nextInt();
//				eklenecekUrunKontrolu(UrunDB.findById(id));
//				break;
//			}
//			case 3: {
//				sepet.sepettekiUrunleriListele();
//				break;
//			}
//			case 4: {
//				sepet.sepettekiUrunleriListele();
//
//				System.out.print(" istediğiniz ürünün ID'sini giriniz : ");
//				int id= scanner.nextInt();
//				silinecekUrunKontrolu(UrunDB.findById(id));
//				break;
//			}
//			default: {
//				System.out.println("Lutfen gecerli bir secim yapiniz!");
//			}
//		}
//		return secim;
//	}
//
//
//
//	private static Urun eklenecekUrunKontrolu(Urun urun) {
//
//		System.out.println(urun.urunDetayBilgisi());
//		System.out.print("Kaç adet eklemek istersiniz : ");
//		int adet = scanner.nextInt();
//		if (adet <= urun.getAdet()) {
//			for (int j = 0; j < adet; j++) {
//				sepet.sepeteUrunEkle(urun);
//			}
//			urun.setAdet(urun.getAdet() - adet);
//			System.out.println(urun.getAd()+" adlı üründen "+adet+" adet eklendi");
//			return urun;
//		}
//		else {
//			System.out.println("Yeteri kadar stok bulunamadı");
//		}
//		return null;
//	}
//	private static Urun silinecekUrunKontrolu(Urun urun) {
//		System.out.print("Kac adet silmek istersiniz? ");
//		int silinecekAdet = scanner.nextInt();
//
//		// Sepette bu urunun adetini bulalım
//		int sepetAdeti = 0;
//		for (Urun u : sepet.sepetList) {
//			if (u.getUrunId().equals(urun.getUrunId())) {
//				sepetAdeti++;
//			}
//		}
//
//		if (silinecekAdet <= sepetAdeti) {
//			for (int i = 0; i < silinecekAdet; i++) {
//				sepet.sepettenUrunCikart(urun);
//			}
//			urun.setAdet(urun.getAdet() + silinecekAdet);
//			System.out.println(urun.getAd() + " adli urunden " + silinecekAdet + " adet sepetten cikarildi.");
//			return urun;
//		} else {
//			for (int i = 0; i < sepetAdeti; i++) {
//				sepet.sepettenUrunCikart(urun);
//			}
//			urun.setAdet(urun.getAdet() + sepetAdeti);
//			System.out.println("Silmek istediginiz adetten daha az urun bulunuyor. Sepetteki urunlerin tamami cikarildi.");
//		}
//		return null;
//	}
//
//}

import uygulamalar.utilities.DataGenerator;

import java.util.Scanner;

public class Runner {
	static Scanner scanner = new Scanner(System.in);
	static Sepet sepet = new Sepet();
	
	public static void main(String[] args) {
		
		DataGenerator.generateProduct();
		menu();
	}
	
	public static void menu() {
		int secim = -1;
		do {
			System.out.println("### SEPET UYGULAMASI ###");
			System.out.println("1- Urunleri listele");
			System.out.println("2- Sepete urun ekle");
			System.out.println("3- Sepeti goruntule");
			System.out.println("4- Sepetten urun cikar");
			System.out.print("Lutfen bir secim yapiniz : ");
			try {
				secim = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Gecerli bir secim yapiniz.");
			} finally {
				scanner.nextLine();
			}
			sepetFunctions(secim);
		} while (secim != 0);
	}
	
	private static int sepetFunctions(int secim) {
		switch (secim) {
			case 1: {
				Urun.urunArrayList.forEach(System.out::println);
				break;
			}
			case 2: {
				Urun.urunArrayList.forEach(System.out::println);
				System.out.print("Secmek istediginiz urunun ID'sini giriniz : ");
				int id = scanner.nextInt();
				eklenecekUrunKontrolu(UrunDB.findById(id));
				break;
			}
			case 3: {
				sepet.sepettekiUrunleriListele();
				break;
			}
			case 4: {
				sepet.sepettekiUrunleriListele();
				System.out.print("Cikarmak istediginiz urunun ID'sini giriniz: ");
				int id = scanner.nextInt();
				silinecekUrunKontrolu(UrunDB.findById(id));
				break;
			}
			default: {
				System.out.println("Lutfen gecerli bir secim yapiniz!");
			}
		}
		return secim;
	}
	
	private static Urun eklenecekUrunKontrolu(Urun urun) {
		System.out.println(urun.urunDetayBilgisi());
		System.out.print("Kac adet eklemek istersiniz : ");
		int adet = scanner.nextInt();
		if (adet <= urun.getAdet()) {
			for (int j = 0; j < adet; j++) {
				sepet.sepeteUrunEkle(urun);
			}
			urun.setAdet(urun.getAdet() - adet);
			System.out.println(urun.getAd() + " adlı üründen " + adet + " adet eklendi");
			return urun;
		} else {
			System.out.println("Yeteri kadar stok bulunamadı");
		}
		return null;
	}
	
	private static Urun silinecekUrunKontrolu(Urun urun) {
		System.out.print("Kac adet silmek istersiniz? ");
		int silinecekAdet = scanner.nextInt();
		
		int sepetAdeti = 0;
		for (Urun u : sepet.sepetList) {
			if (u.getUrunId().equals(urun.getUrunId())) {
				sepetAdeti++;
			}
		}
		
		if (silinecekAdet <= sepetAdeti) {
			for (int i = 0; i < silinecekAdet; i++) {
				sepet.sepettenUrunCikart(urun);
			}
			urun.setAdet(urun.getAdet() + silinecekAdet);
			System.out.println(urun.getAd() + " adli urunden " + silinecekAdet + " adet sepetten cikarildi.");
			return urun;
		} else {
			for (int i = 0; i < sepetAdeti; i++) {
				sepet.sepettenUrunCikart(urun);
			}
			urun.setAdet(urun.getAdet() + sepetAdeti);
			System.out.println("Silmek istediginiz adetten daha az urun bulunuyor. Sepetteki urunlerin tamami cikarildi.");
		}
		return null;
	}
}