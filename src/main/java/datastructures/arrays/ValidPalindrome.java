package datastructures.arrays;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String originalString = sb.toString();
        StringBuilder reverseSb = sb.reverse();
        return reverseSb.toString().equals(originalString);
    }

    class Solution {
        public boolean isPalindrome(String s) {
            // Short Solution
            int n = s.length();
            int i = 0 , j = n-1;
            char cj,ci;
            while(i<j){
                ci = s.charAt(i);
                if(ci >= 'A' && ci <= 'Z') ci += 0x20;
                // System.out.println("ci: " + ci);
                cj = s.charAt(j);
                if(cj >= 'A' && cj <= 'Z') cj += 0x20;
                // System.out.println("cj: " + cj);
                if( ! ((ci >= 'a' && ci <= 'z') || (ci >= '0' && ci <= '9')) ){
                    i++;
                }
                else if ( ! ((cj >= 'a' && cj <= 'z') || (cj >= '0' && cj <= '9')) ){
                    j--;
                }
                else if(ci != cj){
                    return false;
                }else{
                    i++;
                    j--;
                }
            }

            return true;
            // Long Solution
            // // filtering the string
            // String p = "";
            // s = s.toLowerCase();
            // for(int i = 0 ; i < s.length() ; i++){
            //     char ch = s.charAt(i);
            //     if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
            //         p += s.charAt(i);
            //     }
            // }

            // // check if palidnrome or not
            // int n = p.length();
            // for(int i = 0 ; i < n / 2 ; i++){
            //     if(p.charAt(i) != p.charAt(n - i - 1)){
            //         return false;
            //     }
            // }

            // // System.out.println(p);

            // return true;
        }
    }
}
