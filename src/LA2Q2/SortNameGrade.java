package LA2Q2;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

public class SortNameGrade {
    //header method displaying our names, student numbers, and what we feel the goal of this project is
    public static void myHeader2() {
        System.out.println("\n********************************************");
        System.out.println("Names: Liam Wright and Ronin Williams-Young.");
        System.out.println("Student Numbers: 251161188 and 251162515");
        System.out.println("Goal of this project: Use compareTo methods \nand sorting algorithms to compare and sort \nstudents with their grades, firstnames, and lastnames");
        System.out.println("********************************************\n");
    }
    //footer method to show the time and date of the code finishing and a goodbye message
    public static void myFooter2() {
        Date date = new Date();
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeSimpleDateFormat = new SimpleDateFormat("hh:mm:ss");

        System.out.println("\n********************************************");
        System.out.println("This is " + timeSimpleDateFormat.format(date) + " on " + daySimpleDateFormat.format(date));
        System.out.println("Completion of Lab Assignment 2 is successful!");
        System.out.println("Good bye! Liam Wright, Ronin Williams-Young.");
        System.out.println("********************************************");
    }
    //creating the main method
    public static void main(String[] args) {
        //call header
        myHeader2();
        //creating 3 arrays that store the first, last names and grades of different students
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        //grades are generated randomly between 60 and 86
        Integer[] grd =
                {(int)(60 + Math.random()*26),
                        (int)(60 + Math.random()*26),
                        (int)(60 + Math.random()*26),
                        (int)(60 + Math.random()*26),
                        (int)(60 + Math.random()*26),
                        (int)(60 + Math.random()*26),
                        (int)(60 + Math.random()*26),
                        (int)(60 + Math.random()*26)};
        //creating a Vector class with the StudentGrade tag in order to store variables used in StudentGrade
        Vector<StudentGrade> studentGrade = new Vector<StudentGrade>();
        //for loop used to add the values above into the Vector class (8 students)
        for (int i = 0; i < grd.length; i++) {
            StudentGrade user = new StudentGrade(fnArray[i], lnArray[i], grd[i]);//creates a variable that holds all 3 variables
            studentGrade.add(i, user);//adds the StudentGrade variable to the Vector along with an index to keep track of each student
        }

        System.out.println("The Unsorted Array................");
        //for loop used to print out the unsorted array in the same order it was inserted into the Vector
        for (int i = 0; i < grd.length; i++) {
            System.out.print(studentGrade.get(i));
        }

        Collections.sort(studentGrade);//uses sort function to automatically sort each student with their grade (only works with numbers)
        System.out.println("\nSorted by Grades......................");
        //for loop to print out new sorted Vector
        for (int i = 0; i < grd.length; i++) {
            System.out.print(studentGrade.get(i));
        }
        //creates a new array of StudentGrade that can hold three variables each
        StudentGrade[] stGrd = new StudentGrade[fnArray.length];
        //copyInto method used to copy the Vector into our new StudentGrade array (can be done since each student has an index in the vector)
        studentGrade.copyInto(stGrd);
        //calls insertionSort method to sort the array based on first names (if key = 1, insertionSort sorts by first names)
        insertionSort(stGrd, 1);
        System.out.println("\nSorted by First Names.............");
        //for loop prints out the array sorted by first names
        for (int i = 0; i < fnArray.length; i++) {
            System.out.print(stGrd[i].toString());
        }
        //calls insertionSort method to sort the array based on last names (if key = 2, insertionSort sorts by last names)
        insertionSort(stGrd, 2);
        System.out.println("\nSorted by Last Names...............");
        //for loop prints out the array sorted by last names
        for (int i = 0; i < fnArray.length; i++) {
            System.out.print(stGrd[i].toString());
        }
        //calls footer method
        myFooter2();
    }
    //insertionSort method that takes an array of StudentGrade and an int key
    public static void insertionSort(StudentGrade[] a, int key1){
        if (key1 == 1) {
            for (int i = 1; i < a.length; i++) {//first for loop starts with the second index
                String key = a[i].getFirstName();//creates String reference to the first name
                StudentGrade key2 = a[i];//creates a reference for the entire student
                //second for loop checks all the indexes under i, and proceeds if any index first names are greater than key
                for (int k = i - 1; k >= 0 && a[k].getFirstName().compareTo(key) > 0; k--) {
                    a[k + 1] = a[k];//moves the lower index up one
                    a[k] = key2;//moves the i index to where the lower index used to be
                }
            }
        } else if (key1 == 2) {
            for (int i = 1; i < a.length; i++) {
                String key = a[i].getLastName();//creates String reference to the last name
                StudentGrade key2 = a[i];
                //second for loop checks all the indexes under i, and proceeds if any index last names are greater than key
                for (int k = i - 1; k >= 0 && a[k].getLastName().compareTo(key) > 0; k--) {
                    a[k + 1] = a[k];
                    a[k] = key2;
                }
            }
        }

    }
}
