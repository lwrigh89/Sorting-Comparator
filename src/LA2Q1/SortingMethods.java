package LA2Q1;

import java.util.Arrays;

public class SortingMethods {
    public static <T extends Comparable <? super T>>long selectionSort (T [] a){
        long t1 = System.nanoTime(); //start time
        //Selection Sort
        for(int k = 0; k < a.length-1; k++){
            int smallIndex = k; //used to store the index number of the smallest element in the array
            for(int i = k+1; i < a.length; i++){ //loop through each element in the array that is still unsorted
                if(a[i].compareTo(a[smallIndex]) < 0){ //compare the element at i to the element at small index
                    smallIndex = i; //update small index
                }
            }
            //swap leftmost element with the smallest element
            T leftElement = a[k];
            a[k] = a[smallIndex];
            a[smallIndex] = leftElement;
        }
        long t2 = System.nanoTime(); //end time
        return t2 - t1;
    }


    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long t1 = System.nanoTime(); //start time

        for(int k = a.length; k > 0; k--) { //repeat inner steps n-1 times
            for (int i = 0; i < a.length - 1; i++) { //go through each element in array and compare to next
                if (a[i].compareTo(a[i + 1]) > 0) { //if first element is greater than second
                    //Swap elements
                    T temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        long t2 = System.nanoTime(); //end time
        return t2 - t1;
    }
    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        long t1 = System.nanoTime();
        for (int i = 1; i < a.length; i++) { //start at second element in array and repeat n-1 times
            T key = a[i]; //make key equal to the second element
            for (int k = i - 1; k >= 0 && a[k].compareTo(key) > 0; k--) { //loop through sorted portion of array and compare each sorted element to the key
                //insert key in correct position of sorted portion of array
                a[k + 1] = a[k];
                a[k] = key;
            }
        }
        long t2 = System.nanoTime();
        return t2 - t1;
    }


    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        long t1 = System.nanoTime();//start time
        doMergeSort(S); //do merge sort
        long t2 = System.nanoTime();//end time
        return t2 - t1;
    }

    private static <T extends Comparable<? super T>> void doMergeSort(T[] S){
        int n = S.length;
        if(n < 2){ //array is trivially sorted
            return;
        }
        //Divide
        int mid =n/2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid); //copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); //copy of second half
        //Conquer with recursion
        doMergeSort(S1); //sort copy of first half
        doMergeSort(S2); //sort copy of second half
        //merge results
        merge(S1, S2, S); //merge sorted halves back into original
    }

    private static <T extends Comparable<? super T>> void merge(T[] S1, T[] S2, T[] S){
        //merge contents of array S1 and S2 into properly sized array S
        int i = 0, j = 0;
        while(i+j < S.length){
            if(j==S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0)){
                S[i+j] = S1[i++]; //copy ith element of S1 and increment i
            } else{
                S[i+j] = S2[j++]; //copy jth element of S2 and increment j
            }
        }
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
        long t1 = System.nanoTime(); //start time
        doQuickSort(s, a, b); //do merge sort
        long t2 = System.nanoTime(); //end time
        return t2 - t1;
    }

    private static <T extends Comparable<? super T>> void doQuickSort(T[] S, int a, int b){
        if(a >= b){ //sub array is sorted since theres one element
            return;
        }
        T p = S[b]; //assume pivot point p
        int l = a; //left pointer that will scan rightwards
        int r = b-1; //right pointer that will scan leftward
        while(l <= r){
            while(l<=r && S[l].compareTo(p) <= 0){ //find an element larger than the pivot
                l++;
            }
            while (l<=r && S[r].compareTo(p) >= 0){ //find an element smaller than the pivot
                r--;
            }
            if(l<r){
                //swap S[l] and S[r]
                T temp = S[l];
                S[l] = S[r];
                S[r] = temp;
                l++;
                r--;
            }
        }
        //swap the elements S[l] and S[b]
        T temp = S[l];
        S[l] = S[b];
        S[b] = temp;

        //recursive calls
        doQuickSort(S, a, l-1);
        doQuickSort(S, l+1, b);
    }
}
