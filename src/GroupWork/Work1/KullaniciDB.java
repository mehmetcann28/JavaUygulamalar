package GroupWork.Work1;

import java.util.ArrayList;

public class KullaniciDB {
	static ArrayList<Kullanici> kullaniciListesi = new ArrayList<>();
	
	public static void kullaniciEkle(Kullanici kullanici) {
		kullaniciListesi.add(kullanici);
	}
	
	public static Kullanici kullaniciBul(String kullaniciAdi) {
		for (Kullanici kullanici : kullaniciListesi) {
			if (kullanici.getKullaniciAdi().equals(kullaniciAdi)) {
				return kullanici;
			}
		}
		return null;
	}
	
	public static ArrayList<Kullanici> getTumKullanicilar() {
		return new ArrayList<>(kullaniciListesi);
	}
}