class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(max, area);
            if (height[right] > height[left]) left++;
            else right--;
        }

        return max;
    }
}
