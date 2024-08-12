package Uygulama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentListExample {
	public static void main(String[] args) {
		// Öğrenci listesi oluşturma
		List<Student> students = new ArrayList<>();
		
		// Öğrenci ekleme
		students.add(new Student("Ali", 1));
		students.add(new Student("Ayşe", 2));
		students.add(new Student("Mehmet", 3));
		
		// Listeyi yazdırma
		System.out.println("Öğrenci Listesi: " + students);
		//students.forEach(System.out::println);
		
		// Belirli bir öğrenciye erişme
		Student student = students.get(1); // İkinci öğrenci
		System.out.println("Erişilen Öğrenci: " + student);
		
		// Liste boyutunu öğrenme
		int size = students.size();
		System.out.println("Liste Boyutu: " + size);
		
		// Belirli bir öğrenciyi güncelleme
		students.get(1).setName("Fatma");
//		students.set(2,new Student(students.get(3).getId(),5,);
		System.out.println("Güncellenmiş Öğrenci Listesi: " + students);
		
		// Belirli bir öğrenciyi silme
		students.remove(0); // İlk öğrenci
		System.out.println("Öğrenci Silindikten Sonra Liste: " + students);
		
		// Listeyi döngü ile gezinme
		System.out.println("Öğrenci Listesi Döngü ile:");
		for (Student s : students) {
			System.out.println(s);
		}
		
		// Listenin boş olup olmadığını kontrol etme
		boolean isEmpty = students.isEmpty();
		System.out.println("Liste Boş mu? " + isEmpty);
		
		// Listeyi başka bir listeye kopyalama
		List<Student> copiedList = new ArrayList<>(students);
		System.out.println("Kopyalanmış Liste: " + copiedList);
		
		// Öğrencinin listede bulunup bulunmadığını kontrol etme
		boolean containsStudent = students.contains(new Student("Fatma", 2));
		System.out.println("Fatma Listede mi? " + containsStudent);
		
		// Listeyi alt listeye bölme
		List<Student> subList = students.subList(0, 1); // İlk iki öğrenci
		System.out.println("Alt Liste: " + subList);
		
		// Listeyi diziye dönüştürme
		Student[] studentArray = students.toArray(new Student[0]);
		System.out.println("Diziye Dönüştürülmüş Liste: " + Arrays.toString(studentArray));
		
		// Listeyi ters çevirme
		Collections.reverse(students);
		System.out.println("Ters Çevrilmiş Liste: " + students);
		
		// Listeyi sıralama (Öğrenci ID'sine göre)
		students.sort((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
		System.out.println("Sıralanmış Liste: " + students);
		
		// Öğrenci indeksini bulma
		int index = students.indexOf(new Student("Fatma", 2));
		System.out.println("Fatma'nın İndeksi: " + index);
		
		// Listeyi birleştirme
		List<Student> newStudents = new ArrayList<>();
		newStudents.add(new Student("Ahmet", 4));
		newStudents.add(new Student("Zeynep", 5));
		students.addAll(newStudents);
		System.out.println("Birleştirilmiş Liste: " + students);
		
		List<Student> students1 =
				new ArrayList<>(Arrays.asList(new Student("Ali", 1), new Student("Ayşe", 2), new Student("Mehmet",
				                                                                                         3)));
		
		// Listeyi isimlerine göre sıralama
		students1.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
		students1.forEach(System.out::println);
	}
}