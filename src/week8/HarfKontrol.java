package week8;

import java.util.HashSet;
import java.util.Set;

/**
 * HarfKontrol sınıfı, bir String değerdeki tekrar eden ve etmeyen harfleri ayırmak için kullanılır.
 */
public class HarfKontrol {
	
	/**
	 * Main metodu, harfleriAyir metodunu çağırarak örnek bir String değeri işler.
	 *
	 * @param args Komut satırı argümanları
	 */
	public static void main(String[] args) {
		// Örnek String değeri işlemek için harfleriAyir metodunu çağırma
		harfleriAyir("araba");
	}
	
	/**
	 * Verilen String değerdeki her bir harfi kontrol eder ve tekrar edenleri bir sete,
	 * tekrar etmeyenleri başka bir sete atar.
	 *
	 * @param deger Kontrol edilecek String değer
	 */
	public static void harfleriAyir(String deger) {
		// Tekrar eden karakterleri tutmak için set
		Set<Character> tekrarEdenler = new HashSet<>();
		// Tekrar etmeyen karakterleri tutmak için set
		Set<Character> tekrarEtmeyenler = new HashSet<>();
		// Karakterlerin daha önce kontrol edilip edilmediğini izlemek için set
		Set<Character> kontrolSeti = new HashSet<>();
		
		/**
		 * deger.chars().forEach(c -> { ... }): String'in karakterlerini IntStream olarak alır ve forEach ile her karakteri işleyerek gerekli işlemleri yapar.
		 * char ch = (char) c: IntStream'den gelen int değerini karaktere dönüştürmek için kullanılır.
		 */
		deger.chars().forEach(c -> {
			char ch = (char) c;
			if (kontrolSeti.contains(ch)) {
				tekrarEdenler.add(ch);
				tekrarEtmeyenler.remove(ch);
			} else {
				kontrolSeti.add(ch);
				tekrarEtmeyenler.add(ch);
			}
		});
		
		// Tekrar eden karakterlerin çıktısını ekrana yazdırma
		System.out.print("Tekrar Eden Harfler: ");
		tekrarEdenler.forEach(ch -> System.out.print(ch + " "));
		System.out.println();
		
		// Tekrar etmeyen karakterlerin çıktısını ekrana yazdırma
		System.out.print("Tekrar Etmeyen Harfler: ");
		tekrarEtmeyenler.forEach(ch -> System.out.print(ch + " "));
		System.out.println();
	}
}