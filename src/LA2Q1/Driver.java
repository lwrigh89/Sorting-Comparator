package LA2Q1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


public class Driver {
    public static void main(String[] args) {
        myHeader();
        System.out.println();

        int sz = 50000; //size of array
        Long time; //time taken to sort the array
        Integer[] integers = new Integer[sz]; //random array
        Integer[] backUpIntegers = new Integer[sz]; //backup array

        //Print Start Message
        System.out.printf("Testing execution time of different sorting algorithms for sorting %d random numbers:\n", sz);


        //populate array with random numbers
        for(int i = 0; i < integers.length; i++){
            Double d = Math.random() * sz;
            integers[i] = d.intValue();
        }

        //create backup of random number array
        System.arraycopy(integers, 0, backUpIntegers, 0, sz);


        //Collection Sort
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(integers));
//        System.out.println(arrayList); //print array
        Long t1 = System.nanoTime(); //start time
        Collections.sort(arrayList); //Do Collection Sort
        Long t2 = System.nanoTime(); //end time
        time = t2-t1;
//        System.out.println(arrayList); //print array
        //output
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", time/1E6);
        //Reset Array
        System.arraycopy(backUpIntegers, 0, integers, 0, sz);



        //Selection Sort
//        System.out.println(Arrays.toString(integers)); //print array
        time = SortingMethods.selectionSort(integers); //sort and get time
//        System.out.println(Arrays.toString(integers)); //print array
        //output
        System.out.printf("My Selection-Sort Time: %.2f milliseconds\n", time/1E6);
        //Reset Array
        System.arraycopy(backUpIntegers, 0, integers, 0, sz);



        //Bubble Sort
//        System.out.println(Arrays.toString(integers)); //print array
        time = SortingMethods.bubbleSort(integers); //sort and get time
//        System.out.println(Arrays.toString(integers)); //print array
        //output
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds\n", time/1E6);
        //Reset Array
        System.arraycopy(backUpIntegers, 0, integers, 0, sz);



        //Insertion Sort
//        System.out.println(Arrays.toString(integers));//print array
        time = SortingMethods.insertionSort(integers); //sort and get time
//        System.out.println(Arrays.toString(integers)); //print array
        //output
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds\n", time/1E6);
        //Reset Array
        System.arraycopy(backUpIntegers, 0, integers, 0, sz);



        //Merge Sort
//        System.out.println(Arrays.toString(integers)); //print array
        time = SortingMethods.mergeSort(integers); //sort and get time
//        System.out.println(Arrays.toString(integers)); //print array
        //output
        System.out.printf("My Merge-Sort Time: %.2f milliseconds\n", time/1E6);
        //Reset Array
        System.arraycopy(backUpIntegers, 0, integers, 0, sz);



        //Quick Sort
//        System.out.println(Arrays.toString(integers)); //print array
        time = SortingMethods.quickSort(integers, 0, sz-1); //sort and get time
//        System.out.println(Arrays.toString(integers)); //print array
        //output
        System.out.printf("My Quick-Sort Time: %.2f milliseconds\n", time/1E6);
        //Reset Array
        System.arraycopy(backUpIntegers, 0, integers, 0, sz);
        System.out.println();

        myFooter();
    }

    public static void myHeader() {
        System.out.println("********************************************");
        System.out.println("Names: Liam Wright and Ronin Williams-Young.");
        System.out.println("Student Numbers: 251161188 and 251162515");
        System.out.println("Goal of this project: Implement generic sorting algorithms and test them by sorting a random array of integers and printing out the time each algorithm took to sort it.");
        System.out.println("********************************************");
    }

    public static void myFooter() {
        Date date = new Date();
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat timeSimpleDateFormat = new SimpleDateFormat("hh:mm a");

        System.out.println("********************************************");
        System.out.println("This is " + timeSimpleDateFormat.format(date) + " on " + daySimpleDateFormat.format(date));
        System.out.println("Completion of Lab Assignment 2 is successful!");
        System.out.println("Good bye! Liam Wright, Ronin Williams-Young.");
        System.out.println("********************************************");
    }
}