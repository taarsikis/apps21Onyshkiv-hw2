package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node() {
        this.previous = null;
        this.next = null;
        this.value = null;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node prev) {
        this.previous = prev;
        prev.next = this;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object val) {
        this.value = val;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node ne) {
        this.next = ne;
        ne.previous = this;
    }
}

