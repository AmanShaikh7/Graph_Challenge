class Solution {
    class Helper{
        int row;
        int col;
        int dist;
        Helper(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Helper> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        int ans[][] = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    q.add(new Helper(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int row [] = {-1,0,+1,0};
        int col[] = {0,+1,0,-1};
        // now just apply the bfs 
        while(q.size()!=0){
            Helper removed = q.remove();
            ans[removed.row][removed.col] = removed.dist;
            // look for its childs
           
            for(int i=0;i<4;i++){
                int newR = removed.row + row[i];
                int newC = removed.col + col[i];
                if((newR >=0 && newR <n) && (newC >=0 && newC <m) && (mat[newR][newC]==0) && (vis[newR][newC]==false) ){
                    q.add(new Helper(newR,newC,(removed.dist+1)));
                }
            }

        }
        return ans;
    }
}