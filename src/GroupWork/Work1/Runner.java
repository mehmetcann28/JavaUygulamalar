package GroupWork.Work1;

import GroupWork.Work1.entities.*;
import GroupWork.Work1.utilities.enums.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Runner extends Sabit {
	static Scanner scanner = new Scanner(System.in);
	static Sepet sepet = new Sepet();
	static Random random = new Random();
	static Kullanici aktifKullanici = null;
	
	public static void main(String[] args) {
		ArrayList<Urun> urunListesi = new ArrayList<>();
		for (int i = 0; i < 40; i++) {
			Urun urun = createRandomUrun();
			urunListesi.add(urun);
			Urun.urunArrayList.add(urun);
		}
		
		girisMenu();
	}
	
	private static Urun createRandomUrun() {
		EKategori kategori = EKategori.values()[random.nextInt(EKategori.values().length)];
		
		switch (kategori) {
			case GIYIM:
				return createRandomGiyimUrunleri();
			case AKSESUAR:
				return createRandomAksesuarUrunleri();
			case ELEKTRONIK:
				return createRandomElektronikUrunleri();
			case BAKIM:
				return createRandomBakimUrunleri();
			case YIYECEK:
				return createRandomYiyecekUrunleri();
			default:
				return null;
		}
	}
	
	private static GiyimUrunleri createRandomGiyimUrunleri() {
		String[] urunIsimleri =
				{"T-shirt", "Pantolon", "Gomlek", "Ceket", "Etek", "Elbise", "Sweatshirt", "Kazak", "Mont", "Atlet"};
		String isim = urunIsimleri[random.nextInt(urunIsimleri.length)];
		double fiyat = 50 + (150 * random.nextDouble());
		fiyat = Sabit.formatAndParseDouble(fiyat);
		String aciklama = isim + " - Açıklama";
		EBeden beden = EBeden.values()[random.nextInt(EBeden.values().length)];
		ERenk renk = ERenk.values()[random.nextInt(ERenk.values().length)];
		int adet = random.nextInt(100) + 1;
		return new GiyimUrunleri(isim, fiyat, aciklama, EKategori.GIYIM, adet, beden, renk);
	}
	
	private static AksesuarUrunleri createRandomAksesuarUrunleri() {
		String[] urunIsimleri =
				{"Kolye", "Saat", "Bilezik", "Küpe", "Yüzük", "Broş", "Kravats", "Şapka", "Kemer", "Gözlük"};
		String isim = urunIsimleri[random.nextInt(urunIsimleri.length)];
		double fiyat = 50 + (1000 * random.nextDouble());
		fiyat = Sabit.formatAndParseDouble(fiyat);
		String aciklama = isim + " - Açıklama";
		ETur tur = ETur.values()[random.nextInt(ETur.values().length)];
		EMateryal materyal = EMateryal.values()[random.nextInt(EMateryal.values().length)];
		EDesen desen = EDesen.values()[random.nextInt(EDesen.values().length)];
		int adet = random.nextInt(100) + 1;
		return new AksesuarUrunleri(isim, fiyat, aciklama, EKategori.AKSESUAR, adet, tur, materyal, desen);
	}
	
	private static ElektronikUrunleri createRandomElektronikUrunleri() {
		String[] urunIsimleri =
				{"Telefon", "Bilgisayar", "Tablet", "Televizyon", "Kulaklık", "Mikrodalga", "Fırın", "Buzdolabı",
						"Çamaşır Makinesi", "Süpürge"};
		String isim = urunIsimleri[random.nextInt(urunIsimleri.length)];
		double fiyat = 500 + (10000 * random.nextDouble());
		fiyat = Sabit.formatAndParseDouble(fiyat);
		String aciklama = isim + " - Açıklama";
		ECihazTipi cihazTipi = ECihazTipi.values()[random.nextInt(ECihazTipi.values().length)];
		int pilOmru = random.nextInt(100) + 1;
		double calismaVoltaji = 1 + (220 * random.nextDouble());
		int adet = random.nextInt(100) + 1;
		return new ElektronikUrunleri(isim, fiyat, aciklama, EKategori.ELEKTRONIK, adet, pilOmru, calismaVoltaji,
		                              cihazTipi);
	}
	
	private static BakimUrunleri createRandomBakimUrunleri() {
		String[] urunIsimleri =
				{"Deodorant", "Parfüm", "Sabun", "Losyon", "Krem", "Jel", "Yağ", "Sprey", "Maske", "Köpük"};
		String isim = urunIsimleri[random.nextInt(urunIsimleri.length)];
		double fiyat = 30 + (200 * random.nextDouble());
		fiyat = Sabit.formatAndParseDouble(fiyat);
		String aciklama = isim + " - Açıklama";
		EBakimUrunleriTipler bakimUrunuTipi =
				EBakimUrunleriTipler.values()[random.nextInt(EBakimUrunleriTipler.values().length)];
		int adet = random.nextInt(100) + 1;
		return new BakimUrunleri(isim, fiyat, aciklama, EKategori.BAKIM, adet, bakimUrunuTipi);
	}
	
	private static Yiyecek createRandomYiyecekUrunleri() {
		String[] urunIsimleri =
				{"Elma", "Portakal", "Kavun", "Karpuz", "Patates", "Domates", "Salatalık", "Tavuk", "Balık", "Peynir"};
		String isim = urunIsimleri[random.nextInt(urunIsimleri.length)];
		double fiyat = 5 + (50 * random.nextDouble());
		fiyat = Sabit.formatAndParseDouble(fiyat);
		String aciklama = isim + " - Açıklama";
		EYiyecekTipi yiyecekTipi = EYiyecekTipi.values()[random.nextInt(EYiyecekTipi.values().length)];
		int adet = random.nextInt(100) + 1;
		return new Yiyecek(isim, fiyat, aciklama, EKategori.YIYECEK, adet, yiyecekTipi);
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