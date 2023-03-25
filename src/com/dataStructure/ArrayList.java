package com.dataStructure;

public class ArrayList {
    public String[] list;
    public int arrSize; //Counter for how much space is actually being used
    public int size; //Actual size counter

    public ArrayList(Integer size) {
        this.size = size;
        list = new String[size]; //Can assign size to arrayList / for indexing
        arrSize = 0;
    }

    //    Add a String to the ArrayList
    public void arrAdd(String value){
        list[arrSize] = value;
        arrSize++;

        if(arrSize+ 1 == list.length){
            String[] increasedArr = new String[size*2];
            for (int i = 0; i< list.length; i++){
                increasedArr[i] = list[i];
            }
            list = increasedArr;
        }
    }

//    Add an entire String List to the ArrayList
    public void arrAddAll(String[] values){
        for (String value: values){
            arrAdd(value);
        }
    }

    public void arrRemove(int position){
        for (int i = position; i<= arrSize; i++ ){
            list[i] = list[i+1];
        }
        list[arrSize] = null;
        arrSize--;
    }

    //    Clear the ArrayList
    public void arrRemoveAll(){
        String[] emptyArr = new String[size];
        list= emptyArr;
        arrSize = 0;
    }

    public int getArrSize() {
        return arrSize;
    }

    public void setArrSize(int arrSize) {
        this.arrSize = arrSize;
    }
}
