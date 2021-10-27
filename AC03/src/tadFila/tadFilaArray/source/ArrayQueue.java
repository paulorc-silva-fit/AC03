package tadFila.tadFilaArray.source;

/**
 * @author Geovane Donizete Laera  - RA: 1902679 
 * @author Isaque Ribeiro dos Santos Junior - RA: 1903978
 * @author Marcelo Martinez Mesa Campos - RA: 1905076 
 * @author Paulo Ricardo Costa da Silva - RA: 1905013 
 * @author Vinícius da Cruz Pera - RA: 1903144
 * Data: 22/09/2021
 *
 */
public class ArrayQueue<E> implements Queue<E> {
	private int size;
	protected int first;
	protected int next;
	private E queueElements[];

    // Método construtor
    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
    	this.first = 0;
    	this.next = 0;
    	this.size = size;
    	queueElements = (E[]) new Object[size];
    }

    // Retorna o tamanho da fila
    public int size() {
        return (size - first + next) % size;
    }

    // Retorna se a fila está vazia
    public boolean isEmpty() {
        return first == next;
    }

    // Retorna o primeiro elemento da fila
    public E front() throws EmptyQueueException {
    	if (isEmpty()) {
    		throw new EmptyQueueException("Queue is empty.");
    	}
    	
    	return queueElements[first];
    }

	// Insere um elemento no final da fila
    public void enqueue(E element) throws FullQueueException {
        if (size() == this.size - 1) {
            throw new FullQueueException("Queue is full.");
        }
        
        queueElements[next] = element;
        next = (next + 1) % size;
    }
    
	// Remove um elemento no final da fila
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
        	throw new EmptyQueueException("Queue is empty.");
        }
        
        E temp = queueElements[first];
        queueElements[first] = null;
        
        first = (first + 1) % size;
        return temp;
    }

	// Método que converte a fila para String
    public String toString() {
        String s = "[";
		
        if (size() > 0) {
        	 s += queueElements[first];
        }
        
        if (s.length() > 1) {
			for (int i = 1; i < size(); i++) {
				s += ", " + queueElements[(first + i) % size];
			}
		}
        
        return s + "]";
    }
}
