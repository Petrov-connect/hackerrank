package JavaSubstringComparisons;
//created by J.M.

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(getSmallestAndLargest(scan.nextLine(),Integer.parseInt(scan.nextLine())));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0,k);

        for (int i = 1; i <= s.length()-k; i++) {
            String substring = s.substring(i, i + k);
            if(substring.compareTo(smallest)<0){
                smallest= substring;
            }
            if(substring.compareTo(largest)>0){
                largest= substring;
            }
        }

        return smallest + "\n" + largest;
    }
}
