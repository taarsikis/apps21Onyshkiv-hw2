package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = elements.clone();

    }

    public ImmutableArrayList() {
        this.elements = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(this.elements.length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {

        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {

        return addAll(0, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {

        Object[] newArray = new Object[this.elements.length + c.length];

        if (index >= 0){
            System.arraycopy(this.elements, 0, newArray, 0, index);
        }

        System.arraycopy(c, 0, newArray, index, c.length);

        if (this.elements.length - index >= 0)
            System.arraycopy(this.elements, index, newArray, index + c.length, this.elements.length - index);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArray = new Object[elements.length - 1];
        int elementsIdx = 0;
        for (int i = 0; i < newArray.length; i++){
            if (Objects.equals(i,index)){elementsIdx++;}
            newArray[i] = elements[elementsIdx];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArray = elements.clone();
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elements.length; i++ ){
            if (Objects.equals(elements[i], e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }
}
