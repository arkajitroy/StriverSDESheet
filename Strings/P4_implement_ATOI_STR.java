package Strings;

class Main {
    public static int myAtoi(String s){
        int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        int i = 0, n = s.length();
        int sign = 1, num = 0;

        // Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') i++;

        // Handle sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (num > (INT_MAX - digit) / 10) return (sign == 1) ? INT_MAX : INT_MIN;

            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

    public static void main(String[] args) {
        String str1 = "42";
        String str2 = "   -42";
        String str3 = "4193 with words";
        String str4 = "words and 987";
        String str5 = "-91283472332";
        
        System.out.println(myAtoi(str1));  // Output: 42
        System.out.println(myAtoi(str2));  // Output: -42
        System.out.println(myAtoi(str3));  // Output: 4193
        System.out.println(myAtoi(str4));  // Output: 0
        System.out.println(myAtoi(str5));  // Output: -2147483648
    }
}
