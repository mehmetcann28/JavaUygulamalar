package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
	public static void main(String[] args) {
		//Deque FIFO ve LIFO mantıklarının ikisine de uygulanabilir.
		
		Deque<String> nameDeque = new LinkedList<>();
		System.out.println(nameDeque);
		nameDeque.add("Alperen");
		System.out.println(nameDeque);
		nameDeque.addFirst("Alex");
		System.out.println(nameDeque);
		nameDeque.addFirst("Emine");
		System.out.println(nameDeque);
		nameDeque.addLast("Harun");
		System.out.println(nameDeque);
		nameDeque.add("Mehmet");
		System.out.println(nameDeque);
		/*nameDeque.add("Selin");
		nameDeque.add("Mehmet Can");*/
		
		System.out.println("\nremoveFirst ile ilk indexten eleman silinir");
		nameDeque.removeFirst();
		System.out.println(nameDeque);
		System.out.println("\nremoveFirst ile son indexten eleman silinir");
		nameDeque.removeLast();
		System.out.println(nameDeque);
	}
}