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

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean anagram = isAnagram(a, b);
        System.out.println((anagram) ? "Anagrams" : "Not Anagrams");
    }
}
