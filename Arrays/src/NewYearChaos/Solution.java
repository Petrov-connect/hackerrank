package NewYearChaos;
//created by J.M.

import java.util.Scanner;

public class Solution {

    static void minimumBribes(int[] q) {
        boolean sorted = false;
        boolean chaotic = false;
        int count = 0;

        while (!sorted&&!chaotic) {
            sorted = true;
            int i = -1;
            while (i++ < q.length - 1 && !chaotic) {
                int countNext = 0;
                while (q.length - 2 >= i && q[i] > q[i + 1] && !chaotic) {
                    int current = q[i];
                    q[i] = q[i + 1];
                    q[i + 1] = current;
                    count++;
                    countNext++;
                    sorted = false;
                    chaotic = countNext > 2;
                    i++;
                }
            }
        }
        System.out.println(chaotic ? "Too chaotic" : count);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();

    }
}
