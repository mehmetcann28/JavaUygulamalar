package uygulamalar.utilities;

import uygulamalar.entities.*;
import uygulamalar.utilities.enums.*;

public class DataGenerator {
	public static void generateProduct(){
		GiyimUrunleri urun1 = new GiyimUrunleri("T-shirt", 50d, "Aciklama", EKategori.GIYIM, 15, EBeden.M, ERenk.KIRMIZI);
		GiyimUrunleri urun2 = new GiyimUrunleri("Pantolon", 150d, "Aciklama2", EKategori.GIYIM, 10, EBeden.L, ERenk.SIYAH);
		GiyimUrunleri urun3 = new GiyimUrunleri("Gomlek", 250d, "Aciklama3", EKategori.GIYIM, 100, EBeden.XL, ERenk.YESIL);
		
		AksesuarUrunleri
				aksesuar1 = new AksesuarUrunleri("Kolye", 100d, "Altın bir kolye. Basit ve zarif bir tasarımı var.", EKategori.AKSESUAR, 5, ETur.KOLYE, EMateryal.ALTIN, EDesen.DUZ);
		AksesuarUrunleri aksesuar2 = new AksesuarUrunleri("Saat", 200d, "Gümüşten yapılmış bir saat. Çizgili desenli bir kordonu var.", EKategori.AKSESUAR, 3, ETur.SAAT, EMateryal.GUMUS, EDesen.CIZGILI);
		AksesuarUrunleri aksesuar3 = new AksesuarUrunleri("Bilezik", 150d, "Altın yapılmış düz bir bilezik. Hem şık hem de dayanıklı.", EKategori.AKSESUAR, 7, ETur.BILEZIK, EMateryal.ALTIN, EDesen.DUZ);
		AksesuarUrunleri aksesuar4 = new AksesuarUrunleri("Yüzük", 250d, "Gümüş bir yüzük. Zarif bir çizgili desenle süslenmiş.", EKategori.AKSESUAR, 4, ETur.YUZUK, EMateryal.GUMUS, EDesen.CIZGILI);
		AksesuarUrunleri aksesuar5 = new AksesuarUrunleri("Küpe", 120d, "Altından yapılmış basit bir küpe. Günlük kullanım için ideal.", EKategori.AKSESUAR, 6, ETur.KUPE, EMateryal.ALTIN, EDesen.DUZ);
		
		ElektronikUrunleri
				eUrun1 = new ElektronikUrunleri("Monitor", 3000d, "Aciklama", EKategori.ELEKTRONIK, 15, 5, 24d, ECihazTipi.PC);
		ElektronikUrunleri eUrun2 = new ElektronikUrunleri("Telefon",10000d,"Aciklama",EKategori.ELEKTRONIK, 20,24,4d, ECihazTipi.TELEFON);
		ElektronikUrunleri eUrun3 = new ElektronikUrunleri("Kulaklik",500d,"Aciklama",EKategori.ELEKTRONIK, 25,36,5d, ECihazTipi.KULAKLIK);
		ElektronikUrunleri eUrun4 = new ElektronikUrunleri("Mouse",700d,"Aciklama",EKategori.ELEKTRONIK, 15,50,24d, ECihazTipi.PC);
		ElektronikUrunleri eUrun5 = new ElektronikUrunleri("Sarj cihazi",200d,"Aciklama",EKategori.ELEKTRONIK, 50,0, 12d, ECihazTipi.ADAPTOR);
		
		BakimUrunleri
				bakimUrun1 = new BakimUrunleri("Yüz Kremi", 350d, "Sivilce Karşıtı Yağsız Yüz Nemlendiricisi", EKategori.BAKIM, 20, EBakimUrunleriTipler.KUTU);
		BakimUrunleri bakimUrun2 = new BakimUrunleri("Vücut Losyonu", 175.50d, "Sıkılaştırıcı Vücut Losyonu", EKategori.BAKIM, 10, EBakimUrunleriTipler.SISE);
		BakimUrunleri bakimUrun3 = new BakimUrunleri("Saç Bakım Kremi ", 215.90d, "Yıpranmış Saçlar İçin (Reparation) Onarıcı Prebiyotik Saç Kremi", EKategori.BAKIM, 13, EBakimUrunleriTipler.TUP);
		BakimUrunleri bakimUrun4 = new BakimUrunleri("Gül Suyu", 65d, "% 100 Yağlı Gül Suyu Doğal Katkısız Aydınlatıcı Ve Gözenek Sıkılaştırıcı ", EKategori.BAKIM, 14, EBakimUrunleriTipler.SISE);
		BakimUrunleri bakimUrun5 = new BakimUrunleri("Yüz Tonik", 220d, "Akne Eğilimli Cilt-gözenek Sıkılaştırıcı " +
				"Sebo Pure Vegetal Tonik", EKategori.BAKIM, 30, EBakimUrunleriTipler.SISE);
		
		Yiyecek yiyecek1=new Yiyecek("Cheeseburger", 150d, "Peynir ve kofte", EKategori.YIYECEK, 16, EYiyecekTipi.FASTFOOD);
		Yiyecek yiyecek2=new Yiyecek("Kuru Fasulye",100d,"Kuru Fasulye",EKategori.YIYECEK,11,EYiyecekTipi.EVYEMEGI);
		Yiyecek yiyecek3=new Yiyecek("Nugget",80d,"Nugget",EKategori.YIYECEK,22,EYiyecekTipi.ATISTIRMALIK);
		Yiyecek yiyecek4=new Yiyecek("Pizza",300d,"Margarita Pizza",EKategori.YIYECEK,34,EYiyecekTipi.FASTFOOD);
		Yiyecek yiyecek5=new Yiyecek("Pilav",60d,"Pirinc Pilavi",EKategori.YIYECEK,9,EYiyecekTipi.EVYEMEGI);
	}
}