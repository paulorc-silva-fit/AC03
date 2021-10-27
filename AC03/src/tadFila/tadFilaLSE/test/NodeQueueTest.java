package tadFila.tadFilaLSE.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tadFila.tadFilaLSE.source.NodeQueue;
import tadFila.tadFilaLSE.source.EmptyQueueException;

class NodeQueueTest {
	static final NodeQueue<Integer> qInt = new NodeQueue<Integer>();
	static final NodeQueue<String> qStr = new NodeQueue<String>();
	
	@Test
    void filaInteiros() {
    	qInt.enqueue(7);
        assertEquals("[7]", qInt.toString(), "Deve imprimir [7]");
        qInt.enqueue(9);
        assertEquals("[7, 9]", qInt.toString(), "Deve imprimir [7, 9]");
        qInt.enqueue(1);
        assertEquals("[7, 9, 1]", qInt.toString(), "Deve imprimir [7, 9, 1]");

        assertEquals(7, qInt.dequeue(), "Deve tirar da fila o 7");
        assertEquals("[9, 1]", qInt.toString(), "Deve imprimir [9, 1]");
        assertEquals(9, qInt.dequeue(), "Deve tirar da fila o 9");
        assertEquals("[1]", qInt.toString(), "Deve imprimir [1]");
        assertEquals(1, qInt.dequeue(), "Deve tirar da fila o 1");
        assertEquals("[]", qInt.toString(), "Deve imprimir []");

        assertTrue(qInt.isEmpty());

        Assertions.assertThrows(EmptyQueueException.class, () -> { qInt.dequeue(); });
    }
    
    @Test
    void filaStrings() {
    	qStr.enqueue("AAA");
        assertEquals("[AAA]", qStr.toString(), "Deve imprimir [AAA]");
        qStr.enqueue("BBB");
        assertEquals("[AAA, BBB]", qStr.toString(), "Deve imprimir [AAA, BBB]");
        qStr.enqueue("CCC");
        assertEquals("[AAA, BBB, CCC]", qStr.toString(), "Deve imprimir [AAA, BBB, CCC]");

        assertEquals("AAA", qStr.dequeue(), "Deve tirar da fila o AAAA");
        assertEquals("[BBB, CCC]", qStr.toString(), "Deve imprimir [BBB, CCC]");
        assertEquals("BBB", qStr.dequeue(), "Deve tirar da fila o BBB");
        assertEquals("[CCC]", qStr.toString(), "Deve imprimir [CCC]");
        assertEquals("CCC", qStr.dequeue(), "Deve tirar da fila o CCC");
        assertEquals("[]", qStr.toString(), "Deve imprimir []");

        assertTrue(qStr.isEmpty());

        Assertions.assertThrows(EmptyQueueException.class, () -> { qStr.dequeue(); });
    }
}
