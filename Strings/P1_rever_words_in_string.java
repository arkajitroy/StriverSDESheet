package Strings;

class Solution {

    public static String reverseWords (String s){
        String result = new String();
        int i=0, n= s.length();

        while(i<n){
            while(i<n && s.charAt(i) == ' ') i++;
            if(i>=n) break;
            int j=i+1;
            while(j<n && s.charAt(j) != ' ') j++;
            
            String sub = s.substring(i,j);
            if(result.length() == 0){
                result = sub;
            }else{
                result = sub + " " + result;
            }
            i = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String inputStr = "the sky is blue";
        String result = reverseWords(inputStr);
        System.out.println(result);
    }
}
