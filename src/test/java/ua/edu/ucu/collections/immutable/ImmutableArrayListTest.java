package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableList immutableArrayList;
    private ImmutableList immutableArrayListEmpty;

    @Before
    public void setUp() {
        Object[] arrayList = {1, 3, 5, 7};

        this.immutableArrayList = new ImmutableArrayList(arrayList);
        this.immutableArrayListEmpty = new ImmutableArrayList();

    }

    @Test
    public void testAdd() {
        ImmutableList newImmutableList =  immutableArrayList.add(9);

        Object[] expResult = {1, 3, 5, 7, 9};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);

    }

    @Test
    public void testAddWithIndex() {
        ImmutableList newImmutableList =  immutableArrayList.add(2,
                9);

        Object[] expResult = {1, 3, 9, 5, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddWithBadIndex() {
        immutableArrayList.add(10, 9);
    }


    @Test
    public void testAddAll() {
        ImmutableList newImmutableList =  immutableArrayList.addAll(
                new Object[]{1, 3});

        Object[] expResult = {1, 3, 5, 7, 1, 3};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddAllWithIndex() {
        ImmutableList newImmutableList =  immutableArrayList.addAll(2,
                new Object[]{1, 3});

        Object[] expResult = {1, 3, 1, 3, 5, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllWithBadIndex() {
        immutableArrayList.addAll(10, new Object[]{1, 3});
    }

    @Test
    public void testGet() {
        Object expResult = 3;
        Object actualResult = immutableArrayList.get(1);
        assertEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetBadIndex() {
        immutableArrayList.get(10);
    }


    @Test
    public void testRemove() {
        ImmutableList newImmutableList =  immutableArrayList.remove(2);

        Object[] expResult = {1, 3, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveBadIndex() {
        immutableArrayList.remove(10);
    }

    @Test
    public void testSet() {
        ImmutableList newImmutableList =  immutableArrayList.set(2, 3);

        Object[] expResult = {1, 3, 3, 7};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetBadIndex() {
        immutableArrayList.set(10, 3);
    }

    @Test
    public void testIndexOf() {
        int expResult = 0;
        int actualResult = immutableArrayList.indexOf(1);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOfNotFound() {
        int expResult = -1;
        int actualResult = immutableArrayList.indexOf(12);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSize() {
        int expResult = 4;
        int actualResult = immutableArrayList.size();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testClear() {
        ImmutableList newImmutableList = immutableArrayList.clear();

        Object[] expResult = {};
        Object[] actualResult = newImmutableList.toArray();
        assertArrayEquals(expResult, actualResult);
    }


    @Test
    public void testIsEmpty() {
        boolean expResult = false;
        boolean actualResult = immutableArrayList.isEmpty();
        assertEquals(expResult, actualResult);

        boolean expResultSecond = true;
        boolean actualResultSecond = immutableArrayListEmpty.isEmpty();
        assertEquals(expResultSecond, actualResultSecond);
    }

    @Test
    public void testToArray() {
        Object[] expResult = {1, 3, 5, 7};
        Object[] actualResult = immutableArrayList.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testToString() {
        String expResult = "[1, 3, 5, 7]";
        String actualResult = immutableArrayList.toString();
        assertEquals(expResult, actualResult);
    }

}
