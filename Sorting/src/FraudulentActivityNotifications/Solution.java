package FraudulentActivityNotifications;
//created by J.M.

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int activityNotifications(int[] expenditure, int d) {

        if (expenditure.length == d) {
            return 0;
        }
        int notifications = 0;

        for (int i = d; i < expenditure.length; i++) {

            int[] num= Arrays.stream(Arrays.copyOfRange(expenditure,i-d,i)).sorted().toArray();
            double median = (d % 2 == 0)
                    ? (num[d / 2] + num[(d / 2) - 1]) / 2.0
                    : num[d / 2];

            if (expenditure[i] >= median * 2) {
                notifications++;
            }
        }
        return notifications;
    }

   /* static int activityNotifications(int[] expenditure, int d) {
        int[] counts = new int[201];
        double midpoint = (d - 1) / 2.0;
        int notifications = 0;
        for (int i = 0; i < expenditure.length; i++) {
            counts[expenditure[i]]++;
            if (i >= d) {
                Integer medianLeft = null;
                Integer medianRight = null;
                for (int j = 0, sum = 0;
                     medianLeft == null || medianRight == null;
                     j++) {
                    sum += counts[j];
                    if (sum > (int)Math.floor(midpoint) && medianLeft == null) {
                        medianLeft = j;
                    }
                    if (sum > (int)Math.ceil(midpoint) && medianRight == null) {
                        medianRight = j;
                    }
                }
                if (expenditure[i] >= medianLeft + medianRight) {
                    notifications++;
                }
                counts[expenditure[i - d]]--;
            }
        }
        return notifications;
    }*/

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        scanner.close();
    }
}
