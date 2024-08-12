package week8;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

/**
 * FilmUygulamasi sınıfı, film kategorilerini tutmak ve yönetmek için kullanılır.
 */
public class FilmUygulamasi {
	
	public static void main(String[] args) {
		FilmUygulamasi uygulama = new FilmUygulamasi();
		System.out.println(uygulama.kategoriEkle("Aksiyon"));
		System.out.println(uygulama.kategoriEkle("Korku"));
		System.out.println(uygulama.kategoriEkle("Aksiyon"));
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("\nLütfen bir kategori girin (çıkmak için '0' girin, kategorileri listelemek için '1' " +
					                 "girin): ");
			String input = scanner.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				uygulama.kategorileriListele();
			} else {
				String sonuc = uygulama.kategoriEkle(input);
				System.out.println(sonuc);
			}
		}
		
		scanner.close();
		System.out.println("Programdan çıkıldı.");
	}
	
	private Set<String> kategoriler = new HashSet<>();
	
	/**
	 * Yeni bir kategori ekler.
	 *
	 * @param kategori Eklenecek kategori
	 * @return Kategori başarıyla eklendiyse bir onay mesajı, zaten mevcutsa bir uyarı mesajı döner.
	 */
	public String kategoriEkle(String kategori) {
		kategori = kategori.toLowerCase();
		if (kategoriler.contains(kategori)) {
			return "Bu kategori zaten mevcut.";
		} else {
			kategoriler.add(kategori);
			return "Kategori başarıyla eklendi.";
		}
	}
	
	/**
	 * Mevcut kategorileri listeler.
	 * Optional.ofNullable: kategoriler seti boşsa null döner, değilse kategoriler setini döner.
	 * ifPresentOrElse: Set doluysa (ks) kategorileri ekrana yazdırır, boşsa "Hiç kategori eklenmemiş." mesajını yazdırır.
	 */
	public void kategorileriListele() {
		Optional.ofNullable(kategoriler.isEmpty() ? null : kategoriler).ifPresentOrElse(
				kategoriset -> {
					System.out.println("Mevcut Kategoriler:");
					kategoriset.forEach(kategori -> System.out.println("- " + kategori));
				},
				() -> System.out.println("Hiç kategori eklenmemiş.")
		);
	}
	
	
}