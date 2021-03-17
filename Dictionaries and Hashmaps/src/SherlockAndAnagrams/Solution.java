package SherlockAndAnagrams;
//created by J.M.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Solution {

    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> subs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j + i <= s.length(); j++) {
                String sub = Arrays.stream(s.substring(i, i + j).split("")).sorted().collect(Collectors.joining());
                subs.put(sub, subs.containsKey(sub) ? subs.get(sub) + 1 : 1);
            }
        }
        return subs.values().stream().mapToInt(i -> i * (i - 1) / 2).sum();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
        scanner.close();
    }
}