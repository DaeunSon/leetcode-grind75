class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int sum = 0;

        for(int i=0;i<k;i++) {
            sum += nums[i];
        }

        int best = sum;

        for(int right=k;right<nums.length;right++) {
            sum += nums[right] - nums[right-k];
            best = Math.max(best, sum);
        }

        return (double)best/k;
    }
}
