package week8;

import java.util.*;
import java.util.stream.Collectors;

public class CekilisSistemi {
	
	public static void main(String[] args) {
		// 1. Rastgele Sayılar Üretme
		Map<Integer, Integer> sayiTekrarMap = rastgeleSayilariUret(10000, 1, 100);
		System.out.println("Üretilen Sayılar ve Tekrar Sayıları: " + sayiTekrarMap);
		
		// 2. Liste Oluşturma
		List<Integer> sayiListesi = listeOlustur(sayiTekrarMap);
		System.out.println("Sayı Listesi: " + sayiListesi);
		
		// 3. Şanslı Numaraları Bulma
		List<Integer> sansliNumaralar = sansliNumaralariBul(sayiListesi, 10);
		System.out.println("Şanslı Numaralar: " + sansliNumaralar);
		
		// 4. Şanslı Numaralar Üzerinde İşlemler
		List<Integer> ellidenBuyuk = sansliNumaralar.stream()
		                                            .filter(num -> num > 50)
		                                            .collect(Collectors.toList());
		System.out.println("50'den Büyük Şanslı Numaralar: " + ellidenBuyuk);
		
		int toplam = sansliNumaralar.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Şanslı Numaraların Toplamı: " + toplam);
		
		int ellidenBuyukToplam = ellidenBuyuk.stream().mapToInt(Integer::intValue).sum();
		System.out.println("50'den Büyük Şanslı Numaraların Toplamı: " + ellidenBuyukToplam);
		
		// 5. Optional ile Çalışma (Örnek Kontrol)
		Optional<Integer> optionalSayi = sansliNumaralar.stream().filter(num -> num > 100).findFirst();
		System.out.println("Optional Kontrol: " + (optionalSayi.isPresent() ? optionalSayi.get() : "100'den büyük sayı yok"));
		
		// 6. Stream API ile Çalışma
		long ellidenBuyukSayisi = sansliNumaralar.stream().filter(num -> num > 50).count();
		System.out.println("50'den Büyük Şanslı Numara Sayısı: " + ellidenBuyukSayisi);
	}
	
	// 1a. Rastgele Sayılar Üretme Metodu
	private static Map<Integer, Integer> rastgeleSayilariUret(int miktar, int min, int max) {
		Random rastgele = new Random();
		Map<Integer, Integer> sayiTekrarMap = new HashMap<>();
		
		for (int i = 0; i < miktar; i++) {
			int sayi = rastgele.nextInt((max - min) + 1) + min;
			sayiTekrarMap.put(sayi, sayiTekrarMap.getOrDefault(sayi, 0) + 1);
		}
		
		return sayiTekrarMap;
	}
	
	// 2a. Liste Oluşturma Metodu
	private static List<Integer> listeOlustur(Map<Integer, Integer> sayiTekrarMap) {
		List<Integer> sayiListesi = new ArrayList<>();
		
		for (Map.Entry<Integer, Integer> entry : sayiTekrarMap.entrySet()) {
			int sayi = entry.getKey();
			int tekrar = entry.getValue();
			for (int i = 0; i < tekrar; i++) {
				sayiListesi.add(sayi);
			}
		}
		
		return sayiListesi;
	}
	
	// 3a. Şanslı Numaraları Bulma Metodu
	private static List<Integer> sansliNumaralariBul(List<Integer> sayiListesi, int adet) {
		Collections.shuffle(sayiListesi);
		Set<Integer> uniqueSansliNumaralar = new HashSet<>();
		List<Integer> sansliNumaralar = new ArrayList<>();
		
		for (int sayi : sayiListesi) {
			if (uniqueSansliNumaralar.size() >= adet) break;
			if (uniqueSansliNumaralar.add(sayi)) {
				sansliNumaralar.add(sayi);
			}
		}
		
		return sansliNumaralar;
	}
}