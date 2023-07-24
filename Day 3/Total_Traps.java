public class Solution {
    public static boolean isBoundary(int i, int j, int n, int m) {
        return i == 0 || i == n - 1 || j == 0 || j == m - 1;
    }

    public static void dfs(int matrix[][], int i, int j) {
        matrix[i][j] = 2; // Mark cell as visited
        int row[] = {-1, 0, +1, 0};
        int col[] = {0, +1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int newI = i + row[k];
            int newJ = j + col[k];
            if ((newI >= 0 && newI < matrix.length) && (newJ >= 0 && newJ < matrix[0].length) && (matrix[newI][newJ] == 0)) {
                dfs(matrix, newI, newJ);
            }
        }
    }

    public static int matrixTraps(int n, int m, int[][] Matrix) {

        // First, mark cells that are connected to the boundary
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isBoundary(i, j, n, m) && Matrix[i][j] == 0) {
                    dfs(Matrix, i, j);
                }
            }
        }

        // Count trapped cells (cells with value 0)
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Matrix[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
