import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        int[] arr1 = {3, 0, 2, 3, 1};
        int[] arr2 = {1, 1, 0, 2};

        System.out.println("Current array: " + Arrays.toString(arr1));
        countingSort(arr1);
        System.out.println("Result: " + Arrays.toString(arr1));

        System.out.println("Current array: " + Arrays.toString(arr2));
        countingSort(arr2);
        System.out.println("Result: " + Arrays.toString(arr2));
    }

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        int min = arr[0];
        int max = arr[0];
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int range = max - min + 1;
        int[] count = new int[range];

        for (int val : arr) {
            int offset = val - min;
            count[offset]++;
        }

        int index = 0;
        for (int offset = 0; offset < count.length; offset++) {
            for (int repeat = 0; repeat < count[offset]; repeat++) {
                arr[index++] = offset + min;
            }
        }

    }


}