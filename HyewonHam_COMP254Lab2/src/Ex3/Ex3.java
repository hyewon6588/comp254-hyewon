package Ex3;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        // Define input sizes
        int[] inputSizes = {1000000,10000000,100000000,250000000};

        // Perform experimental analysis for unique1
        System.out.println("Experimental Analysis for unique1:");
        for (int n : inputSizes) {
            int[] arr = generateRandomArray(n);
            long startTime = System.nanoTime();
            boolean result = unique1(arr);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Input size: " + n + ", Elapsed time: " + elapsedTime + " ns, Result: " + result);
        }

        // Perform experimental analysis for unique2
        System.out.println("\nExperimental Analysis for unique2:");
        for (int n : inputSizes) {
            int[] arr = generateRandomArray(n);
            long startTime = System.nanoTime();
            boolean result = unique2(arr);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Input size: " + n + ", Elapsed time: " + elapsedTime + " ns, Result: " + result);
        }
    }
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size); // Generate random integers between 0 and size-1
        }
        return arr;
    }
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j=0; j < n-1; j++)
            for (int k=j+1; k < n; k++)
                if (data[j] == data[k])
                    return false;                    // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);   // make copy of data
        Arrays.sort(temp);                     // and sort the copy
        for (int j=0; j < n-1; j++)
            if (temp[j] == temp[j+1])            // check neighboring entries
                return false;                      // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }
}
