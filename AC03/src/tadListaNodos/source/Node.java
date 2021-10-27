package tadListaNodos.source;

/**
 * @author Geovane Donizete Laera  - RA: 1902679 
 * @author Isaque Ribeiro dos Santos Junior - RA: 1903978
 * @author Marcelo Martinez Mesa Campos - RA: 1905076 
 * @author Paulo Ricardo Costa da Silva - RA: 1905013 
 * @author Vinícius da Cruz Pera - RA: 1903144
 * Data: 29/09/2021
 *
 */
public class Node <E>{
	// Variáveis de instância
	private E element;
	private Node<E> next;

	// Cria um nodo com referências nulas para os seus elementos e o próximo nodo
	public Node() { 
		this(null, null); 
	}

	// Cria um nodo com um dado elemento e o próximo nodo
	public Node(E e, Node<E> n) {
		element = e;
		next = n;
	}

	// Métodos getters
	public E getElement() { 
		return element; 
	}
	
	public Node<E> getNext() { 
		return next; 
	}
	
	// Métodos setters
	public void setElement(E newElem) { 
		element = newElem; 
	}
	
	public void setNext(Node<E> newNext) { 
		next = newNext;
	}
}
