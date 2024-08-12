package Queue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		//Setler özgün değerler barındırır., aynı değeri iki kere saklamaz.
		Set<Integer> oddNumberSet = new HashSet<>();
		System.out.println("Yakın değerler verildiğinde sıralı bir şekilde saklıyor gibi görünebilir");
		oddNumberSet.add(1);
		oddNumberSet.add(2);
		oddNumberSet.add(3);
		oddNumberSet.add(4);
		oddNumberSet.add(5);
		oddNumberSet.add(6);
		oddNumberSet.add(7);
		oddNumberSet.add(8);
		oddNumberSet.add(9);
		System.out.println(oddNumberSet);
		
		System.out.println("Ancak -30 ve -6 sayısını eklediğimizde, bu sıralama algoritması bozulacaktır. Rastgelelik işin içine dahil olacaktır.");
		oddNumberSet.add(-30);
		oddNumberSet.add(-6);
		System.out.println(oddNumberSet);
		
		
		/*oddNumberSet.add(41238);
		oddNumberSet.add(-12347);
		oddNumberSet.add(46578123);
		oddNumberSet.add(231579);
		oddNumberSet.add(1234165);*/
		
		System.out.println("Genel metotları List ile aynıdır.");
		System.out.println("Bir collection içerisinde bulunuyor mu diye bakabiliriz : ");
		System.out.println(oddNumberSet);
		System.out.println(oddNumberSet.containsAll(List.of(-6,-30)));
		
		System.out.println("İçerisinden çoklu veri silebilirim : ");
		System.out.println(oddNumberSet.removeAll(List.of(-6,-30)));
		System.out.println(oddNumberSet);
		
		Set<Integer> evenNumberSet = new HashSet<>();
		evenNumberSet.add(2);
		evenNumberSet.add(4);
		evenNumberSet.add(6);
		evenNumberSet.add(8);
		
		System.out.println("Even Number Set: "+evenNumberSet);
		System.out.println("Odd Number Set: "+oddNumberSet);
		System.out.println("\nretainAll metodu ile kesişim kümesindeki elemanları getirebiliriz (retainAll set'in " +
				                   "yapısını değiştirir. Kesişim ");
		evenNumberSet.retainAll(oddNumberSet);
		System.out.println("retainAll sonrası evenNumberSet: " + evenNumberSet);
		
	}
}