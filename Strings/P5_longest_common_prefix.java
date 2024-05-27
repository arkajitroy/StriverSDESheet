package Strings;

import java.util.Arrays;

class Main {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        // sorting the string-array
        Arrays.sort(strs);

        // Getting the first and last string
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        // start comparing
        for(int i=0; i<first.length; i++){
            if(first[i] != last[i]) break;
            result.append(first[i]);
        }

        return result.toString();
    }
    
    public static void main(String[] args) {
        String[] strs = { "flower","flow","flight" };
        System.out.println("Longest Common Prefix: " +longestCommonPrefix(strs));
    }
}
