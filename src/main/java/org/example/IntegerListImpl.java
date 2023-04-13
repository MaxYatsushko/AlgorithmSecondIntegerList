package org.example;

import org.example.exceptions.ElementNotFoundException;
import org.example.exceptions.FullListException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.InvalidIndexException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{

    private final Integer[] integerList;
    private int size;

    public IntegerListImpl() {
        integerList = new Integer[10];
    }

    public IntegerListImpl(int size) {
        integerList = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);

        integerList[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if(index == size) {
            integerList[size++] = item;
            return item;
        }

        System.arraycopy(integerList, index, integerList, index + 1, size - index);
        integerList[index] = item;
        size++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integerList[index] = item;

        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = integerList[index];
        if (index != size)
            System.arraycopy(integerList, index + 1, integerList, index, size - index);

        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) > - 1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if(integerList[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if(integerList[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integerList, size);
    }

    private void validateItem(Integer item){
        if(item == null)
            throw new NullItemException("Item is Null ");
    }

    private void validateSize(){
        if(size == integerList.length)
            throw new FullListException("List is full");
    }

    private void validateIndex(int index){
        if(index < 0 || index > size)
            throw new InvalidIndexException("Index is incorrect");
    }

}
