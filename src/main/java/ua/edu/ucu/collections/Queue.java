package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Queue {
    private ImmutableList data;

    public Queue() {
        this.data = new ImmutableLinkedList();
    }


    public Object peek() {

        return data.get(0);
    }

    public Object dequeue() {
        Object result = data.get(0);
        data = data.remove(0);
        return result;
    }

    public void enqueue(Object e) {
        data = data.add(e);
    }
}
