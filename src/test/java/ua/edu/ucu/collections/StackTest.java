package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;
    private Stack emptyStack;

    @Before
    public void setUp() {
        Object[] array = {1, 3, 5, 7};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);
        this.stack = new Stack(linkedList);
        this.emptyStack = new Stack(new ImmutableLinkedList());
    }

    @Test
    public void testPeek() {
        Object expResult = 1;
        Object actualResult = stack.peek();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testPeekEmpty() {
        assertNull(emptyStack.peek());
    }

    @Test
    public void testPop() {
        Object expResult = 1;
        Object actualResult = stack.pop();

        assertEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPopEmpty() {
        assertNull(emptyStack.pop());
    }

    @Test
    public void testPush() {
        Object[] expResult = {9, 1, 3, 5, 7};
        stack.push(9);

        assertArrayEquals(expResult, stack.getStack().toArray());
    }

    @Test
    public void testEnqueueEmpty() {
        Object[] expResult = {9};
        emptyStack.push(9);

        assertArrayEquals(expResult, emptyStack.getStack().toArray());
    }

}
