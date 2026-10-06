import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> window = new HashSet<>();
        int left = 0;
        int max = 0;

        for(int right=0; right<s.length(); right++) {
            while(window.contains(s.charAt(right))) { //중복이면
                window.remove(s.charAt(left));
                left++; //중복된 개수
            }
            window.add(s.charAt(right));
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
