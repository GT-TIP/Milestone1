import java.util.*;

/**
 * Problem
 * - Delete duplicates from an array in-place
 *
 * Example
 * - Input: [6, 4, 2, 8, 10, 3, 5, 6, 6, 2, 3, 8, 14]
 * - Output: [2, 3, 4, 5, 6, 8, 10, 14, 0, 0, 0, 0, 0]
 *
 */
public class Beginner {

    /**
     * O(n log n) solution
     */
    public static void deleteDuplicates(int[] arr) {

        Arrays.sort(arr);

        int indToWrite = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[indToWrite - 1]) {
                arr[indToWrite++] = arr[i];
            }
        }

        for (int i = indToWrite; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 4, 2, 8, 10, 3, 5, 6, 6, 2, 3, 8, 14};
        deleteDuplicates(arr);
        System.out.print(Arrays.toString(arr));
    }

}
