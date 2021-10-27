package tadFila.tadFilaLSE.source;

/**
 * @author Geovane Donizete Laera  - RA: 1902679 
 * @author Isaque Ribeiro dos Santos Junior - RA: 1903978
 * @author Marcelo Martinez Mesa Campos - RA: 1905076 
 * @author Paulo Ricardo Costa da Silva - RA: 1905013 
 * @author Vinícius da Cruz Pera - RA: 1903144
 * Data: 22/09/2021
 *
 */
public class NodeQueue<E> implements Queue<E> {
	// Referência para os nodos cabeça e cauda
	private Node<E> head, tail;
	
	// Quantidade de elementos na fila
	private int size;

	// Método construtor
	public NodeQueue() {
		this.size = 0;
	}

    // Retorna o tamanho da fila
	public int size() {
		return this.size;
	}

    // Retorna se a fila está vazia
	public boolean isEmpty() {
		return size == 0;
	}

    // Retorna o primeiro elemento da fila
	public E front() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		return head.getElement();
	}

    // Insere um elemento na fila
	public void enqueue(E elem) {
		Node<E> node = new Node<E>();
		node.setElement(elem);
		node.setNext(null);
		if (size == 0)
			head = node; // caso especial de uma lista previamente vazia
		else
			tail.setNext(node); // adiciona nodo no final da lista
		tail = node; // atualiza referência ao nodo do final
		size++;
	}

    // Remove um elemento na fila
	public E dequeue() throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException("Queue is empty.");
		E tmp = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null; // a fila está vazia agora
		return tmp;
	}

	// Método que converte a fila para String
	public String toString() {
		String s;
		Node<E> p = head;
		s = "[";
		while (p != null) {
			s += p.getElement();
			s += ", ";
			p = p.getNext();
		}
		if (s.length() > 1)
			s = s.substring(0, s.length() - 2);
		return s + "]";
	}
}