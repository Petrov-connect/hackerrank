package RepeatedString;
//created by J.M.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {


    static long repeatedString(String s, long n) {

        long count = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == 'a').count();
        long repeat = n / s.length();
        long left = n % s.length();
        count *= repeat;

        count += IntStream.iterate(0, i -> i < left, i -> i + 1).filter(i -> s.charAt(i) == 'a').count();
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}