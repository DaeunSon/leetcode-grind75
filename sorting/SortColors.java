class Solution {
    public void sortColors(int[] nums) {
        //0-red, 1-white, 2-blue
        //같은 색의 objects가 인접

        HashMap<Integer, Integer> map = new HashMap<>();
        int pos=0;

        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer i : map.keySet()) {
            if (i==0) {
                for(int j=0;j<map.get(i);j++) {
                    nums[pos++]=0;
                }
            }

            else if (i==1) {
                for(int j=0;j<map.get(i);j++) {
                    nums[pos++]=1;
                }
            }

            else {
                for(int j=0;j<map.get(i);j++) {
                    nums[pos++]=2;
                }
            }
        }
    }
}
