package tadPilha.tadPilhaLSE.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tadPilha.tadPilhaLSE.source.EmptyStackException;
import tadPilha.tadPilhaLSE.source.NodeStack;

class NodeStackTest {
	static final NodeStack<Integer> aInt = new NodeStack<Integer>();
	static final NodeStack<String> aStr = new NodeStack<String>();
	static NodeStack<Integer> reverseArrayInt = new NodeStack<Integer>();
	static NodeStack<String> reverseArrayStr = new NodeStack<String>();

    @Test
    void pilhaInteiros() {
    	aInt.push(7);
        assertEquals("[7]", aInt.toString(), "Deve imprimir [7]");
        aInt.push(9);
        assertEquals("[9, 7]", aInt.toString(), "Deve imprimir [9, 7]");
        aInt.push(1);
        assertEquals("[1, 9, 7]", aInt.toString(), "Deve imprimir [1, 9, 7]");

        assertEquals(1, aInt.pop(), "Deve ter desempilhado 1");
        assertEquals("[9, 7]", aInt.toString(), "Deve imprimir [9, 7]");
        assertEquals(9, aInt.pop(), "Deve ter desempilhado 9");
        assertEquals("[7]", aInt.toString(), "Deve imprimir [7]");
        assertEquals(7, aInt.pop(), "Deve ter desempilhado 7");
        assertEquals("[]", aInt.toString(), "Deve imprimir []");

        assertTrue(aInt.isEmpty());

        Assertions.assertThrows(EmptyStackException.class, () -> { aInt.pop(); });
    }
    
    @Test
    void pilhaStrings() {
    	aStr.push("AAA");
        assertEquals("[AAA]", aStr.toString(), "Deve imprimir [AAA]");
        aStr.push("BBB");
        assertEquals("[BBB, AAA]", aStr.toString(), "Deve imprimir [BBB, AAA]");
        aStr.push("CCC");
        assertEquals("[CCC, BBB, AAA]", aStr.toString(), "Deve imprimir [CCC, BBB, AAA]");

        assertEquals("CCC", aStr.pop(), "Deve ter desempilhado CCC");
        assertEquals("[BBB, AAA]", aStr.toString(), "Deve imprimir [BBB, AAA]");
        assertEquals("BBB", aStr.pop(), "Deve ter desempilhado BBB");
        assertEquals("[AAA]", aStr.toString(), "Deve imprimir [AAA]");
        assertEquals("AAA", aStr.pop(), "Deve ter desempilhado AAA");
        assertEquals("[]", aStr.toString(), "Deve imprimir []");

        assertTrue(aStr.isEmpty());

        Assertions.assertThrows(EmptyStackException.class, () -> { aStr.pop(); });
    }
	
	@Test
	void invertePilhaInteiros() {    	
    	reverseArrayInt.push(7);
        assertEquals("[7]", reverseArrayInt.toString(), "Deve imprimir [7]");
        reverseArrayInt.push(9);
        assertEquals("[9, 7]", reverseArrayInt.toString(), "Deve imprimir [9, 7]");
        reverseArrayInt.push(1);
        assertEquals("[1, 9, 7]", reverseArrayInt.toString(), "Deve imprimir [1, 9, 7]");
        reverseArrayInt.push(2);
        assertEquals("[2, 1, 9, 7]", reverseArrayInt.toString(), "Deve imprimir [2, 1, 9, 7]");
        reverseArrayInt.push(5);
        assertEquals("[5, 2, 1, 9, 7]", reverseArrayInt.toString(), "Deve imprimir [5, 2, 1, 9, 7]");
    	
        reverseArrayInt = reverseArrayInt.reverseStack();
        assertEquals("[7, 9, 1, 2, 5]", reverseArrayInt.toString(), "Deve imprimir [7, 9, 1, 2, 5]");
	}
	
	@Test
    void invertePilhaStrings() {
		reverseArrayStr.push("AAA");
        assertEquals("[AAA]", reverseArrayStr.toString(), "Deve imprimir [AAA]");
        reverseArrayStr.push("BBB");
        assertEquals("[BBB, AAA]", reverseArrayStr.toString(), "Deve imprimir [BBB, AAA]");
        reverseArrayStr.push("CCC");
        assertEquals("[CCC, BBB, AAA]", reverseArrayStr.toString(), "Deve imprimir [CCC, BBB, AAA]");
        reverseArrayStr.push("DDD");
        assertEquals("[DDD, CCC, BBB, AAA]", reverseArrayStr.toString(), "Deve imprimir [DDD, CCC, BBB, AAA]");
        reverseArrayStr.push("EEE");
        assertEquals("[EEE, DDD, CCC, BBB, AAA]", reverseArrayStr.toString(), "Deve imprimir [EEE, DDD, CCC, BBB, AAA]");

        reverseArrayStr = reverseArrayStr.reverseStack();
        assertEquals("[AAA, BBB, CCC, DDD, EEE]", reverseArrayStr.toString(), "Deve imprimir [AAA, BBB, CCC, DDD, EEE]");
    }
	
	@Test
	void validaExpressaoMatematicaTest() {
		NodeStack<String> matExp = new NodeStack<String>();

		assertEquals("Correto", matExp.validaExpressaoMatematica("[(5 + x)/4 – 2*(y + z)]".split("")));
		assertEquals("Correto", matExp.validaExpressaoMatematica("((()(()){([()])}))".split("")));
		assertEquals("Correto", matExp.validaExpressaoMatematica("()(()){([()])}".split("")));

		assertEquals("Incorreto", matExp.validaExpressaoMatematica(")(()){([()])}".split("")));
		assertEquals("Incorreto", matExp.validaExpressaoMatematica("({[])}".split("")));
		assertEquals("Incorreto", matExp.validaExpressaoMatematica("(".split("")));
	}
}
