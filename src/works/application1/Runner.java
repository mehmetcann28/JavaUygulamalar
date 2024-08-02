package works.application1;

import works.application1.entities.Urun;
import works.application1.kullaniciIslemleri.KullaniciKayitSistemi;
import works.application1.kullaniciIslemleri.entities.Kullanici;
import works.application1.utilities.DataGenerator;

import java.util.Scanner;

public class Runner {
	static Scanner scanner = new Scanner(System.in);
	public static Sepet geciciSepet = new Sepet();
	public static Kullanici aktifKullanici = null;
	
	public static void main(String[] args) {
		DataGenerator.generateProducts();
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
			System.out.println("5- Sepeti Onayla");
			if (aktifKullanici == null) {
				System.out.println("6- Kayıt ol veya Giriş yap");
			} else {
				System.out.println("7- Çıkış Yap");
				System.out.println("8- Önceki Siparişlerim");
			}
			
			System.out.println("0- Cikis");
			System.out.print("Lutfen bir secim yapiniz: ");
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
			case 1:
				Urun.urunArrayList.forEach(System.out::println);
				break;
			case 2:
				Urun.urunArrayList.forEach(System.out::println);
				System.out.print("Secmek istediginiz urunun ID'sini giriniz: ");
				int id = scanner.nextInt();
				eklenecekUrunKontrolu(UrunDB.findById(id));
				break;
			case 3:
				if (aktifKullanici != null) {
					aktifKullanici.getSepet().sepettekiUrunleriListele();
				} else {
					geciciSepet.sepettekiUrunleriListele();
				}
				break;
			case 4:
				if (aktifKullanici != null) {
					aktifKullanici.getSepet().sepettekiUrunleriListele();
					System.out.print("Cikartmak istediginiz urunun ID'sini giriniz: ");
					id = scanner.nextInt();
					silinecekUrunKontrolu(UrunDB.findById(id));
				} else {
					geciciSepet.sepettekiUrunleriListele();
					System.out.print("Cikartmak istediginiz urunun ID'sini giriniz: ");
					id = scanner.nextInt();
					silinecekUrunKontrolu(UrunDB.findById(id));
				}
				break;
			case 5:
				if (aktifKullanici == null) {
					System.out.println("Sepeti onaylamadan önce kayıt olmanız veya giriş yapmanız gerekmektedir");
					KullaniciKayitSistemi.menu();
				} else {
					aktifKullanici.getSepet().sepetiOnayla();
					aktifKullanici.getSepetList().add(aktifKullanici.getSepet());
					aktifKullanici.setSepet(new Sepet());
				}
				break;
			case 6:
				if (aktifKullanici == null) {
					KullaniciKayitSistemi.menu();
					if (aktifKullanici != null) {
						aktifKullanici.getSepet().getSepetList().addAll(geciciSepet.getSepetList());
					}
				}
				break;
			case 7:
				aktifKullanici = null;
				System.out.println("Çıkış yapıldı.");
				break;
			case 8:
				if (aktifKullanici != null) {
					for (Sepet sepet : aktifKullanici.getSepetList()) {
						sepet.sepettekiUrunleriListele();
					}
				} else {
					System.out.println("Önce giriş yapmanız gerekmektedir.");
				}
				break;
			case 0:
				System.out.println("Uygulama sonlandiriliyor...");
				break;
			default:
				System.out.println("Lutfen gecerli bir secim yapiniz!");
				break;
		}
		return secim;
	}
	
	private static Urun silinecekUrunKontrolu(Urun urun) {
		System.out.print("Kac adet silmek istersiniz? ");
		int silinecekAdet = scanner.nextInt();
		
		int sepetAdeti = 0;
		for (Urun u : (aktifKullanici != null ? aktifKullanici.getSepet().getSepetList() : geciciSepet.getSepetList())) {
			if (u.getUrunId().equals(urun.getUrunId())) {
				sepetAdeti++;
			}
		}
		
		if (silinecekAdet <= sepetAdeti) {
			for (int i = 0; i < silinecekAdet; i++) {
				if (aktifKullanici != null) {
					aktifKullanici.getSepet().sepettenUrunCikart(urun);
				} else {
					geciciSepet.sepettenUrunCikart(urun);
				}
			}
			urun.setAdet(urun.getAdet() + silinecekAdet);
			System.out.println(urun.getAd() + " adli urunden " + silinecekAdet + " adet sepetten cikarildi.");
			return urun;
		} else {
			for (int i = 0; i < sepetAdeti; i++) {
				if (aktifKullanici != null) {
					aktifKullanici.getSepet().sepettenUrunCikart(urun);
				} else {
					geciciSepet.sepettenUrunCikart(urun);
				}
			}
			urun.setAdet(urun.getAdet() + sepetAdeti);
			System.out.println("Silmek istediginiz adetten daha az urun bulunuyor. Sepetteki urunlerin tamami cikarildi.");
		}
		return null;
	}
	
	private static Urun eklenecekUrunKontrolu(Urun urun) {
		while (true) {
			System.out.println(urun.urunDetayBilgisi());
			System.out.print("Kac adet eklemek istersiniz? ");
			Integer adet1 = urun.getAdet();
			
			int adet = scanner.nextInt();
			if (adet > 0) {
				if (adet <= urun.getKategori().getSinir()) {
					if (adet <= urun.getAdet()) {
						for (int j = 0; j < adet; j++) {
							if (aktifKullanici != null) {
								aktifKullanici.getSepet().sepeteUrunEkle(urun);
							} else {
								geciciSepet.sepeteUrunEkle(urun);
							}
						}
						System.out.println(urun.getAd() + " adli urunden " + adet + " adet eklendi.");
						return urun;
					} else {
						System.out.println("Yeterli stok bulunamadi!");
					}
				} else {
					System.out.println("Bu urunden en fazla " + urun.getKategori().getSinir() + " adet alinabilir");
				}
			} else {
				System.out.println("Bir urunden en az 1 adet alinabilir!");
			}
		}
	}
}