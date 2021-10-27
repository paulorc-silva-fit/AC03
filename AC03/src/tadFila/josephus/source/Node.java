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
public class Node<T> {
	// Variáveis de instância
	private T element;
	private Node<T> next;

	// Cria um nodo com referências nulas para os seus elementos e o próximo nodo
	public Node() {
		this(null, null);
	}

	// Cria um nodo com um dado elemento e o próximo nodo
	public Node(T e, Node<T> n) {
		element = e;
		next = n;
	}

	// Métodos getters
	public T getElement() {
		return element;
	}

	public Node<T> getNext() {
		return next;
	}

	// Métodos setters
	public void setElement(T newElem) {
		element = newElem;
	}

	public void setNext(Node<T> newNext) {
		next = newNext;
	}
}
