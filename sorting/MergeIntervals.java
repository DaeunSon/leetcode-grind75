class Solution {
    public int[][] merge(int[][] intervals) {

        int[][] answer = new int[intervals.length][2];
        int pos=1;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        answer[0][0] = intervals[0][0];
        answer[0][1] = intervals[0][1];
        
        for(int i=1;i<intervals.length;i++) {
            
            if (answer[pos-1][1] >= intervals[i][0]) { //현재(i) 점이 누적된 값의 끝점보다 작거나 같을때 겹친다
                answer[pos-1][0] = Math.min(answer[pos-1][0], intervals[i][0]);
                answer[pos-1][1] = Math.max(answer[pos-1][1], intervals[i][1]);
            }
            else {
                answer[pos][0] = intervals[i][0];
                answer[pos][1] = intervals[i][1];
                pos++;
            }
        }

        return Arrays.copyOf(answer,pos);
    }
}
