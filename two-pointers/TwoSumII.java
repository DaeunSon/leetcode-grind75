class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //오름차순으로 정렬된 배열 -> 양끝에서 투포인터

        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left+1, right+1};
            else if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }

        return new int[]{left+1, right+1};
    }
}
