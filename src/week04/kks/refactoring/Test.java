package week04.kks.refactoring;

import week04.kks.refactoring.databases.KullaniciDB;
import week04.kks.refactoring.entities.Kullanici;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		KullaniciDB kullaniciDB=new KullaniciDB();
		
		Kullanici kullanici=new Kullanici();
		kullanici.setIsim("Mehmet");
		kullanici.setSoyisim("KARAHAN");
		Kullanici kullanici1=new Kullanici();
		kullanici1.setIsim("Semra");
		kullanici1.setSoyisim("KARAHAN");
		kullaniciDB.saveAll(List.of(kullanici,kullanici1));
		System.out.println(kullaniciDB.findAll());
		
		Kullanici kullanici2=kullanici1;
		kullanici2.setIsim("Can");
		kullaniciDB.update(kullanici1,kullanici2);
		System.out.println(kullaniciDB.findAll());
		
	}
}