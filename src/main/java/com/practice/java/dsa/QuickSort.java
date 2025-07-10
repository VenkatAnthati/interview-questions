package com.practice.java.dsa;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 6, 2, 3, 1, 8, 7, 4 };
        quickSort(array, 0, array.length-1);
        for(int i= 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }
    private static void quickSort(int[] array, int low, int high) {
        if(low < high ){
            int pi = partition(array, low, high);
                quickSort(array, low, pi-1);
                quickSort(array, pi+1, high);
        }
    }
    private static int partition(int[] array, int low, int high){
        int i = low-1;
        for (int j = low; j< high; j++){
            if(array[j] < array[high]){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }
}
