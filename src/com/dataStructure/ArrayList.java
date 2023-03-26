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
        for (int i = position; i<= arrSize; i++ ){
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

//    Implements Linear Sort
    public boolean contains(Integer value){
        return linearSearch(list,value);
    }

    //    Implements index of sort, get index array Hashmap of index and value
    public boolean indexof(Integer value){
        return linearSearch(list,value);
    }

    public boolean linearSearch(Integer[] unsorted, Integer value){
        boolean found = false;
        for (int i = 0; i<= unsorted.length; i++ ){
            if (list[i].equals(value)){
                found = true;
            }
        }
        return found;
    }

//        sort
//    look with middle
    public void binarySearch(Integer[] unsorted){
        for (int i = 0; i<= unsorted.length; i++ ){
            list[i] = list[i+1];
        }
    }

    public void bubbleSort(Integer[] unsorted){
        Integer tempI;
        Integer tempJ;

        for (int i = 0; i<= unsorted.length -1; i++ ){
            for (int j = 1; j <= unsorted.length; j++ ){
                if(unsorted[j]> unsorted[i]){

                }
            }
        }
    }

}
