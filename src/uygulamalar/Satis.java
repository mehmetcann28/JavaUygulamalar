package uygulamalar;

import uygulamalar.kullaniciIslemleri.entities.Kullanici;
import uygulamalar.entities.Urun;
import uygulamalar.utilities.enums.EKategori;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Satis {
	public LocalDate satisTarihi = LocalDate.now();
	public Integer satisID;
	public List<Sepet> gecmisSiparisList=new ArrayList<>();
	
	
	
	@Override
	public String toString() {
		return "Satis{" + "satisTarihi=" + satisTarihi + ", satisID=" + satisID + ", gecmisSiparisList=" + gecmisSiparisList + '}';
	}
}
/*
		Satis satis=new Satis();
		Urun urun=new Urun("aaa", 150d, "asd", EKategori.GIYIM,15);
		Sepet sepet =new Sepet();
		Kullanici kullanici=new Kullanici();
		kullanici.setKullaniciAdi("Harunsakin");
		kullanici.setSifre("12345678");
		sepet.setKullaniciId(kullanici.getId());
		satis.gecmisSiparisList.add(sepet);
		sepet.sepeteUrunEkle(urun);
		//satis.gecmisSiparisList.get(0).sepettekiUrunleriListele();
		sepet=new Sepet();
		sepet.setKullaniciId(kullanici.getId());
		sepet.sepeteUrunEkle(urun);
		sepet.sepeteUrunEkle(urun);
		satis.gecmisSiparisList.add(sepet);
		satis.gecmisSiparisList.get(1).sepettekiUrunleriListele();
		System.out.println(satis);
		System.out.println(satis.gecmisSiparisList.get(0).getKullaniciId());
 */