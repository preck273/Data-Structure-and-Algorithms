package com.dataStructure;

public class ArrayList {
    public Integer[] list;
    public int arrSize; //Counter for how much space is actually being used
    public int size; //Actual size counter

    public ArrayList(Integer size) {
        this.size = size;
        list = new Integer[size]; //Can assign size to arrayList / for indexing
        arrSize = 0;
    }

    //    Add a Integer to the ArrayList
    public void add(Integer value){
        list[arrSize] = value;
        arrSize++;

        if(arrSize+ 1 == list.length){
            Integer[] increasedArr = new Integer[size*2];
            for (int i = 0; i< list.length; i++){
                increasedArr[i] = list[i];
            }
            list = increasedArr;
        }
    }

//    Add an entire Integer List to the ArrayList
    public void addall(Integer[] values){
        for (Integer value: values){
            add(value);
        }
    }

    public void remove(int position){
        for (int i = position; i< arrSize; i++ ){
            list[i] = list[i+1];
        }
        list[arrSize] = null;
        arrSize--;
    }

    //    Clear the ArrayList
    public void removeAll(){
        list= new Integer[size];
        arrSize = 0;
    }

    public int getArrSize() {
        return arrSize;
    }

    public void setArrSize(int arrSize) {
        this.arrSize = arrSize;
    }

//    Implements BinarySearch
    public boolean contains(Integer value){
        boolean found = false;

        Integer[] clean = new Integer[arrSize];

        for (int i = 0; i< list.length -1; i++ ){
            if(list[i] != null){
                clean[i] = list[i];
            }
        }
        int index = binarySearch(clean,value);
        if( index >= 0){
            found = true;
        }
        return found;
    }

    //    Implements index, if non return -1
//    Implements Linear Search
    public Integer indexof(Integer value){
        return linearSearch(list,value);
    }

//    Sequentially go through the list
    public Integer linearSearch(Integer[] unsorted, Integer value){
        for (int i = 0; i< unsorted.length; i++ ){
            if (list[i].equals(value)){
                return i;

            }
        }
        return -1;
    }

//        sort
//    look with middle
    public Integer binarySearch(Integer[] unsorted, Integer value){
        Integer[] sorted = bubbleSort(unsorted);
        int min = 0;
        int max = sorted.length -1;

        while (min <= max){
            int mid = Math.round(max+min/2);
            int midValue = sorted[mid];

            if(value == midValue){
                return mid;
            }
            else if(value< midValue){
                max = mid-1;
            }
            else if(value< midValue){
                min = mid+1;
            }
        }
        return -1;
    }

//  Implement bubbleSort in binarySearch
    public Integer[] bubbleSort(Integer[] unsorted){
        Integer tempI;

        for (int i = 0; i< unsorted.length -1; i++ ){
            for (int j = 0; j < unsorted.length -i -1; j++ ){
                if(unsorted[j]> unsorted[j+1]){
                    tempI = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = tempI;
                }
            }
        }
        return unsorted;
    }

    //  Implement bubbleSort in binarySearch
    public Integer[] mergeSort(Integer[] unsorted){
        int max = unsorted.length;
        if (max<= 1) return ;

        int mid = max/2;

        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[max - mid];



        for (int i = 0; i< unsorted.length -1; i++ ){
            for (int j = 0; j < unsorted.length -i -1; j++ ){
                if(unsorted[j]> unsorted[j+1]){
                    tempI = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = tempI;
                }
            }
        }
        return unsorted;
    }


}
