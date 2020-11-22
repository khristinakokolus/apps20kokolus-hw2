package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    private ImmutableList immutableLinkedList;
    private ImmutableList immutableLinkedListEmpty;

    @Before
    public void setUp(){
        Object[] arrayList = {1, 3, 5, 7};

        this.immutableLinkedList = new ImmutableLinkedList(arrayList);
        this.immutableLinkedListEmpty = new ImmutableLinkedList();

    }
    
    @Test
    public void testLinkedListCreation() {
        Object[] expResFirst = {};
        Object[] expResSecond = {1, 3, 5, 7};

        Object[] resFirst = immutableLinkedListEmpty.toArray();
        Object[] resSecond = immutableLinkedList.toArray();
        assertArrayEquals(expResFirst, resFirst);
        assertArrayEquals(expResSecond, resSecond);
    }

    @Test
    public void testAdd() {
        ImmutableList newImmutableList =  immutableLinkedList.add(9);

        Object[] expResult = {1, 3, 5, 7, 9};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddWithIndex() {
        ImmutableList newImmutableList =  immutableLinkedList.add(2,
                9);

        Object[] expResult = {1, 3, 9, 5, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddWithBadIndex() {
        immutableLinkedList.add(10, 9);
    }

    @Test
    public void testAddAll() {
        ImmutableList newImmutableList =  immutableLinkedList.addAll(new Object[]{1, 3});

        Object[] expResult = {1, 3, 5, 7, 1, 3};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddAllWithIndex() {
        ImmutableList newImmutableList =  immutableLinkedList.addAll(2,
                new Object[]{1, 3});

        Object[] expResult = {1, 3, 1, 3, 5, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllWithBadIndex() {
        immutableLinkedList.addAll(10, new Object[]{1, 3});
    }

    @Test
    public void testGet() {
        Object expResult = 3;
        Object actualResult = immutableLinkedList.get(1);
        assertEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetBadIndex() {
        immutableLinkedList.get(10);
    }

    @Test
    public void testRemove() {
        ImmutableList newImmutableList =  immutableLinkedList.remove(2);

        Object[] expResult = {1, 3, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveBadIndex() {
        immutableLinkedList.remove(10);
    }

    @Test
    public void testSet() {
        ImmutableList newImmutableList =  immutableLinkedList.set(2, 3);

        Object[] expResult = {1, 3, 3, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetBadIndex() {
        immutableLinkedList.set(10, 3);
    }

    @Test
    public void testIndexOf() {
        int expResult = 0;
        int actualResult = immutableLinkedList.indexOf(1);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOfNotFound() {
        int expResult = -1;
        int actualResult = immutableLinkedList.indexOf(12);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSize() {
        int expResult = 4;
        int actualResult = immutableLinkedList.size();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testClear() {
        ImmutableList newImmutableList = immutableLinkedList.clear();

        Object[] expResult = {};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIsEmpty() {
        boolean expResult = false;
        boolean actualResult = immutableLinkedList.isEmpty();
        assertEquals(expResult, actualResult);

        boolean expResultSecond = true;
        boolean actualResultSecond = immutableLinkedListEmpty.isEmpty();
        assertEquals(expResultSecond, actualResultSecond);
    }

    @Test
    public void testToArray() {
        Object[] expResult = {1, 3, 5, 7};
        Object[] actualResult = immutableLinkedList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testToString() {
        String expResult = "[1, 3, 5, 7]";
        String actualResult = immutableLinkedList.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddFirst() {
        Object[] array = {1, 2, 3, 4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);
        ImmutableLinkedList newImmutableList = linkedList.addFirst(9);

        Object[] expResult = {9, 1, 2, 3, 4};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddLast() {
        Object[] array = {1, 2, 3, 4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);
        ImmutableLinkedList newImmutableList = linkedList.addLast(9);

        Object[] expResult = {1, 2, 3, 4, 9};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testGetFirst() {
        Object[] array = {1, 2, 3, 4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);

        Object expResult = 1;
        Object actualResult = linkedList.getFirst();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGetFirstEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();

        assertNull(linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        Object[] array = {1, 2, 3, 4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);

        Object expResult = 4;
        Object actualResult = linkedList.getLast();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGetLastEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();

        assertNull(linkedList.getLast());
    }

    @Test
    public void testRemoveFirst() {
        Object[] array = {1, 2, 3, 4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);
        ImmutableLinkedList newImmutableList = linkedList.removeFirst();

        Object[] expResult = {2, 3, 4};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveFirstEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        linkedList.removeFirst();
    }

    @Test
    public void testRemoveLast() {
        Object[] array = {1, 2, 3, 4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);
        ImmutableLinkedList newImmutableList = linkedList.removeLast();

        Object[] expResult = {1, 2, 3};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveLastEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        linkedList.removeLast();
    }
}
