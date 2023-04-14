package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = generateRandomArray();
        Integer[] arr2 = Arrays.copyOf(arr1, 100_000);
        Integer[] arr3 = Arrays.copyOf(arr1, 100_000);
        //System.out.println(Arrays.toString(arr1));
        //System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        //System.out.println(Arrays.toString(arr2));

        /*System.out.println(arr1[0] == arr2[0] && arr1[1] == arr2[1] && arr1[2] == arr2[2] && arr1[3] == arr2[3]);
        //first place
        long start = System.currentTimeMillis();
        sortSelection(arr1);
        System.out.println(System.currentTimeMillis() - start);

        //third place
        start = System.currentTimeMillis();
        sortBubble(arr2);
        System.out.println(System.currentTimeMillis() - start);

        //second place
        start = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.println(System.currentTimeMillis() - start);*/

        IntegerListImpl integerList = new IntegerListImpl(30);

        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        integerList.add(0);
        integerList.add(-1);
        integerList.add(9);
        integerList.add(8);
        integerList.add(333);
        integerList.add(1);
        integerList.add(155);
        integerList.add(10);
        integerList.add(13);
        integerList.add(12);

        System.out.println(integerList.toString());
        integerList.sortInsertion();
        System.out.println(integerList.toString());
        System.out.println(integerList.contains(156));
        System.out.println(integerList.contains(155));


    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public  static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}