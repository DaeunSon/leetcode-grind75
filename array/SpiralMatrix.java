class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> answer = new ArrayList<>();

        int row = matrix.length; //행
        int col = matrix[0].length; //열 
        
        int top = 0;//아직 안 읽은 가장 위 행, ++
        int bottom = row-1;//아직 안 읽은 가장 아래 행, --
        int left = 0;//아직 안 읽은 가장 왼쪽 열, ++
        int right = col-1;//아직 안 읽은 가장 오른쪽 열, --
        
        while(top <= bottom && left <= right) {
            //윗줄 +
            for(int i=left;i<=right;i++) {
                answer.add(matrix[top][i]);
            }
            top++;
            //아래로 
            for(int i=top;i<=bottom;i++) {
                answer.add(matrix[i][right]);
            }
            right--;
            //왼쪽으로, 맨 아래행이 있을때
            if (top<=bottom) {
                for(int i=right;i>=left;i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //위로, 남은 열이 있을때
            if (left <= right) {
                for(int i=bottom;i>=top;i--){
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }
    
        return answer;
    }
}
