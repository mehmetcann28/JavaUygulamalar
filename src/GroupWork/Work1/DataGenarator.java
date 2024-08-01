package GroupWork.Work1;

import GroupWork.Work1.entities.*;
import GroupWork.Work1.utilities.enums.*;

import java.util.ArrayList;
import java.util.Random;

public class DataGenarator {
	static Random random = new Random();
	static ArrayList<Urun> urunListesi = new ArrayList<>();
	
	public static void gerericProducts() {
		for (int i = 0; i < 40; i++) {
			Urun urun = createRandomUrun();
			urunListesi.add(urun);
			Urun.urunArrayList.add(urun);
		}
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
}