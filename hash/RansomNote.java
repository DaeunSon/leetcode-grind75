import java.util.*;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //magazine의 글자로 ransomNote를 구성할수 있는지 반환
        //hashmap
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<magazine.length();i++) {
            Character c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i=0;i<ransomNote.length();i++) {
            Character c = ransomNote.charAt(i);
            if (map.getOrDefault(c, 0)==0) {
                return false;
            }
            map.put(c, map.getOrDefault(c,0)-1);
        }

        return true;
    }
}
