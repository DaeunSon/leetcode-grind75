class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //DFS로 start좌표부터 모든 인접한 좌표를 훑기
        if (image[sr][sc] == color) return image;
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    void fill(int[][] image, int r, int c, int color, int original) {
        //재귀함수
        //termination
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != original) return;
        image[r][c] = color;
        fill(image, r - 1, c, color, original);
        fill(image, r + 1, c, color, original);
        fill(image, r, c - 1, color, original);
        fill(image, r, c + 1, color, original);
    }
}
