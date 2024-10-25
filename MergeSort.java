import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Example array to be sorted
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(array));

        // Call the mergeSort method
        mergeSort(array, 0, array.length - 1);

        // Output the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    // Method to perform Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        // Base case: if the array has one or zero elements, it's already sorted
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort the first half
            mergeSort(array, left, mid);
            // Recursively sort the second half
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Method to merge two halves of the array
    public static void merge(int[] array, int left, int mid, int right) {
        // Sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the values
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0; // Initial indexes of the first and second subarrays
        int k = left; // Initial index of the merged subarray

        // Merge the two arrays
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray, if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
