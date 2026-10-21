class Solution {
    public boolean isPalindrome(String s) {
        //모두 소문자로 변환하고 알파벳이 아니면 제거했을때 앞, 뒤로 읽어도 동일한

        String toLower = s.toLowerCase();
        char[] arr = new char[toLower.length()];
        int pos=0;

        for(int i=0;i<toLower.length();i++) {
            if (toLower.charAt(i) >= 'a' && toLower.charAt(i) <= 'z') {
                arr[pos++] = toLower.charAt(i);
            }
            else if (toLower.charAt(i)>='0' && toLower.charAt(i)<='9') {
                arr[pos++] = toLower.charAt(i);
            }
        }

        for(int i=0;i<pos;i++){
            System.out.println(arr[i]);
        }

        if (pos==1) return true;
        
        int left = 0;
        int right = pos-1;
        
        while(right > left) {
            if (arr[left] != arr[right]) {
                return false;
            }
            right--;
            left++;
        }

        return true;
    }
}
