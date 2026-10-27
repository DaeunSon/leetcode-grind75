class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            count[num]++; 
        }

        int pos=0;
        for(int i=0;i<count.length;i++) {
           for(int j=0;j<count[i];j++) {
                nums[pos++] = i;
           }
        }
    }
}
