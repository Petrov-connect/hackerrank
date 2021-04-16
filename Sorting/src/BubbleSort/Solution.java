package BubbleSort;
//created by J.M.

import java.util.Scanner;

public class Solution {

    static void countSwaps(int[] a) {

        int swaps = 0;
        boolean sorted = false;

        while (!sorted) {

            sorted = true;

            for (int i = 0; i < a.length - 1; i++) {

                if (a[i] > a[i + 1]) {

                    a[i] ^= a[i + 1]; a[i + 1] ^= a[i]; a[i] ^= a[i + 1];

                    swaps++;
                    sorted = false;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.%nFirst Element: %d%nLast Element: %d", swaps, a[0], a[a.length - 1]);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
