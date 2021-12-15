package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Test;

public class NodeTest extends TestCase {

    @Test
    public void testGetPrevious() {
        Node node1 = new Node();
        Node node2 = new Node();
        node1.setValue(1);
        node2.setValue(2);
        node2.setPrevious(node1);
        assertEquals(2, node2.getPrevious().getNext().getValue());

    }

    public void testSetPrevious() {
    }
}