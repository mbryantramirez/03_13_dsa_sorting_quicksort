package nyc.pursuit;

import java.util.Arrays;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    // write your code here
    int[] arr = {
        2, 8, 7, 1, 3, 5, 6, 4
    };

    int[] alreadySortedArray = {
        1, 2, 3, 4, 5, 6, 7, 8
    };

    // Sorting an unsortedArray
    quick(arr);

    // Sorting an already sorted array
    quick(alreadySortedArray);

    // Shuffling an already sorted array
    System.out.println(Arrays.toString(alreadySortedArray));
    shuffleArray(alreadySortedArray);
    System.out.println(Arrays.toString(alreadySortedArray));
    quickSort(alreadySortedArray, 0, alreadySortedArray.length - 1);
  }

  private static void quick(int[] arr) {
    System.out.println(Arrays.toString(arr));
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
    printSpace();
  }

  private static void printSpace() {
    System.out.println("\n");
    System.out.println("\n");
    System.out.println("\n");
  }

  private static void quickSort(int[] arr, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      int pivotIndex = partition(arr, startIndex, endIndex);
      System.out.println("(Recursive Call to quicksort) Pivot is: " + pivotIndex);
      quickSort(arr, startIndex, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, endIndex);
    }
  }

  private static int partition(int[] arr, int startIndex, int endIndex) {
    int pivot = arr[endIndex];
    int pointer = startIndex - 1;
    System.out.println("Pivot is " + pivot);
    System.out.println("Pointer is " + pointer);
    System.out.println("Start Index is " + startIndex + " Val: " + arr[startIndex]);
    System.out.println("End Index is " + endIndex + " Val: " + arr[endIndex]);
    System.out.println("Array is " + Arrays.toString(arr));

    for (int i = startIndex; i < endIndex; i++) {
      System.out.println("Comparing i: " + arr[i] + " with pivot: " + pivot);
      if (arr[i] <= pivot) {
        pointer++;
        System.out.println("Swapping: " + arr[i] + " with " + arr[pointer]);
        swap(arr, i, pointer);
        System.out.println("Array is now " + Arrays.toString(arr));
      }
    }
    System.out.println("Final Swap: " + arr[pointer + 1] + " " + arr[endIndex]);
    swap(arr, pointer + 1, endIndex);
    System.out.println("Final Array is: " + Arrays.toString(arr));
    return pointer + 1;
  }

  private static void shuffleArray(int[] array) {
    Random rgen = new Random();  // Random number generator

    for (int i = 0; i < array.length; i++) {
      int randomPosition = rgen.nextInt(array.length);
      swap(array, i, randomPosition);
    }

  }

  private static void swap(int[] array, int firstIndex, int secondIndex) {
    int temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }
}
