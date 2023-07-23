class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j] && (j == 0 || j == m - 1 || i == 0 || i == n - 1)) {
                    dfs(board, vis, i, j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(char[][] board, boolean[][] vis, int i, int j) {
        vis[i][j] = true;
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int newI = i + row[k];
            int newJ = j + col[k];

            if ((newI >= 0 && newI < board.length) && (newJ >= 0 && newJ < board[0].length) && (board[newI][newJ] == 'O' && !vis[newI][newJ])) {
                dfs(board, vis, newI, newJ);
            }
        }
    }
}
