package tadPilha.tadPilhaLSE.source;

/**
 * @author Geovane Donizete Laera  - RA: 1902679 
 * @author Isaque Ribeiro dos Santos Junior - RA: 1903978
 * @author Marcelo Martinez Mesa Campos - RA: 1905076 
 * @author Paulo Ricardo Costa da Silva - RA: 1905013 
 * @author Vinícius da Cruz Pera - RA: 1903144
 * Data: 22/09/2021
 *
 */
public class NodeStack<E> implements Stack<E> {
	// Referência para o nodo cabeça
	protected Node<E> top;
	
	// Quantidade de elementos na pilha
	protected int size;
	
	// Método construtor
	public NodeStack() {
		top = null;
		size = 0;
	}
	
    // Retorna o tamanho da pilha
	public int size() {
		return size; 
	}
	
    // Retorna se a pilha está vazia
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
    // Empilha um elemento na pilha
	public void push(E elem) {
		Node<E> v = new Node<E>(elem, top); // cria e encadeia um nodo novo
		top = v;
		size++;
	}
	
    // Retorna o último elemento da pilha
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty.");
		}
		
		return top.getElement();
	}
	
    // Desempilha um elemento na pilha
	public E pop() throws EmptyStackException {
		Node<E> aux = top;

		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty.");
		}
		
		E temp = top.getElement();
		top = top.getNext(); // desencadeia o nodo topo
		aux.setNext(null);
		size--;
		return temp;
	}
	
    // Inverte os valores de uma pilha
	public NodeStack<E> reverseStack() {
        NodeStack<E> newNodeStack = new NodeStack<E>();
        Node<E> last = this.top;
        
        while (this.size() != newNodeStack.size()) {
            newNodeStack.push(last.getElement());
            
            if (newNodeStack.top.getNext() != null) {
                newNodeStack.top.setNext(newNodeStack.top.getNext());
            }
            
            last = last.getNext();
        }
        return newNodeStack;
    }
	
	// Realiza a validação da expressão matemática
	public String validaExpressaoMatematica(String[] c1) {
		NodeStack<String> exp = new NodeStack<String>();
		
		for (int i = 0; i <= c1.length - 1; i++) {
			if (c1[i].equals("(") || c1[i].equals("[") || c1[i].equals("{")) {
				exp.push(c1[i]); 
			}
			else if (c1[i].equals(")") || c1[i].equals("]") || c1[i].equals("}")) {
				if (exp.isEmpty()) {
					return "Incorreto";
				}
				
				if (exp.top().equals("(") && c1[i].equals(")") || 
						exp.top().equals("[") && c1[i].equals("]") || 
						exp.top().equals("{") && c1[i].equals("}")) { 
		
					exp.pop();
				}
				else {
					return "Incorreto";
				}
			}
		}
		
		if (exp.isEmpty()) {
			return "Correto";
		}
		else {
			return "Incorreto";
		}
	}

	// Método que converte a pilha para String
	public String toString() {
		String s = "[";
		Node<E> p = top;
		
		while (p != null) {
			s += p.getElement();
			s += ", ";
			p = p.getNext();
		}
		
		if (s.length() > 1) {
			s = s.substring(0, s.length() - 2);
		}
		
		return s + "]";
	}
}
