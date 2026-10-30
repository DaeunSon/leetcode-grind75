class Solution {
    public boolean isPalindrome(String s) {

        char[] arr = new char[s.length()];
        int pos = 0;
        s = s.toLowerCase();

        for(int i=0;i<s.length();i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                arr[pos++] = s.charAt(i);
            }
        }

        int left = 0;
        int right = pos-1;

        while(left < right) {
            if (arr[left]!=arr[right]) return false;
            else {
                left++;
                right--;
            }
        }

        return true;
    }
}
