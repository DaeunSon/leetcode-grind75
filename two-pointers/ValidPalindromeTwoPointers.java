class Solution {
    public boolean isPalindrome(String s) {
        //모두 소문자로 변환하고 알파벳이 아니면 제거했을때 앞, 뒤로 읽어도 동일한

        int right = s.length()-1;
        int left = 0;
        s = s.toLowerCase();

        while(right > left) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
