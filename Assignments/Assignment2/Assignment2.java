// Assignment #: 2
// Arizona State University - CSE205
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am 
//  Description: A program that reads in an unspecified number of integers from standard input, performs some calculations on the inputted numbers, and outputs the results of those calculations to standard output

import java.util.Scanner; // use the Scanner class located in the "java.util" directory

public class Assignment2 {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    int num = console.nextInt(); // read an integer entered by a user

    int min = num; //minimum int
    int minEven = 0; //smallest even int
    int countNeg = 0; //count of negative ints
    int sumOdd = 0; //sum of odd ints

    while (num != 0) {
      if (num < min) {
        min = num;
      } if (num % 2 == 0 && num < minEven) { //ensures number is even and smaller than the current minimum even number
        minEven = num;
      } if (num < 0) {
        countNeg++;
      } if (num % 2 != 0) {
        sumOdd += num;
      }

      num = console.nextInt();
    }

    // display the results of all inputs
    System.out.println("The minimum integer is " + min + "\nThe smallest even integer in the sequence is " + minEven + "\nThe count of negative integers in the sequence is " + countNeg + "\nThe sum of odd integers is " + sumOdd);
  }
}
