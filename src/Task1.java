import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        int[] arr1 = {329, 457, 657, 839};
        int[] arr2 = {21, 4, 105, 33};

        System.out.println("Current array: " + Arrays.toString(arr1));
        radixSort(arr1);
        System.out.println("Result: " + Arrays.toString(arr1));

        System.out.println("Current array: " + Arrays.toString(arr2));
        radixSort(arr2);
        System.out.println("Result: " + Arrays.toString(arr2));
    }

    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        int max = arr[0];
        for (int val : arr) {
            if (val < 0) return;
            max = Math.max(val, max);
        }

        for (int place = 1; max / place > 0; place *= 10) {
            countingSortByDigit(arr, place);
        }

    }

    private static void countingSortByDigit(int[] arr, int place) {

        int[] count = new int[10];
        for (int val : arr) {
            count[(val / place) % 10]++;
        }

        for (int digit = 1; digit < 10; digit++) {
            count[digit] += count[digit - 1];
        }

        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            result[--count[digit]] = arr[i];
        }

        System.arraycopy(
                result,
                0,
                arr,
                0,
                result.length
        );
    }

}