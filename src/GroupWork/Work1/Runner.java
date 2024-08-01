package GroupWork.Work1;

import java.util.Scanner;

public class Runner extends Sabit {
	static Scanner scanner = new Scanner(System.in);
	//static Sepet sepet = new Sepet();
	static Kullanici aktifKullanici = null;
	
	public static void main(String[] args) {
		DataGenarator.gerericProducts();
		
		girisMenu();
	}
	
	public static void girisMenu() {
		int secim = -1;
		do {
			System.out.println("### GIRIS MENUSU ###");
			System.out.println("1- Giris Yap");
			System.out.println("2- Kayit Ol");
			System.out.println("0- Cikis");
			System.out.print("Lutfen bir secim yapiniz : ");
			try {
				secim = scanner.nextInt();
			}
			catch (Exception e) {
				System.out.println("Gecerli bir secim yapiniz.");
			}
			finally {
				scanner.nextLine();
			}
			girisFunctions(secim);
		} while (secim != 0 && aktifKullanici == null);
	}
	
	public static void girisFunctions(int secim) {
		switch (secim) {
			case 1: {
				KullaniciIslemleri.kullaniciGiris();
				break;
			}
			case 2: {
				KullaniciIslemleri.kullaniciKayit();
				break;
			}
			case 0: {
				System.out.println("Programdan cikiliyor...");
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Lutfen gecerli bir secim yapiniz!");
			}
		}
		if (aktifKullanici != null) {
			menu();
		}
	}
	
	public static void menu() {
		int secim = -1;
		do {
			System.out.println("### SEPET UYGULAMASI ###");
			System.out.println("1- Urunleri listele");
			System.out.println("2- Sepete urun ekle");
			System.out.println("3- Sepeti goruntule");
			System.out.println("4- Sepetten urun cikar");
			System.out.println("5- Sepeti onayla ve satin al");
			System.out.println("0- Cikis");
			System.out.print("Lutfen bir secim yapiniz : ");
			try {
				secim = scanner.nextInt();
			}
			catch (Exception e) {
				System.out.println("Gecerli bir secim yapiniz.");
			}
			finally {
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
				if (aktifKullanici != null) {
					Urun.urunArrayList.forEach(System.out::println);
					System.out.print("Secmek istediginiz urunun ID'sini giriniz : ");
					int id = scanner.nextInt();
					eklenecekUrunKontrolu(UrunDB.findById(id));
				}
				else {
					System.out.println("Lutfen once giris yapiniz.");
				}
				break;
			}
			case 3: {
				if (aktifKullanici != null) {
					aktifKullanici.getSepet().sepettekiUrunleriListele();
				}
				else {
					System.out.println("Lutfen once giris yapiniz.");
				}
				break;
			}
			case 4: {
				if (aktifKullanici != null) {
					aktifKullanici.getSepet().sepettekiUrunleriListele();
					System.out.print("Cikarmak istediginiz urunun ID'sini giriniz: ");
					int id = scanner.nextInt();
					silinecekUrunKontrolu(UrunDB.findById(id));
				}
				else {
					System.out.println("Lutfen once giris yapiniz.");
				}
				break;
			}
			case 5: {
				if (aktifKullanici != null) {
					aktifKullanici.getSepet().sepetiOnayla();
				}
				else {
					System.out.println("Lutfen once giris yapiniz.");
				}
				break;
			}
			case 0: {
				System.out.println("Programdan cikiliyor...");
				aktifKullanici = null;
				girisMenu();
				break;
			}
			default: {
				System.out.println("Lutfen gecerli bir secim yapiniz!");
			}
		}
		return secim;
	}
	
	private static Urun eklenecekUrunKontrolu(Urun urun) {
		while (true) {
			System.out.println(urun.urunDetayBilgisi());
			System.out.print("Kac adet eklemek istersiniz : ");
			int adet = scanner.nextInt();
			if (adet > 0) {
				if (adet <= urun.getKategori().getSinir()) {
					if (adet <= urun.getAdet()) {
						for (int j = 0; j < adet; j++) {
							aktifKullanici.getSepet().sepeteUrunEkle(urun);
						}
						System.out.println(urun.getAd() + " adlı üründen " + adet + " adet eklendi");
						return urun;
					}
					else {
						System.out.println("Yeteri kadar stok bulunamadı");
					}
					return null;
				}
				else {
					System.out.println("Bu üründen en fazla " + urun.getKategori().getSinir() + " adet alınabilir.");
				}
			}
			else {
				System.out.println("Bir üründen en az 1 adet alınabilir.");
			}
		}
	}
	
	private static Urun silinecekUrunKontrolu(Urun urun) {
		System.out.print("Kac adet silmek istersiniz? ");
		int silinecekAdet = scanner.nextInt();
		
		int sepetAdeti = 0;
		for (Urun u : aktifKullanici.getSepet().sepetList) {
			if (u.getUrunId().equals(urun.getUrunId())) {
				sepetAdeti++;
			}
		}
		
		if (silinecekAdet <= sepetAdeti) {
			for (int i = 0; i < silinecekAdet; i++) {
				aktifKullanici.getSepet().sepettenUrunCikart(urun);
			}
			System.out.println(urun.getAd() + " adli urunden " + silinecekAdet + " adet sepetten cikarildi.");
			return urun;
		}
		else {
			for (int i = 0; i < sepetAdeti; i++) {
				aktifKullanici.getSepet().sepettenUrunCikart(urun);
			}
			System.out.println("Silmek istediginiz adetten daha az urun bulunuyor. Sepetteki urunlerin tamami " +
					                   "cikarildi.");
		}
		return null;
	}
}