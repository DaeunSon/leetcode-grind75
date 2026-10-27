class Solution {
    public boolean isAnagram(String s, String t) {
        
        //s, t를 모두 알파벳순으로 정렬
        char[] s_array = new char[s.length()];
        char[] t_array = new char[t.length()];

        s_array = s.toCharArray();
        t_array = t.toCharArray();

        if (s_array.length != t_array.length) return false;

        Arrays.sort(s_array);
        Arrays.sort(t_array);

        for(int i=0;i<s_array.length;i++) {
            if (s_array[i] != t_array[i]) return false;
        }
        return true;
    }
}
