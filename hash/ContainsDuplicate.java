class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        //2개 이상인 원소가 있으면 true

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if (map.get(nums[i]) >= 2) return true;
        }
        return false;
    }
}
