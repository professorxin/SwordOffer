package Offer66;

public class Solution {
    /*题目描述
    地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能
    进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，
    它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？*/

    //四个方位
    private static final int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows;
    private int cols;
    private int cnt = 0;
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        boolean[][] visited = new boolean[rows][cols];
        initDigitSum();
        dfs(threshold, 0, 0, visited);
        return cnt;
    }

    private void dfs(int threshold, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c]) return;
        visited[r][c] = true;
        if (threshold < digitSum[r][c]) return;
        cnt++;
        for (int[] n : next)
            dfs(threshold, r + n[0], c + n[1], visited);
    }

    //把每一个格子的数位之和都计算出来
    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int m = i;
            while (m > 0) {
                digitSumOne[i] += m % 10;
                m /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }
}
