package week8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HarfFrekansiBulma sınıfı, bir kelimedeki harflerin frekansını bulmak için kullanılır.
 */
public class HarfFrekansiBulma {
	
	/**
	 * Main metodu, kullanıcıdan kelime alır ve harf frekansını bulur.
	 *
	 * @param args Komut satırı argümanları
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Lütfen bir kelime girin: ");
		String kelime = scanner.nextLine();
		
		harfFrekansiBul(kelime);
		
		scanner.close();
	}
	
	/**
	 * Verilen kelimedeki harflerin frekansını hesaplar ve ekrana yazdırır.
	 * kelime.toLowerCase().chars().forEach(c -> { ... }): Küçük harfe çevrilmiş kelimenin karakterlerini forEach ile işleyerek her bir karakterin frekansını hesaplar.
	 * char ch = (char) c: IntStream'den gelen her int değeri (c), char tipine dönüştürülür.
	 * harfFrekansi.computeIfAbsent(ch, k -> 0): Eğer ch karakteri harfFrekansi haritasında yoksa, değeri 0 olarak ekler.
	 * harfFrekansi.put(ch, harfFrekansi.get(ch) + 1): Mevcut değeri 1 artırır.
	 *
	 * @param kelime Frekansı hesaplanacak kelime
	 */
	public static void harfFrekansiBul(String kelime) {
		Map<Character, Integer> harfFrekansi = new HashMap<>();
		
		// Kelimeyi küçük harfe çevir ve her bir harfin frekansını hesapla
		kelime.toLowerCase().chars().forEach(c -> {
			char ch = (char) c;
			harfFrekansi.computeIfAbsent(ch, k -> 0);
			harfFrekansi.put(ch, harfFrekansi.get(ch) + 1);
		});
		
		// Harf frekanslarını ekrana yazdır
		harfFrekansi.forEach((ch, frekans) -> System.out.print(ch + " = " + frekans + "; "));
		System.out.println();
	}
}