package ua.edu.ucu.collections.immutable;

import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {

    private final Node startNode = new Node();
    private Node endNode;
    private int size = 0;

    public ImmutableLinkedList(Object[] elements) {
        startNode.setValue(elements[0]);
        this.size++;
        Node lastNode = startNode;
        for (int i = 1; i < elements.length; i++){
            Node currNode = new Node();
            currNode.setValue(elements[i]);
            lastNode.setNext(currNode);
            lastNode = currNode;
            this.size++;
        }
        this.endNode = lastNode;
    }

    public ImmutableLinkedList() {
        this.endNode = this.startNode;
    }

    @Override
    public ImmutableList add(Object e) {

        return addAll(size, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size,c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArray = new Object[this.size + c.length];

        Node currNode = startNode;
        for (int i = 0; i < index; i++){
            newArray[i] = currNode.getValue();
            currNode = currNode.getNext();
        }

        int cIdx = 0;
        for (int i = index; i < index + c.length; i++){
            newArray[i] = c[cIdx];
            cIdx += 1;
        }

        for (int i = index + c.length; i < this.size + c.length; i++){
            newArray[i] = currNode.getValue();
            currNode = currNode.getNext();
        }

        return new ImmutableLinkedList(newArray);
    }

    @Override
    public Object get(int index) {
        Node currNode = startNode;
        for (int i = 0; i < index; i++){
            currNode = currNode.getNext();
        }
        return currNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArray = new Object[this.size - 1];
        Node currNode = startNode;
        int arrIdx = 0;
        for (int i = 0; i < newArray.length; i++){
            if (!Objects.equals(i, index)){
                newArray[arrIdx] = currNode.getValue();
                arrIdx++;

            }
            currNode = currNode.getNext();

        }

        return new ImmutableLinkedList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArray = new Object[this.size];
        Node currNode = startNode;
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        newArray[index] = e;
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        Node currNode = startNode;
        for (int i = 0; i < this.size; i++){
            if (currNode.getValue().equals(e)){
                return  i;
            }
            currNode = currNode.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return Objects.equals(0, this.size);
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[this.size];
        Node currNode = startNode;
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        return newArray;
    }

    public ImmutableList addFirst(Object e) {
        return addAll(0, new Object[]{e});
    }

    public ImmutableList addLast(Object e) {
        return addAll(this.size, new Object[]{e});
    }

    public Node getHead() {
        return startNode;
    }

    public Node getTail() {
        return endNode;
    }

    public Object getFirst() {
        return startNode.getValue();
    }

    public Object getLast() {
        return endNode.getValue();
    }

    public ImmutableList removeFirst() {
        return remove(0);
    }

    public ImmutableList removeLast() {
        return remove(size - 1);
    }
}
