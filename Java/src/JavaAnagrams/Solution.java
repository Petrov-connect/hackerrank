package JavaAnagrams;
//created by J.M.

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // best time complexity

        if (a.length() != b.length())
            return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        java.util.Map<Character, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            char letter = b.charAt(i);
            map.put(letter,!map.containsKey(letter)? 1: map.get(letter)+1);
        }

        for (int i = 0; i < a.length(); i++) {
            char letter = a.charAt(i);
            if (!map.containsKey(letter) || map.get(letter) == 0) {
                return false;
            }
            map.put(letter, map.get(letter) - 1);
        }

        return true;
    }
    // OR , but worse time complexity

    /*static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }
        a=a.toLowerCase();
        b=b.toLowerCase();

        while(a.length()>0){
            int index = b.indexOf(a.charAt(a.length()-1));
            if(index<0){
                return false;
            }
            a = String.valueOf(new StringBuilder(a).deleteCharAt(a.length()-1));
            b = String.valueOf(new StringBuilder(b).deleteCharAt(index));
        }
        return true;
    }*/

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
