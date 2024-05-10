package Strings;

import java.util.HashMap;
import java.util.Map;

class Main {
    public static int romanToInt(String s){
        // map<char, count>
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result= 0, prev= 0;

        // Iterate through the input string from right to left
        for(int i=s.length()-1; i>=0; i--){
            int current = map.get(s.charAt(i));

            if(current < prev) result -= current;
            else result += current;

            prev = current;
        }
        return result;
    }

    public static int romanToInt_II(String s){
        int prev = 0, result= 0;
        for(int i=s.length()-1; i>=0; i--){
            int current = getIntValueByRomanChars(s.charAt(i));

            if(current < prev) result -= current;
            else result += current;

            prev = current;
        }
        return result;
    }

    private static int getIntValueByRomanChars(char ch){
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        String romanNumeral = "MCMXCIV"; // Example input
        System.out.println("Integer value: " + romanToInt(romanNumeral));
        System.out.println("Integer value - Approach II: " + romanToInt_II(romanNumeral));
    }
}
