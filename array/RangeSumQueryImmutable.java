class NumArray {
    // 누적합: prefix[i] = 앞에서부터 i개를 더한 값 (prefix[0] = 0)
    private int[] prefix;

    public NumArray(int[] nums) {
        // 생성자에서 한 번만 만든다: O(n)
        prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // nums[0..right] 합 - nums[0..left-1] 합: O(1)
        return prefix[right + 1] - prefix[left];
    }
}
