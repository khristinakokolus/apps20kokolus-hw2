package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;
    private Queue emptyQueue;

    @Before
    public void setUp() {
        Object[] array = {1, 3, 5, 7};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);
        this.queue = new Queue(linkedList);
        this.emptyQueue = new Queue(new ImmutableLinkedList());
    }
    
    @Test
    public void testPeek() {
        Object expResult = 1;
        Object actualResult = queue.peek();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testPeekEmpty() {
        assertNull(emptyQueue.peek());
    }

    @Test
    public void testDequeue() {
        Object expResult = 1;
        Object actualResult = queue.dequeue();

        assertEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testDequeueEmpty() {
        assertNull(emptyQueue.dequeue());
    }

    @Test
    public void testEnqueue() {
        Object[] expResult = {1, 3, 5, 7, 9};
        queue.enqueue(9);

        assertArrayEquals(expResult, queue.getQueue().toArray());
    }

    @Test
    public void testEnqueueEmpty() {
        Object[] expResult = {9};
        emptyQueue.enqueue(9);

        assertArrayEquals(expResult, emptyQueue.getQueue().toArray());
    }

}
