package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LongestSemiRepetitiveSubstring {

    public int getLongestSemiRepetitiveSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        int prevRepeatedI = 0; // index of previous repeated
        int prevChar = s.charAt(0); // previous last seen char

        List<Character> listOfCharacters = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            listOfCharacters.add(ch);
        }

        ListIterator<Character> iterator = listOfCharacters.listIterator();
        while (iterator.hasNext()) {
            int i = iterator.nextIndex();
            int currChar = iterator.next();
            if (prevChar == currChar) {
                if (prevRepeatedI != 0) {
                    // more than one pair of same digits
                    start = prevRepeatedI;
                }
                prevRepeatedI = i;
            }
            maxLength = Math.max(i - start + 1, maxLength);
            prevChar = currChar;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "52233";
        LongestSemiRepetitiveSubstring longestSemiRepetitiveSubstring = new LongestSemiRepetitiveSubstring();
        System.out.println(longestSemiRepetitiveSubstring.getLongestSemiRepetitiveSubstring(s));
    }
}
