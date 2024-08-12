package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<String> nameQueue = new LinkedList<>();
		nameQueue.add("Alperen");
		nameQueue.add("Alex");
		nameQueue.add("Emine");
		nameQueue.add("Harun");
		nameQueue.add("Mehmet");
		nameQueue.add("Selin");
		nameQueue.add("Mehmet Can");
		
		System.out.println("peek():\tEn baştaki elemana erişme");
		System.out.println(nameQueue.peek());
		
		System.out.println("pool():\tEn baştaki elemana erişme ve sıradan çıkarma");
		System.out.println("Çıkarılan eleman: "+nameQueue.poll());
		System.out.println("Yeni sıra");
		nameQueue.forEach(System.out::println);
		System.out.println("Çıkarılan eleman: "+nameQueue.poll());
		System.out.println("Yeni sıra");
		nameQueue.forEach(System.out::println);
		System.out.println("Çıkarılan eleman: "+nameQueue.poll());
		System.out.println("Yeni sıra");
		nameQueue.forEach(System.out::println);
		System.out.println("Çıkarılan eleman: "+nameQueue.poll());
		System.out.println("Yeni sıra");
		nameQueue.forEach(System.out::println);
		System.out.println("Çıkarılan eleman: "+nameQueue.poll());
		System.out.println("Yeni sıra");
		nameQueue.forEach(System.out::println);
		System.out.println("Çıkarılan eleman: "+nameQueue.poll());
		System.out.println("Yeni sıra");
		nameQueue.forEach(System.out::println);
		System.out.println("Çıkarılan eleman: "+nameQueue.poll());
		System.out.println("Yeni sıra");
		nameQueue.forEach(System.out::println);
	}
}