package tadPilha.tadPilhaArray.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tadPilha.tadPilhaArray.pilha.ArrayStack;
import tadPilha.tadPilhaArray.pilha.EmptyStackException;
import tadPilha.tadPilhaArray.pilha.FullStackException;

class ArrayStackTest {
    static final ArrayStack<Integer> aInt = new ArrayStack<Integer>(3);
    static final ArrayStack<String> aStr = new ArrayStack<String>(3);

    @Test
    void pilhaInteiros() {
    	aInt.push(7);
        assertEquals("[7]", aInt.toString(), "Deve imprimir [7]");
        aInt.push(9);
        assertEquals("[7, 9]", aInt.toString(), "Deve imprimir [7, 9]");
        aInt.push(1);
        assertEquals("[7, 9, 1]", aInt.toString(), "Deve imprimir [7, 9, 1]");

        Assertions.assertThrows(FullStackException.class, () -> { aInt.push(2); });

        assertEquals(1, aInt.pop(), "Deve ter desempilhado 1");
        assertEquals("[7, 9]", aInt.toString(), "Deve imprimir [7, 9]");
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
        assertEquals("[AAA, BBB]", aStr.toString(), "Deve imprimir [AAA, BBB]");
        aStr.push("CCC");
        assertEquals("[AAA, BBB, CCC]", aStr.toString(), "Deve imprimir [AAA, BBB, CCC]");

        Assertions.assertThrows(FullStackException.class, () -> { aStr.push("DDD"); });

        assertEquals("CCC", aStr.pop(), "Deve ter desempilhado CCC");
        assertEquals("[AAA, BBB]", aStr.toString(), "Deve imprimir [AAA, BBB]");
        assertEquals("BBB", aStr.pop(), "Deve ter desempilhado BBB");
        assertEquals("[AAA]", aStr.toString(), "Deve imprimir [AAA]");
        assertEquals("AAA", aStr.pop(), "Deve ter desempilhado AAA");
        assertEquals("[]", aStr.toString(), "Deve imprimir []");

        assertTrue(aStr.isEmpty());

        Assertions.assertThrows(EmptyStackException.class, () -> { aStr.pop(); });
    }
}