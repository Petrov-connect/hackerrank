package FraudulentActivityNotifications;
//created by J.M.

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;

        List<Integer> temp = IntStream.of(expenditure).limit(d).boxed().sorted().collect(Collectors.toList());

        for (int i = d; i < expenditure.length; i++) {

            double median = d % 2 != 0
                    ? temp.get(d/2)
                    : (temp.get(d/2) + temp.get((d/2) - 1)) / 2.0;

            if (expenditure[i] >= median * 2) {
                notifications++;
            }
            temp.remove(Collections.binarySearch(temp, expenditure[i - d]));
            int tempIndex = Collections.binarySearch(temp, expenditure[i]);
            if (tempIndex < 0) {
                tempIndex = (-1 * tempIndex) -1;
            }
            temp.add(tempIndex, expenditure[i]);
        }

        return notifications;
    }
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
