package tadListaNodos.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import tadListaNodos.source.InvalidPositionException;
import tadListaNodos.source.NodePositionList;
import tadListaNodos.source.Position;


class NodePositionListTest {
	@Test
	void listaNodosInteiros() {
		NodePositionList<Integer> l = new NodePositionList<Integer>();
		assertEquals("[]", l.toString(), "[]");

		l.addFirst(8);
		assertEquals("[8]", l.toString(), "[8]");

		Position<Integer> p1 = l.first();
		assertEquals(8, p1.element(), "8");
		assertEquals("[8]", l.toString(), "[8]");

		l.addAfter(p1, 5);
		assertEquals("[8, 5]", l.toString(), "[8, 5]");

		Position<Integer> p2 = l.next(p1);
		assertEquals(5, p2.element(), "5");
		assertEquals("[8, 5]", l.toString(), "[8, 5]");

		l.addBefore(p2, 3);
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");

		Position<Integer> p3 = l.prev(p2);
		assertEquals(3, p3.element(), "3");
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
		
		l.addFirst(9);
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");

		p2 = l.last();
		assertEquals(5, p2.element(), "5");
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");

		assertEquals(9, l.remove(l.first()), "9");
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");

		assertEquals(3, l.set(p3, 7), "3");
		assertEquals("[8, 7, 5]", l.toString(), "[8, 7, 5]");

		l.addAfter(l.first(), 2);
		assertEquals("[8, 2, 7, 5]", l.toString(), "[8, 2, 7, 5]");
	}
	
	@Test
	void reverseListTest() {
		NodePositionList<Integer> lista = new NodePositionList<Integer>();
		
		lista.addFirst(5);
		assertEquals("[5]", lista.toString(), "[5]");
		
		lista.addFirst(10);
		assertEquals("[10, 5]", lista.toString(), "[10, 5]");
		
		lista.addFirst(7);
		assertEquals("[7, 10, 5]", lista.toString(), "[7, 10, 5]");
		
		lista.addFirst(4);
		assertEquals("[4, 7, 10, 5]", lista.toString(), "[4, 7, 10, 5]");
		
		lista.reverseList(lista);
		assertEquals("[5, 10, 7, 4]", lista.toString(), "[5, 10, 7, 4]");		
	}
	
	@Test
	void makeFirstTest() {
		NodePositionList<Integer> lista = new NodePositionList<Integer>();
		
		lista.addFirst(5);
		assertEquals("[5]", lista.toString(), "[5]");
		
		lista.addFirst(10);
		assertEquals("[10, 5]", lista.toString(), "[10, 5]");
		
		lista.addFirst(7);
		assertEquals("[7, 10, 5]", lista.toString(), "[7, 10, 5]");
		
		lista.addFirst(4);
		assertEquals("[4, 7, 10, 5]", lista.toString(), "[4, 7, 10, 5]");
		
		Position<Integer> node = lista.last();
		lista.makeFirst(node);
		assertEquals("[5, 4, 7, 10]", lista.toString(), "[5, 4, 7, 10]");
		
		Position<Integer> node1 = lista.prev(lista.last());
		lista.makeFirst(node1);
		assertEquals("[7, 5, 4, 10]", lista.toString(), "[7, 5, 4, 10]");		
		
		Position<Integer> node2 = lista.next(node1);
		lista.makeFirst(node2); 
		assertEquals("[5, 7, 4, 10]", lista.toString(), "[5, 7, 4, 10]");		
	}
	
	@Test
	void excecaoPositionListTest() {
		NodePositionList<Integer> lista0 = new NodePositionList<Integer>();
		
		lista0.addFirst(5);
		lista0.addFirst(8);
		lista0.addFirst(0);
		lista0.addFirst(1);		
		
		NodePositionList<Integer> lista1 = new NodePositionList<Integer>();
		
		lista1.addFirst(9);
		lista1.addFirst(1);
		lista1.addFirst(7);
		lista1.addFirst(3);
		
		Position<Integer> nodeLista = lista0.first();
		assertThrows(InvalidPositionException.class, () -> {lista1.addAfter(nodeLista, 5);});
		
		Position<Integer> nodeLista1 = lista1.last();		
		assertThrows(InvalidPositionException.class, () -> {lista0.addAfter(nodeLista1, 8);});
		
		
		Position<Integer> nodeLista2 = lista0.next(lista0.first());
		assertThrows(InvalidPositionException.class, () -> {lista1.addAfter(nodeLista2, 9);});
		
		Position<Integer> nodeLista3 = lista1.prev(lista1.last());		
		assertThrows(InvalidPositionException.class, () -> {lista0.addAfter(nodeLista3, 7);});		
	}
}
