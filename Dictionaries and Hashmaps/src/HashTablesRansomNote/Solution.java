package HashTablesRansomNote;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Integer>map = new HashMap<>();
        boolean yes = true;
        Arrays.stream(magazine).forEach(s -> map.put(s, !map.containsKey(s) ? 1 : map.get(s) + 1));
        for (String s : note) {
            if(map.containsKey(s)&&map.get(s)>0){
                map.put(s,map.get(s)-1);
            }else{
                yes=false; break;
            }
        }
        System.out.println(yes ? "Yes" : "No");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (m >= 0) System.arraycopy(magazineItems, 0, magazine, 0, m);

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (n >= 0) System.arraycopy(noteItems, 0, note, 0, n);

        checkMagazine(magazine, note);

        scanner.close();
    }
}
