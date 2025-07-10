package com.practice.java.dsa;

public class MinHeap {
    // to story array of elements in heap
    private static int[] heapArray;
    // max size of heap
    private int capacity;
     //current number of element in heap
    private  int current_heap_size;

    public MinHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }
    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.insertKey(1);
        h.insertKey(15);


        System.out.println(heapArray[0]);
        System.out.println(heapArray[1]);
        System.out.println(heapArray[2]);
        System.out.println(heapArray[3]);
        h.deleteKey(1);
        System.out.println("---------------------------------------------");
        System.out.println(heapArray[0]);
        System.out.println(heapArray[1]);
        System.out.println(heapArray[2]);
        System.out.println(heapArray[3]);
    }
    private int parent(int key) {
        return (key-1)/2;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }
    public boolean insertKey(int key) {
        if(current_heap_size == capacity){
            return false;
        }
        int i = current_heap_size;
        heapArray[i]= key;
        current_heap_size++;
        while(i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i=parent(i);
        }
        return true;
    }
    private void decreaseKey(int key, int new_value){
        heapArray[key] = new_value;

        while(key !=0 && heapArray[key] < heapArray[parent(key)]){
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }
    public int extractMin(){
        if(current_heap_size <= 0) {
            return Integer.MIN_VALUE;
        }
        if(current_heap_size == 1){
            current_heap_size--;
            return heapArray[0];
        }
        int root = heapArray[0];
        heapArray[0] =heapArray[current_heap_size - 1];
        current_heap_size--;
        minHeapify(0);
        return root;
    }
    private int left(int key){
        return 2*key+1;
    }
    private int right(int key){
        return 2*key+2;
    }
    private void minHeapify(int key){
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if(l < current_heap_size && heapArray[l] < heapArray[smallest])
            smallest = l;
        if(r < current_heap_size && heapArray[r] < heapArray[smallest])
            smallest = r;

        if(smallest != key){
            swap(heapArray, key, smallest);
            minHeapify(key);
        }
    }

    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }
}
