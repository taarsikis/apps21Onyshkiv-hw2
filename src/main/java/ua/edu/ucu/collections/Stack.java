package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Stack {
    private ImmutableList data;

    public Stack() {
        this.data = new ImmutableLinkedList();
    }

    public void push(Object e) {
        data = data.add(e);
    }

    public Object pop() {
        Object result = data.get(data.size() - 1);
        data = data.remove(data.size() - 1);
        return result;
    }

    public Object peek() {
        return data.get(data.size() - 1);
    }
}
