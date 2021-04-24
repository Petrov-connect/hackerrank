package SalesByMatch;
//created by J.M.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static int sockMerchant(int n, int[] ar) {

        int count=0;
        Set<Integer>set=new HashSet<>();

        for (int i = 0; i < n; i++) {
            if( set.contains(ar[i])){
                count++;
                set.remove(ar[i]);
            }else {
                set.add(ar[i]);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        scanner.close();
        System.out.println(result);
    }
}
