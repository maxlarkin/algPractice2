import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        double[] arr1 = {0.25, 0.70, 0.10, 0.90};
        double[] arr2 = {0.05, 0.05, 0.80};

        System.out.println("Current array: " + Arrays.toString(arr1));
        bucketSort(arr1);
        System.out.println("Result: " + Arrays.toString(arr1));

        System.out.println("Current array: " + Arrays.toString(arr2));
        bucketSort(arr2);
        System.out.println("Result: " + Arrays.toString(arr2));


    }

    public static void bucketSort(double[] arr) {
        if (arr.length == 0) return;
        int s = arr.length;
        // double[][]
        List<List<Double>> buckets = new ArrayList<>(s);

        for (int i = 0; i < s; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double val : arr) {
            if (!(val >= 0 && val < 1.0)) {
                return;
            }
            int index = Math.min(s - 1, (int) (val * s));
            buckets.get(index).add(val);
        }

        int index = 0;
        for (List<Double> bucket : buckets) {
            insertionSort(bucket);
            for (double val : bucket) {
                arr[index++] = val;
            }
        }

    }

    private static void insertionSort(List<Double> bucket) {
        for (int i = 1; i < bucket.size(); i++) {

            double key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }


    }

}