import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        
        int maxlen = 0;
        int start=0;

        for(int center=0;center<s.length();center++) {
            int odd = expand(s, center, center);
            int even = expand(s, center, center+1);
            int len = Math.max(odd, even);

            if (len > maxlen) {
                maxlen = len;
                start = center - (len -1)/ 2;
            }
        }
        return s.substring(start, start+maxlen);
    }

    public int expand(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
