package Ex2;

public class Ex2 {

    public static void main(String[] args) {
        // Define input sizes
        int[] inputSizes = {10, 100, 1000, 10000, 100000};

        // Perform experimental analysis for prefixAverage1
        System.out.println("prefixAverage1 Execution");
        for (int n : inputSizes) {
            double[] arr = generateArray(n);
            long startTime = System.nanoTime();
            double[] temp=prefixAverage1(arr);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Input size: " + n + ", Elapsed time: " + elapsedTime + " ns");
        }

        // Perform experimental analysis for prefixAverage2
        System.out.println("\nprefixAverage2 Execution");
        for (int n : inputSizes) {
            double[] arr = generateArray(n);
            long startTime = System.nanoTime();
            double[] temp=prefixAverage2(arr);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Input size: " + n + ", Elapsed time: " + elapsedTime + " ns");
        }
    }

    // Method to generate an array of given size with random integers
    public static double[] generateArray(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100); // Generate random integers between 0 and 99
        }
        return arr;
    }
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        for (int j=0; j < n; j++) {
            double total = 0;            // begin computing x[0] + ... + x[j]
            for (int i=0; i <= j; i++)
                total += x[i];
            a[j] = total / (j+1);        // record the average
        }
        return a;
    }

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        double total = 0;              // compute prefix sum as x[0] + x[1] + ...
        for (int j=0; j < n; j++) {
            total += x[j];               // update prefix sum to include x[j]
            a[j] = total / (j+1);        // compute average based on current sum
        }
        return a;
    }
}
