package uygulamalar;

import java.util.Scanner;

public class Runner {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		GiyimUrunleri urun1=new GiyimUrunleri("T-shirt",50d,"Aciklama",EKategori.GIYIM,3,EBeden.M,ERenk.KIRMIZI);
		GiyimUrunleri urun2=new GiyimUrunleri("Pantolon",150d,"Aciklama2",EKategori.GIYIM,5,EBeden.L,ERenk.SIYAH);
		GiyimUrunleri urun3=new GiyimUrunleri("Gomlek",250d,"Aciklama3",EKategori.GIYIM,6,EBeden.XL,ERenk.YESIL);
		Sepet sepet=new Sepet();
		
		
		sepet.sepeteUrunEkle(urun1);
		sepet.sepeteUrunEkle(urun2);
		System.out.println("####### SEPETTEKI URUNLER #######");
		sepet.sepettekiUrunleriListele();
	}
	public static void menu(){
		int secim = -1;
		do {
			System.out.println("### SEPET UYGULUMASI ###");
			System.out.println("1- Urunleri listele");
			System.out.println("2- Sepete urun ekle");
			System.out.println("3- Sepeti goruntule");
			System.out.println("4- Sepetten urun cikar");
			System.out.print("Lutfen bir secim yapiniz : ");
			try {
				secim = scanner.nextInt();
			} catch (Exception e){
				System.out.println("Gecerli bir secim yapiniz.");
			} finally {
				scanner.nextLine();
			}
			sepetFunctions(secim);
		} while (secim != 0);
	}
	
	private static int sepetFunctions(int secim) {
		switch (secim){
			case 1:{
				Urun.urunArrayList.forEach(System.out::println);
				break;
			}
			case 2:{
				break;
			}
			case 3:{
				break;
			}
			case 4:{
				break;
			}
			default:{
				System.out.println("Lutfen gecerli bir secim yapiniz!");
			}
		}
		return secim;
	}
	public Urun eklenecekUrunKontrolu(Urun urun){
		Urun.urunArrayList.forEach(System.out::println);
		System.out.print("Secmek istediginiz urunun ID'sini giriniz : ");
		int id= scanner.nextInt();
		if (id<=0){
			System.out.println("Lutfen gecerli bir ID degeri giriniz!");
		}
		for (int i = 0; i < Urun.urunArrayList.size(); i++) {
			if (id==Urun.urunArrayList.get(i).getUrunId()){
				//Urünün bilgilerini yazdır.
				// Adet mikatarı al
				// Adet kontrolü yap.
				// Adet sağlanıyorsa ürünü ekle.
			}
		}
		
	}
}