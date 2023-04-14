package org.example;

import org.example.exceptions.FullListException;
import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private IntegerListImpl integerList;
    @BeforeEach
    void initArray(){
        integerList = new IntegerListImpl();
    }

    @Test
    public void addIndex_success() {
        //входные данные
        int size = 1;
        Integer[] integers = new Integer[size];
        integerList = new IntegerListImpl(size);

        //ожидаемый результат
        Integer expectedInteger = 9;
        integers[0] = expectedInteger;

        //начало теста
        Integer actualString = integerList.add(0, expectedInteger);
        Integer[] actualStrings = integerList.toArray();

        assertEquals(expectedInteger, actualString);
        assertEquals(integers[0] , integerList.toArray()[0]);
        assertArrayEquals(integers, actualStrings);
    }

    @Test
    public void addIndex_InvalidIndexException() {
        //входные данные
        int index = 3, size = 2;
        Integer itemInteger = 9;
        integerList = new IntegerListImpl(size);

        //ожидаемый результат
        String expectedError = "Index is incorrect";

        //начало теста
        Exception exception = assertThrows(InvalidIndexException.class, () -> integerList.add(index, itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void addIndex_NullItemException() {
        //входные данные
        Integer itemInteger = null;
        int index = 0;
        integerList = new IntegerListImpl();

        //ожидаемый результат
        String expectedError = "Item is Null ";

        //начало теста
        Exception exception = assertThrows(NullItemException.class, () -> integerList.add(index, itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void addIndex_FullListException() {
        //входные данные
        Integer itemInteger = 9;
        int index = 1;
        integerList = new IntegerListImpl(1);
        integerList.add(itemInteger);

        //ожидаемый результат
        String expectedError = "List is full";

        //начало теста
        Exception exception = assertThrows(FullListException.class, () -> integerList.add(index, itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    void addItem_success(){
        //входные данные
        int size = 1;
        Integer[] integers = new Integer[size];
        integerList = new IntegerListImpl(size);

        //ожидаемый результат
        Integer expectedInteger = 9;
        integers[0] = expectedInteger;

        //начало теста
        Integer actualString = integerList.add(expectedInteger);
        Integer[] actualStrings = integerList.toArray();

        assertEquals(expectedInteger, actualString);
        assertEquals(integers[0] , integerList.toArray()[0]);
        assertArrayEquals(integers, actualStrings);
    }
    @Test
    void addItem_FullListException(){
        //входные данные
        Integer itemInteger = 9;
        int index = 1;
        integerList = new IntegerListImpl(1);
        integerList.add(itemInteger);

        //ожидаемый результат
        String expectedError = "List is full";

        //начало теста
        Exception exception = assertThrows(FullListException.class, () -> integerList.add(itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    void addItem_NullItemException(){
        //входные данные
        Integer itemInteger = null;
        int index = 0;
        integerList = new IntegerListImpl();

        //ожидаемый результат
        String expectedError = "Item is Null ";

        //начало теста
        Exception exception = assertThrows(NullItemException.class, () -> integerList.add(itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }


    @Test
    void set_success() {
        //входные данные
        int size = 1;
        Integer[] integers = new Integer[size];
        integerList = new IntegerListImpl(size);
        integerList.add(9);

        //ожидаемый результат
        Integer expectedInteger = 9;
        integers[0] = expectedInteger;

        //начало теста
        Integer actualString = integerList.set(0, expectedInteger);
        Integer[] actualStrings = integerList.toArray();

        assertEquals(expectedInteger, actualString);
        assertEquals(integers[0] , integerList.toArray()[0]);
        assertArrayEquals(integers, actualStrings);
    }

    @Test
    void set_InvalidIndexException() {
        //входные данные
        int index = 3, size = 2;
        Integer itemInteger = 9;
        integerList = new IntegerListImpl(size);

        //ожидаемый результат
        String expectedError = "Index is incorrect";

        //начало теста
        Exception exception = assertThrows(InvalidIndexException.class, () -> integerList.set(index, itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    void set_NullItemException() {
        //входные данные
        Integer itemInteger = null;
        int index = 0;
        integerList = new IntegerListImpl();

        //ожидаемый результат
        String expectedError = "Item is Null ";

        //начало теста
        Exception exception = assertThrows(NullItemException.class, () -> integerList.set(index, itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    void remove_success() {
        //входные данные
        int size = 1;
        Integer[] integers = new Integer[size];
        integerList = new IntegerListImpl(size + 1);

        //ожидаемый результат
        Integer expectedInteger = 9;
        integers[0] = expectedInteger + 1;
        integerList.add(expectedInteger + 1);
        integerList.add(expectedInteger);

        //начало теста
        Integer actualInteger = integerList.remove(expectedInteger);
        Integer[] actualIntegers = integerList.toArray();

        assertEquals(expectedInteger, actualInteger);
        assertArrayEquals(integers, actualIntegers);
    }

    @Test
    void remove_NullItemException() {
        //входные данные
        Integer itemInteger = null;
        int index = 0;
        integerList = new IntegerListImpl();

        //ожидаемый результат
        String expectedError = "Item is Null ";

        //начало теста
        Exception exception = assertThrows(NullItemException.class, () -> integerList.remove(itemInteger));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    void RemoveIndex_success() {
        //входные данные
        int size = 1, index = 1;
        Integer[] integers = new Integer[size];
        integerList = new IntegerListImpl(size + 1);

        //ожидаемый результат
        Integer expectedInteger = 9;
        integers[0] = expectedInteger + 1;
        integerList.add(expectedInteger + 1);
        integerList.add(expectedInteger);

        //начало теста
        Integer actualInteger = integerList.remove(index);
        Integer[] actualIntegers = integerList.toArray();

        assertEquals(expectedInteger, actualInteger);
        assertArrayEquals(integers, actualIntegers);
    }

    @Test
    void RemoveIndex_InvalidIndexException() {
        //входные данные
        int index = 3, size = 2;
        Integer itemInteger = 9;
        integerList = new IntegerListImpl(size);

        //ожидаемый результат
        String expectedError = "Index is incorrect";

        //начало теста
        Exception exception = assertThrows(InvalidIndexException.class, () -> integerList.remove(index));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    void contains_success() {
        //ожидаемый результат
        Integer expectedInteger = 9;
        Integer expectedInteger2 = 10;
        integerList.add(expectedInteger);

        //начало теста
        boolean isContains = integerList.contains(expectedInteger);
        boolean isNotContains = integerList.contains(expectedInteger2);

        assertTrue(isContains);
        assertTrue(!isNotContains);
    }

    @Test
    void indexOf_success() {
        //входные данные
        Integer expectedInteger = 9;
        Integer expectedInteger2 = 10;

        //ожидаемый результат
        integerList.add(expectedInteger);
        int expectedIndex = 0, indexNotFound = -1;

        //начало теста
        int actualIndex = integerList.indexOf(expectedInteger);
        int actualIndex1 = integerList.indexOf(expectedInteger2);

        assertTrue(expectedIndex == actualIndex);
        assertTrue(indexNotFound == actualIndex1);
    }

    @Test
    void lastIndexOf_success() {
        //входные данные
        Integer expectedInteger = 9;
        Integer expectedInteger2 = 10;

        //ожидаемый результат
        integerList.add(expectedInteger);
        integerList.add(expectedInteger);
        integerList.add(expectedInteger);
        int expectedIndex = 2, indexNotFound = -1;

        //начало теста
        int actualIndex = integerList.lastIndexOf(expectedInteger);
        int actualIndex1 = integerList.lastIndexOf(expectedInteger2);

        assertTrue(expectedIndex == actualIndex);
        assertTrue(indexNotFound == actualIndex1);
    }

    //    @Override
    //    public Integer get(int index) {
    //        validateIndex(index);
    //        return integerList[index];
    //    }

    @Test
    void get_success() {
        //входные данные
        int index = 0;
        integerList = new IntegerListImpl();

        //ожидаемый результат
        Integer expectedInteger = 9;
        integerList.add(expectedInteger);

        //начало теста
        Integer actualString = integerList.get(index);
        assertEquals(expectedInteger, actualString);
    }

    @Test
    void get_InvalidIndexException() {
        //входные данные
        int index = 3, size = 2;
        Integer itemInteger = 9;
        integerList = new IntegerListImpl(size);

        //ожидаемый результат
        String expectedError = "Index is incorrect";

        //начало теста
        Exception exception = assertThrows(InvalidIndexException.class, () -> integerList.get(index));
        assertEquals(expectedError, exception.getMessage());
    }


    @Test
    void size_success() {
        //входные данные
        int size = 2;
        Integer itemInteger= 9;

        //ожидаемый результат
        integerList.add(itemInteger);
        integerList.add(itemInteger);

        //начало теста
        assertTrue(size == integerList.size());
    }

    @Test
    void isEmpty() {
        //входные данные
        integerList = new IntegerListImpl();

        //начало теста
        assertTrue(integerList.isEmpty());
    }

    @Test
    void clear() {
        //входные данные
        int size = 0;
        Integer itemInteger = 9;

        //ожидаемый результат
        integerList.add(itemInteger);
        integerList.add(itemInteger);

        //начало теста
        integerList.clear();
        assertTrue(size == integerList.size());
    }

    @Test
    void toArray() {
        //входные данные
        int size = 2;
        Integer itemInteger = 9;

        integerList.add(itemInteger);
        integerList.add(itemInteger);

        //ожидаемый результат
        Integer[] expectedIntegers = new Integer[size];
        expectedIntegers[0] = itemInteger;
        expectedIntegers[1] = itemInteger;

        //начало теста
        Integer[] actualIntegers = integerList.toArray();
        assertArrayEquals(expectedIntegers, actualIntegers);
    }
}