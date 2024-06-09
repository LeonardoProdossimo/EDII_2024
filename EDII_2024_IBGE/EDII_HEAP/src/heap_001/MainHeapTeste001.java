package heap_001;

import java.util.PriorityQueue;

public class MainHeapTeste001 {

	public static void main(String[] args) {
		PriorityQueue<Integer> fila = new PriorityQueue<Integer>();
		fila.add(10);
		fila.add(5);
		fila.add(7);
		fila.add(8);
		
		System.out.println(fila);
		
		for(int i = 0; i < 4; i++) {
			fila.remove();
			System.out.println(fila);
		}
	}

}
