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
public interface Queue<E> {
	// Retorna o número de elementos na fila.
	public int size();

	// Retorna se a fila está vazia.
	public boolean isEmpty();

	// Retorna o elemento à frente da fila.
	// @exception EmptyQueueException se a fila estiver vazia.
	public E front() throws EmptyQueueException;

	// Insere um elemento no final da fila
	public void enqueue(E element);

	// Remove um elemento no final da fila
	// @exception EmptyQueueException se a fila estiver vazia.
	public E dequeue() throws EmptyQueueException;
}
