// Assignment #: 9
//         Name: Zak Sakata
//    StudentID: 1214985785
//      Lecture: 10:30am
//  Description: Assignment #9 will be the construction of a program that 
//               reads in a sequence of integers from standard input until
//               0 is read, and store them in an array (including 0). This
//               is done using iteration (choose one of for, while, or do while loop).
//               You may assume that there will not be more than 100 numbers.

import java.io.*;           

public class Assignment9 {
  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader scan = new BufferedReader(isr);
    int[] intArr = new int[100];
    int numInt = 0;
    
    try {
      int i;
      for (i = 0; i < intArr.length; i++) {
        try {
          int intInput = Integer.parseInt(scan.readLine());
          intArr[i] = intInput;
          numInt++;

          if (intInput == 0) {
            break;
          }
        } catch (NumberFormatException err) {
          i--; // moves current array index back one if a non-integer was entered
          System.out.println("Please enter an integer");
        }
      }
    } catch (IOException err) {
      System.out.println(err);
    }
 
    int min = findMin(intArr, 0, numInt - 1);
    int smallestEven = computeSmallestEven(intArr, 0, numInt - 1);
    int numNegNum = countNegativeNumbers(intArr, 0, numInt - 1);
    int numDivisible3 = computeSumOfNumbersDivisibleBy3(intArr, 0, numInt - 1);

    System.out.println("The minimum number is " + min);
    System.out.println("The smallest even integer in the sequence is " + smallestEven);
    System.out.println("The count of negative integers in the sequence is " + numNegNum);
    System.out.println("The sum of numbers that are divisible by 3 is " + numDivisible3);
  }

  public static int findMin(int[] elements, int startIndex, int endIndex) {
    if (startIndex == endIndex) {
      return elements[startIndex];
    }
    
    int min = findMin(elements, startIndex + 1, endIndex);
    if (elements[startIndex] <= min) {
      return elements[startIndex];
    } else {
      return min;
    }
  }

  public static int computeSmallestEven(int[] elements, int startIndex, int endIndex) {
    if (startIndex == endIndex) {
      return elements[startIndex];
    }

    int minEven = computeSmallestEven(elements, startIndex + 1, endIndex);
    if (elements[startIndex] % 2 == 0 && minEven % 2 == 0) {
      if (elements[startIndex] < minEven) {
        return elements[startIndex];
      } else {
        return minEven;
      }
    } else {
      return minEven;
    }
  }

  public static int countNegativeNumbers(int[] elements, int startIndex, int endIndex) {
    if (startIndex == endIndex) {
      return elements[startIndex];
    }

    int count = countNegativeNumbers(elements, startIndex + 1, endIndex);
    if (elements[startIndex] < 0) {
      return 1 + count;
    } else {
      return count;
    }
  }

  public static int computeSumOfNumbersDivisibleBy3(int[] elements, int startIndex, int endIndex) {
    if (startIndex == endIndex) {
      return elements[startIndex];
    }

    int sum = computeSumOfNumbersDivisibleBy3(elements, startIndex + 1, endIndex);
    if (elements[startIndex] % 3 == 0) {
      return elements[startIndex] + sum;
    } else {
      return sum;
    }
  }
}