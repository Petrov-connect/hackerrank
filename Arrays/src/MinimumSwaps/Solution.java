package MinimumSwaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    static int minimumSwaps(int[] arr) {
        int i = 0, count = 0, n = arr.length, temp;
        while (i < n) {
            if (arr[i] != i + 1) {
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                count++;
            } else {
                i++;
            }
        }
        return count;

       /* int count = 0;
        int currentIndex = 0;
        Set<Integer> set = new HashSet<>();
        while (currentIndex < arr.length - 1) {
            int min = Arrays.stream(arr).filter(e -> !set.contains(e)).min().orElse(0);
            int minIndex = Arrays.stream(arr).boxed().collect(Collectors.toList()).indexOf(min);
            set.add(min);
            if (minIndex != currentIndex) {
                int current = arr[currentIndex];
                arr[currentIndex] = arr[minIndex];
                arr[minIndex] = current;
                count++;
            }
            currentIndex++;
        }
        return count;*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(scanner.nextLine());
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        scanner.close();

        int res = minimumSwaps(arr);

        System.out.println(res);

    }
}

