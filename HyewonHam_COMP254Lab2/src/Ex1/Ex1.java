package Ex1;

public class Ex1 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,7,8,9,10};
        int[] arr2={11,12,13,14,15,16,17,18,19,20};
        System.out.println(example1(arr1));
        System.out.println(example2(arr1));
        System.out.println(example3(arr1));
        System.out.println(example4(arr1));
        System.out.println(example5(arr1,arr2));
    }

    /** Returns the sum of the integers in given array. */
    //Time complexity: O(n) - Linear Running Time
    public static int example1(int[] arr) {
        int n = arr.length, total = 0; //3 primitive operations
        for (int j=0; j < n; j++)       //loop from 0 to n-1; 2n+1 primitives
            total += arr[j];            //adds each value in array to total; 3n primitives
        return total;//1 primitive operation
    }
    //thus, f(n)=5n+5, Time complexity will be O(n)
    //Running time depends on the length of array.

    /** Returns the sum of the integers with even index in given array. */
    //Time complexity: O(n) - Linear Running Time
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2)    //n+1 primitives // note the increment of 2
            total += arr[j];            //adds each value in array to total; 3n/2 primitives
        return total;
    }
    //Running time depends on the length of array.
    //The number of operations in the for loop will be n/2 times each,
    // which indicates that it still takes Linear Running time, O(n).

    /** Returns the sum of the prefix sums of given array. */
    //Time complexity: O(n^2) - Quadratic Running time
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        //nested loop
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            for (int k=0; k <= j; k++)    // loop from 0 to j
                total += arr[j];    //adds each value in array to total; iterates n*n times
        return total;
    }

    /** Returns the sum of the prefix sums of given array. */
    //Time complexity: O(n) - Linear Running Time
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j=0; j < n; j++) {     //iterates operation n times// loop from 0 to n-1
            prefix += arr[j];//adds each value in array
            total += prefix;//adds values in prefix to total
            //prefix: 1 1+2 1+2+3 ...
            //total: 1 1+1+2 1+1+2+1+2+3 ...
        }
        return total;
    }

    /** Returns the number of times second array stores sum of prefix sums from first. */
    //Time Complexity: O(n^3) - Cubic Running Time
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        //three nested loops
        for (int i=0; i < n; i++) {     // loop from 0 to n-1
            int total = 0;
            for (int j=0; j < n; j++)     // loop from 0 to n-1
                for (int k=0; k <= j; k++)  // loop from 0 to j
                    total += first[k]; //iterates n^3 times; adds values in array to total
            //counts if sum of elements in first array equals to element of second array
            if (second[i] == total) count++;
        }
        return count;
    }

}
