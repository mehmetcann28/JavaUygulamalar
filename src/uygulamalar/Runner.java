package uygulamalar;
import uygulamalar.entities.Urun;
import uygulamalar.utilities.DataGenerator;
import uygulamalar.kullaniciIslemleri.entities.Kullanici;
import uygulamalar.kullaniciIslemleri.KullaniciKayitSistemi;

import java.util.Scanner;

public class Runner extends Sabit{
	static Scanner scanner = new Scanner(System.in);
	public static Sepet sepet = new Sepet();
	public static Kullanici aktifKullanici = null;
	
	public static void main(String[] args) {
		DataGenerator.generateProducts();
		menu();
	}
	
	public static void menu() {
		int secim = -1;
		do {
			System.out.println("### SEPET UYGULUMASI ###");
			System.out.println("1- Urunleri listele");
			System.out.println("2- Sepete urun ekle");
			System.out.println("3- Sepeti goruntule");
			System.out.println("4- Sepetten urun cikar");
			System.out.println("5- Sepeti Onayla");
			if (aktifKullanici==null){
				System.out.println("6- Kayıt ol veya Giriş yap");
			}
			else {
				System.out.println("7- Önceki Siparişler");
			}
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
				Urun.urunArrayList.forEach(System.out::println);
				System.out.print("Secmek istediginiz urunun ID'sini giriniz : ");
				int id = scanner.nextInt();
				eklenecekUrunKontrolu(UrunDB.findById(id));
				break;
			}
			case 3: {
				gecerliSepetiAl().sepettekiUrunleriListele();//☺
				break;
			}
			case 4: {
				gecerliSepetiAl().sepettekiUrunleriListele();//☺
				System.out.print("Cikartmak istediginiz urunun ID'sini giriniz : ");
				int id = scanner.nextInt();
				silinecekUrunKontrolu(UrunDB.findById(id));
				break;
			}
			case 5: {
				if (aktifKullanici == null) {
					System.out.println("Sepeti onaylamadan önce kayıt olmanız veya giriş yapmanız gerekmektedir");
					KullaniciKayitSistemi.menu();
				}
				else {
					aktifKullanici.getSepet().sepetiOnayla();
					aktifKullanici.addSepetToSepetList(aktifKullanici.getSepet());
					aktifKullanici.setSepet(new Sepet());
					aktifKullanici.getSepet().setKullaniciId(aktifKullanici.getId());//☺
				}
				break;
			}
			case 6: {
				if (aktifKullanici == null) {
					KullaniciKayitSistemi.menu();
					if (aktifKullanici != null) {
						sepetiKullaniciSepetineAktarma();
					}
				}
				break;
			}
			case 0: {
				System.out.println("Uygulama sonlandiriliyor...");
				break;
			}
			default: {
				System.out.println("Lutfen gecerli bir secim yapiniz!");
				break;
			}
		}
		return secim;
	}
	
	/*public static void girisMenu() {
		int secim = -1;
		do {
			System.out.println("### GIRIS MENUSU ###");
			System.out.println("1- Giris Yap");
			System.out.println("2- Kayit Ol");
			System.out.println("0- Geri");
			System.out.print("Lutfen bir secim yapiniz : ");
			try {
				secim = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Gecerli bir secim yapiniz.");
			} finally {
				scanner.nextLine();
			}
			switch (secim) {
				case 1:
					aktifKullanici = KullaniciKayitSistemi.girisYap();
					if (aktifKullanici != null) {
						System.out.println("Giris basarili! Hoşgeldiniz, " + aktifKullanici.getKullaniciAdi());
					} else {
						System.out.println("Giris basarisiz. Lutfen tekrar deneyiniz.");
					}
					break;
				case 2:
					aktifKullanici = KullaniciKayitSistemi.kullaniciKaydi();
					if (aktifKullanici != null) {
						System.out.println("Kayit basarili! Hoşgeldiniz, " + aktifKullanici.getKullaniciAdi());
					} else {
						System.out.println("Kayit basarisiz. Lutfen tekrar deneyiniz.");
					}
					break;
				case 0:
					return;
				default:
					System.out.println("Lutfen gecerli bir secim yapiniz!");
					break;
			}
		} while (secim != 0 && aktifKullanici == null);
	}*/
	
	
	
	private static Urun silinecekUrunKontrolu(Urun urun) {
		System.out.print("Kac adet silmek istersiniz? ");
		int silinecekAdet = scanner.nextInt();
		Sepet sepet1=gecerliSepetiAl();
		// Sepette bu urunun adetini bulalım
		int sepetAdeti = 0;
		for (Urun u : sepet1.sepetList) {//☺
			if (u.getUrunId().equals(urun.getUrunId())) {
				sepetAdeti++;
			}
		}
		
		if (silinecekAdet <= sepetAdeti) {
			for (int i = 0; i < silinecekAdet; i++) {
				sepet1.sepettenUrunCikart(urun);//☺
			}
			urun.setAdet(urun.getAdet() + silinecekAdet);
			System.out.println(urun.getAd() + " adli urunden " + silinecekAdet + " adet sepetten cikarildi.");
			return urun;
		}
		else {
			for (int i = 0; i < sepetAdeti; i++) {
				sepet1.sepettenUrunCikart(urun);//☺
			}
			urun.setAdet(urun.getAdet() + sepetAdeti);
			System.out.println("Silmek istediginiz adetten daha az urun bulunuyor. Sepetteki urunlerin tamami " + "cikarildi.");
		}
		return null;
	}
	
	private static Urun eklenecekUrunKontrolu(Urun urun) {
		while (true) {
			System.out.println(urun.urunDetayBilgisi());
			System.out.print("Kac adet eklemek istersiniz ?");
//			Integer adet1 = urun.getAdet();
			
			int adet = scanner.nextInt();
			if (adet > 0) {
				if (adet <= urun.getKategori().getSinir()) {
					if (adet <= urun.getAdet()) {
						Sepet sepet1=gecerliSepetiAl();
						for (int j = 0; j < adet; j++) {
							sepet1.sepeteUrunEkle(urun);//☺
						}
						/*						urun.setAdet(adet1 - adet);*/
						System.out.println(urun.getAd() + " adli urunden " + adet + " adet eklendi.");
						return urun;
					}
					else {
						System.out.println("Yeterli stok bulunamadi!");
					}
				}
				else {
					System.out.println("Bu urunden en fazla " + urun.getKategori().getSinir() + " adet alinabilir");
				}
			}
			else System.out.println("Bir urunden en az 1 adet alinabilir!");
		}
	}
	private static Sepet gecerliSepetiAl() {
		if (aktifKullanici != null) {
			return aktifKullanici.getSepet();
		} else {
			return sepet;
		}
	}
	private static void sepetiKullaniciSepetineAktarma() {
		if (aktifKullanici != null) {
			Sepet userSepet = aktifKullanici.getSepet();
			userSepet.sepetList.addAll(sepet.sepetList);
			sepet.sepetList.clear();
		}
	}
}