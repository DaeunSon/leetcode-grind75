class Solution {
    public int myAtoi(String s) {

        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        boolean isNegative = false;
        long answer = 0;
        int i =0;
         
        while(i < arr.length && arr[i] == ' ') {
            i++;
        }

        if (i<arr.length && (arr[i] == '-' || arr[i] == '+')) {
            if (arr[i] == '-') isNegative = true;
            i++;
        }

        while(i < arr.length && Character.isDigit(arr[i])) {
            answer = answer * 10 + arr[i] - '0';
            if (answer > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }

        if (isNegative) return (int) -answer;
        else return (int) answer;
    }
}
