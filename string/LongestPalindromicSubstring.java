import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        //s에서 가장 긴 palindromic substring를 반환
        int left;
        int right; 
        int maxLen = 0;
        int start = 0;

        for(int i=0;i<s.length();i++) {
            int odd = isPalindromic(i, i, s);
            int even = isPalindromic(i, i+1, s);
            int len = Math.max(odd, even);

            if (len > maxLen) {
                maxLen=len;
                start=i-(len-1)/2;
                //i-len길이의절반
            }
        }
        return s.substring(start, start+maxLen);
        
        }
        public int isPalindromic(int left, int right, String s) {
            while (left>=0 && right<=s.length()-1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right-left-1;
        }
    }
