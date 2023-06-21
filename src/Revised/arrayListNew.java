package Revised;

import java.util.Arrays;


public class arrayListNew<T extends Comparable<T>> {
    public T[] list;
    public int arrSize;
    public int size;

    public arrayListNew(int size) {
        this.size = size;
        list = (T[]) new Comparable[size];
        arrSize = 0;
    }

    public void add(T value) {
        if (arrSize == list.length) {
            T[] increasedArr = (T[]) new Comparable[arrSize * 2];
            for (int i = 0; i < list.length; i++) {
                increasedArr[i] = list[i];
            }
            list = increasedArr;
        }

        list[arrSize] = value;
        arrSize++;
    }


    public void addAll(T[] values) {
        for (T value : values) {
            add(value);
        }
    }

    public void remove(int position) {
        for (int i = position; i < arrSize; i++) {
            list[i] = list[i + 1];
        }
        list[arrSize] = null;
        if (arrSize >= 0) {
            arrSize--;
        }
    }


    public void removeAll() {
        list = (T[]) new Object[size];
        arrSize = 0;
    }

    public int getArrSize() {
        return arrSize;
    }

    public void setArrSize(int arrSize) {
        this.arrSize = arrSize;
    }

    public Comparable[] cleanArrayList() {
        Comparable[] clean = Arrays.copyOf(list, arrSize);
        return clean;
    }

    public boolean contains(T value) {
        Comparable[] clean = cleanArrayList();
        return binarySearch(clean, value);
    }

    public int linearSearch(T[] unsorted, T value) {
        for (int i = 0; i < unsorted.length; i++) {
            if (list[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int indexof(T value) {
        Comparable[] clean = cleanArrayList();
        return linearSearch((T[]) clean, value);
    }

    public boolean binarySearch(Comparable[] unsorted, T value) {
        Comparable[] sorted = bubbleSort(unsorted);
        int min = 0;
        int max = sorted.length - 1;

        while (min <= max) {
            int mid = (max + min) / 2;
            Comparable midValue = sorted[mid];

            if (midValue.compareTo(value) == 0) {
                return true;
            } else if (midValue.compareTo(value) < 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return false;
    }

    public Comparable[] bubbleSort(Comparable[] unsorted) {
        Comparable temp;

        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = 0; j < unsorted.length - i - 1; j++) {
                if (unsorted[j].compareTo(unsorted[j + 1]) > 0) {
                    temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }

        return unsorted;
    }

    public T[] toArray() {
        T[] clean = Arrays.copyOf(list, arrSize);
        return clean;
    }

    public arrayListNew<T> bubbleSortSelf() {
        Comparable[] unsorted = Arrays.copyOf(list, arrSize);
        Comparable temp;

        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = 0; j < unsorted.length - i - 1; j++) {
                if (unsorted[j].compareTo(unsorted[j + 1]) > 0) {
                    temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }

        arrayListNew<T> sortedList = new arrayListNew<T>(unsorted.length);
        sortedList.addAll((T[]) unsorted);
        return sortedList;
    }

    public T[] arrSort() {
        return insertionSort(list);
    }


    public T[] descendingInsertionSort() {
        T[] ascSorted = insertionSort(list);
        T[] result = (T[]) new Comparable[arrSize];

        int counter = 0;
        for (int i = arrSize - 1; i >= 0; i--) {
            result[counter] = ascSorted[i];
            counter++;
        }

        return result;
    }

    public T[] insertionSort(T[] input) {
        T[] unsorted = Arrays.copyOf(input, arrSize);
        T[] clean = Arrays.copyOf(list, arrSize);

        for (int i = 0; i < clean.length; i++) {
            T temp = clean[i];

            int j = i - 1;
            while ((j >= 0 && ((Comparable<T>) clean[j]).compareTo(temp) > 0)) {
                clean[j + 1] = clean[j];
                j--;
            }
            clean[j + 1] = temp;
        }

        return clean;
    }

}
