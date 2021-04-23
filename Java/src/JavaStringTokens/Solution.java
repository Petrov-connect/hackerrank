package JavaStringTokens;
//created by J.M.

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        List<String> abv= Arrays.stream(s.split("[!,?_'@. ]+"))
                .collect(Collectors.toList());
        abv=abv.stream().filter(e->!e.isEmpty()).collect(Collectors.toList());
        System.out.println(abv.size());
        abv.forEach(System.out::println);

        scan.close();
    }
}
