package GroupWork.Work1;

import java.util.Scanner;

public class KullaniciIslemleri {
	static Scanner scanner = new Scanner(System.in);
	
	public static void kullaniciKayit() {
		System.out.print("Kullanici Adi: ");
		String kullaniciAdi = scanner.nextLine();
		System.out.print("Sifre: ");
		String sifre = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		
		Kullanici yeniKullanici = new Kullanici(kullaniciAdi, sifre, email);
		KullaniciDB.kullaniciEkle(yeniKullanici);
		System.out.println("Kullanici basariyla kaydedildi.");
		Runner.aktifKullanici = yeniKullanici;
	}
	
	public static void kullaniciGiris() {
		System.out.print("Kullanici Adi: ");
		String kullaniciAdi = scanner.nextLine();
		System.out.print("Sifre: ");
		String sifre = scanner.nextLine();
		
		Kullanici kullanici = KullaniciDB.kullaniciBul(kullaniciAdi);
		if (kullanici != null && kullanici.getSifre().equals(sifre)) {
			System.out.println("Giris basarili. Hosgeldiniz, " + kullanici.getKullaniciAdi());
			Runner.aktifKullanici = kullanici;
		} else {
			System.out.println("Kullanici adi veya sifre hatali. Lutfen tekrar deneyin veya kayit olun.");
			//kullaniciKayit();
		}
	}
}