package tadFila.josephus.source;

/**
 * @author Geovane Donizete Laera  - RA: 1902679 
 * @author Isaque Ribeiro dos Santos Junior - RA: 1903978
 * @author Marcelo Martinez Mesa Campos - RA: 1905076 
 * @author Paulo Ricardo Costa da Silva - RA: 1905013 
 * @author Vinícius da Cruz Pera - RA: 1903144
 * Data: 22/09/2021
 *
 */
public class Josephus {
	// Método construtor
	// @throws EmptyQueueException
	public static <E> E Josephus(Queue<E> Q, int k) throws EmptyQueueException {
		if (Q.isEmpty()) {
			return null;
		}
		
		while (Q.size() > 1) {
			System.out.println(" Queue: " + Q + " k = " + k);
			
			for (int i = 0; i < k; i++) {
				Q.enqueue(Q.dequeue());
			}
			
			E e = Q.dequeue();
			System.out.println(" " + e + " is out");
		}
		
		return Q.dequeue();
	}
	
	// Cria uma fila a partir de um arranjo de objetos
	public static <E> Queue<E> buildQueue(E a[]) {
		Queue<E> Q = new NodeQueue<E>();
		for (int i = 0; i < a.length; i++) {
			Q.enqueue(a[i]);
		}
		return Q;
	}
	
	// Método de teste 
	// @throws EmptyQueueException
	public static void main(String[] args) throws EmptyQueueException {
		String[] a1 = { "Alice", "Bob", "Cindy", "Doug", "Ed", "Fred" };
		String[] a2 = { "Gene", "Hope", "Irene", "Jack", "Kim", "Lance" };
		String[] a3 = { "Mike", "Roberto" };
		System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
		System.out.println("Second winner is " + Josephus(buildQueue(a2), 10));
		System.out.println("Third winner is " + Josephus(buildQueue(a3), 7));
	}
}