/**
 * Main class which runs the whole application
 *
 * @author Szymon
 * @version 1.1
 * @since 1.0
 */
public class Main {
  /** Sample array for sorting */
  private int[] arrayToSort = {64, 34, 25, 12, 22, 11, 90};

  /**
   * sort array using selection sort algorithm
   *
   * @param arr array of integers to sort
   */
  public static void selectionSort(int arr[]) {
    int n = arr.length;

    // One by one move boundary of unsorted subarray
    for (int i = 0; i < n - 1; i++) {
      // Find the minimum element in unsorted array
      int min_idx = i;
      for (int j = i + 1; j < n; j++) if (arr[j] < arr[min_idx]) min_idx = j;

      // Swap the found minimum element with the first
      // element
      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }

  /**
   * helper methods for {@link Main#quickSort(int[], int, int) quickSort} method
   *
   * @param arr array of integers to sort
   * @param low the index of the first element of the array
   * @param high the index of last element of the array
   * @return int the index of pivot
   */
  public static int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1); // index of smaller element
    for (int j = low; j < high; j++) {
      // If current element is smaller than the pivot
      if (arr[j] < pivot) {
        i++;

        // swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // swap arr[i+1] and arr[high] (or pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  /**
   * sort array using quick sort algorithm
   *
   * @param arr array of integers to sort
   * @param low the index of the first element of the array
   * @param high the index of last element of the array
   */
  public static void quickSort(int arr[], int low, int high) {
    if (low < high) {
      /*
       * pi is partitioning index, arr[pi] is now at right place
       */
      int pi = partition(arr, low, high);

      // Recursively sort elements before
      // partition and after partition
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  /**
   * sort array using bubble sort algorithm
   *
   * @param arr array of integers to sort
   */
  public static void bubbleSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++)
      for (int j = 0; j < n - i - 1; j++)
        if (arr[j] > arr[j + 1]) {
          // swap arr[j+1] and arr[i]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
  }

  /**
   * print array
   *
   * @param arr array of integers to print
   */
  public static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  /**
   * runs the whole application
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    int arr1[] = {64, 34, 25, 12, 22, 11, 90};
    int arr2[] = arr1.clone();
    int arr3[] = arr1.clone();
    // sort the array using bubbleSort
    bubbleSort(arr1);
    printArray(arr1);
    selectionSort(arr2);
    printArray(arr2);
    quickSort(arr3, 0, arr3.length - 1);
    printArray(arr3);
  }
}
