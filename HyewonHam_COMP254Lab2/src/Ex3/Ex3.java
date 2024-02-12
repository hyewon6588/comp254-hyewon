package Ex3;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        // Perform experimental analysis for unique1
        int maxNUnique1 = findMaxNForOneMinute(Uniqueness::unique1);
        System.out.println("Max value of n for unique1: " + maxNUnique1);

        // Perform experimental analysis for unique2
        int maxNUnique2 = findMaxNForOneMinute(Uniqueness::unique2);
        System.out.println("Max value of n for unique2: " + maxNUnique2);
    }

    // Method to find the maximum value of n such that the algorithm runs in one minute or less
    public static int findMaxNForOneMinute(UniquenessTester tester) {
        int low = 1;
        int high =150000000;
        long startTime, endTime, elapsedTime;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] arr = generateRandomArray(mid);
            startTime = System.currentTimeMillis();
            tester.test(arr);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;

            if (elapsedTime <= 60000) {
                low *=2;
            } else {
                high/=2;
            }
        System.out.println("High: "+high+" Low:"+low+" Elapsed time: " + elapsedTime + " ms");
        }

        return low; // Return the maximum value of n within one minute
    }

    // Functional interface to represent the uniqueness tester method
    interface UniquenessTester {
        boolean test(int[] data);
    }

    // Implementation of Uniqueness class
    static class Uniqueness {

        /** Returns true if there are no duplicate elements in the array. */
        public static boolean unique1(int[] data) {
            int n = data.length;
            for (int j = 0; j < n - 1; j++)
                for (int k = j + 1; k < n; k++)
                    if (data[j] == data[k])
                        return false; // found duplicate pair
            return true; // if we reach this, elements are unique
        }

        /** Returns true if there are no duplicate elements in the array. */
        public static boolean unique2(int[] data) {
            int n = data.length;
            int[] temp = Arrays.copyOf(data, n); // make copy of data
            Arrays.sort(temp); // and sort the copy
            for (int j = 0; j < n - 1; j++)
                if (temp[j] == temp[j + 1]) // check neighboring entries
                    return false; // found duplicate pair
            return true; // if we reach this, elements are unique
        }
    }

    // Method to generate an array of given size with random integers
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size); // Generate random integers between 0 and size-1
        }
        return arr;
    }
}
