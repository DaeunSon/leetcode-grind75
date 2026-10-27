class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int pos = 0;

        while(pos < intervals.length && intervals[pos][1] < newInterval[0]) {
            result.add(intervals[pos]);
            pos++;
        }

        while(pos < intervals.length && newInterval[1] >= intervals[pos][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[pos][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[pos][1]);
            pos++;
        }

        result.add(newInterval);

        while(pos < intervals.length) {
            result.add(intervals[pos]);
            pos++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
