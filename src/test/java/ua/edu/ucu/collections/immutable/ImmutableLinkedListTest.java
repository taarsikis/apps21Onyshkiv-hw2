package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Test;

public class ImmutableLinkedListTest extends TestCase {

    @Test
    public void testAdd() {
        ImmutableLinkedList data = new ImmutableLinkedList(new Object[]{1,2,3,4});
        assertEquals(2, data.add(0,2).toArray()[0]);
        assertEquals(2, data.addAll(new Object[]{2}).toArray()[4]);

    }

    @Test
    public void testSet() {
        ImmutableLinkedList data = new ImmutableLinkedList(new Object[]{1,2,3,4});
        assertEquals(2, data.set(0,2).toArray()[0]);
        assertEquals(1, data.indexOf(2));
    }

    @Test
    public void testClear() {
        ImmutableLinkedList data = new ImmutableLinkedList(new Object[]{1,2,3,4});
        assertEquals(0, data.clear().size());
        assertEquals(true, data.clear().isEmpty());
    }

    public void testFunctions() {
        ImmutableLinkedList data = new ImmutableLinkedList(new Object[]{1,2,3,4});
        assertEquals(data.addAll(0, new Object[]{2}).get(0), data.addFirst(2).get(0));
        assertEquals(data.addAll(data.size(), new Object[]{2}).get(0), data.addLast( 2).get(0));
        assertEquals(data.getHead().getValue(), 1);
        assertEquals(data.getTail().getValue(), 4);
        assertEquals(data.getFirst() , 1);
        assertEquals(data.getLast() , 4);
        assertEquals(data.remove(0).get(0), data.removeFirst().get(0));
        assertEquals(data.remove(data.size() - 1).get(0), data.removeLast().get(0));


    }
}