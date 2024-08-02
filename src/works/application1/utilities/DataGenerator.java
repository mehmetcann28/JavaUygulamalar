package works.application1.utilities;

import works.application1.entities.*;
import works.application1.utilities.enums.*;

public class DataGenerator {
	public static void generateProducts(){
		GiyimUrunleri giyim1=new GiyimUrunleri("T-shirt", 150d, "T-shirt", EKategori.GIYIM, 15, EBeden.M, ERenk.KIRMIZI);
		GiyimUrunleri giyim2=new GiyimUrunleri("Pantolon", 250d, "Skinny Jean", EKategori.GIYIM, 19, EBeden.XL, ERenk.MAVI);
		GiyimUrunleri giyim3=new GiyimUrunleri("Gomlek", 350d, "Gomlek", EKategori.GIYIM, 16, EBeden.M, ERenk.SIYAH);
		Yiyecek yiyecek1=new Yiyecek("Cheeseburger", 150d, "Peynir ve kofte", EKategori.YIYECEK, 16, EYiyecekTipi.FASTFOOD);
		Yiyecek yiyecek2=new Yiyecek("Kuru Fasulye", 100d, "Kuru Fasulye", EKategori.YIYECEK, 11, EYiyecekTipi.EVYEMEGI);
		Yiyecek yiyecek3=new Yiyecek("Nugget", 80d, "Nugget", EKategori.YIYECEK, 22, EYiyecekTipi.ATISTIRMALIK);
		Yiyecek yiyecek4=new Yiyecek("Pizza", 300d, "Margarita Pizza", EKategori.YIYECEK, 34, EYiyecekTipi.FASTFOOD);
		Yiyecek yiyecek5=new Yiyecek("Pilav", 60d, "Pirinc Pilavi", EKategori.YIYECEK, 9, EYiyecekTipi.EVYEMEGI);
		ElektronikUrunleri
				eUrun1 = new ElektronikUrunleri("Monitor", 3000d, "Aciklama", EKategori.ELEKTRONIK, 15, 5, 24d, ECihazTipi.PC);
		ElektronikUrunleri
				eUrun2 = new ElektronikUrunleri("Telefon", 10000d, "Aciklama", EKategori.ELEKTRONIK, 3, 24, 4d,
				                                ECihazTipi.TELEFON);
		ElektronikUrunleri
				eUrun3 = new ElektronikUrunleri("Kulaklik", 500d, "Aciklama", EKategori.ELEKTRONIK, 25, 36, 5d, ECihazTipi.KULAKLIK);
		ElektronikUrunleri
				eUrun4 = new ElektronikUrunleri("Mouse", 700d, "Aciklama", EKategori.ELEKTRONIK, 15, 50, 24d, ECihazTipi.PC);
		ElektronikUrunleri
				eUrun5 = new ElektronikUrunleri("Sarj cihazi", 200d, "Aciklama", EKategori.ELEKTRONIK, 50, 0, 12d, ECihazTipi.ADAPTOR);
		BakimUrunleri
				bakimUrun1 = new BakimUrunleri("Yuz Kremi", 350d, "Sivilce Karsiti Yagsiz Yuz Nemlendiricisi", EKategori.BAKIM, 20, EBakimUrunleriTipler.KUTU);
		BakimUrunleri
				bakimUrun2 = new BakimUrunleri("Vucut Losyonu", 175.50d, "Sikilastirici Vucut Losyonu", EKategori.BAKIM, 10, EBakimUrunleriTipler.SISE);
		BakimUrunleri
				bakimUrun3 = new BakimUrunleri("Sac Bakim Kremi ", 215.90d, "Yipranmis Saclar Icin (Reparation) Onarici Prebiyotik Sac Kremi", EKategori.BAKIM, 13, EBakimUrunleriTipler.TUP);
		BakimUrunleri
				bakimUrun4 = new BakimUrunleri("Gul Suyu", 65d, "% 100 Yagli Gul Suyu Dogal Katkisiz Aydinlatici Ve Gozenek Sikilastirici ", EKategori.BAKIM, 14, EBakimUrunleriTipler.SISE);
		BakimUrunleri
				bakimUrun5 = new BakimUrunleri("Yuz Tonik", 220d, "Akne Egilimli Cilt-gozenek Sikilastirici Sebo Pure Vegetal Tonik", EKategori.BAKIM, 30, EBakimUrunleriTipler.SISE);
		AksesuarUrunleri
				aksesuar1 = new AksesuarUrunleri("Kolye", 100d, "Altin bir kolye. Basit ve zarif bir tasarimi var.", EKategori.AKSESUAR, 5, ETur.KOLYE, EMateryal.ALTIN, EDesen.DUZ);
		AksesuarUrunleri
				aksesuar2 = new AksesuarUrunleri("Saat", 200d, "Gumusten yapilmis bir saat. Cizgili desenli bir kordonu var.", EKategori.AKSESUAR, 3, ETur.SAAT, EMateryal.GUMUS, EDesen.CIZGILI);
		AksesuarUrunleri
				aksesuar3 = new AksesuarUrunleri("Bilezik", 150d, "Altin yapilmis duz bir bilezik. Hem sik hem de dayanikli.", EKategori.AKSESUAR, 7, ETur.BILEZIK, EMateryal.ALTIN, EDesen.DUZ);
		AksesuarUrunleri
				aksesuar4 = new AksesuarUrunleri("Yuzuk", 250d, "Gumus bir yuzuk. Zarif bir cizgili desenle suslenmiş.", EKategori.AKSESUAR, 4, ETur.YUZUK, EMateryal.GUMUS, EDesen.CIZGILI);
		AksesuarUrunleri
				aksesuar5 = new AksesuarUrunleri("Kupe", 120d, "Altindan yapilmis basit bir kupe. Gunluk kullanim icin ideal.", EKategori.AKSESUAR, 6, ETur.KUPE, EMateryal.ALTIN, EDesen.DUZ);
		
	}
}