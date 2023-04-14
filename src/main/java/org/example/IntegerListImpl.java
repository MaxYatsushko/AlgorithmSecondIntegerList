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
        if ((index != size) && (index != size - 1))
            System.arraycopy(integerList, index + 1, integerList, index, size - index);
        else if (index == size - 1)
               System.arraycopy(integerList, 0, integerList, size - 2 , size - 1);
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return contains(integerList, item, this.size);
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
    public String toString() {
        return "IntegerListImpl{" +
                "integerList=" + Arrays.toString(integerList) +
                ", size=" + size +
                '}';
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

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (integerList[j] > integerList[j + 1]) {
                    swapElements(integerList, j, j + 1);
                }
            }
        }
    }

    public  void sortSelection() {
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (integerList[j] < integerList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integerList, i, minElementIndex);
        }
    }

    public void sortInsertion() {
        sortSelection(integerList, this.size);
    }

    private boolean contains(Integer[] arr, int element, int size) {
        sortSelection(arr, size);
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void sortSelection(Integer[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
}
