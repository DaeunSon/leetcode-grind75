class Solution {
    public int longestPalindrome(String s) {

        if (s.length()==1) return 1;
    
        int answer=0;

        //a -1, b-1, c-4, d-2 각 원소를 hash에 저장하고 abc abbc
        //2개 이상인 원소는 짝수개로 최대한 사용하기, 1개만 있으면 1개만 사용하기

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        int flag = 0;
        
        for(Integer t : map.values()) {
            if (t%2==0) {
                answer += t;
            }
            else {
                answer += t-1; //짝수개만큼 사용
                flag = 1;
            }
        }
        

        return answer + flag;
    }

}
