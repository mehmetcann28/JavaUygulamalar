package week8;

import java.util.*;
import java.util.stream.Collectors;

public class OgrenciNotlari {
	
	public static void main(String[] args) {
		// Öğrenci isimleri
		List<String> ogrenci = Arrays.asList("Ayse", "Ece", "Mahmut");
		
		// Öğrenci notları
		int[][] notlar = {
				{ 50, 60, 60 },
				{ 60, 40, 80 },
				{ 80, 90, 100 }
		};
		
		// Öğrencileri ve notlarını Map yapısına dönüştürme
		
		/**
		 * Arrays.stream(notlar[i]).forEach(notListesi::add): Öğrencinin notlarını doğrudan notListesi adlı listeye ekler.
		 */
		
		Map<String, List<Integer>> ogrenciNotMap = new HashMap<>();
		for (int i = 0; i < ogrenci.size(); i++) {
			List<Integer> notListesi = new ArrayList<>();
			Arrays.stream(notlar[i]).forEach(notListesi::add);
			ogrenciNotMap.put(ogrenci.get(i), notListesi);
		}
		
		// Öğrenci isimleri ile notlarını ekrana yazdırma
		ogrenci.forEach(o -> {
			System.out.print(o + ": ");
			Optional.ofNullable(ogrenciNotMap.get(o))
			        .ifPresent(n -> System.out.println(n.stream()
			                                            .map(String::valueOf)
			                                            .collect(Collectors.joining(", "))));
		});
	}
}