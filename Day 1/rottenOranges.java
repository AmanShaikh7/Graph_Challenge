class Solution {
    class Pair{
        int row;
        int col;
        Pair(int r,int c){
            row = r ;
            col = c;
        }

    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> que = new ArrayDeque<>();
        //this queue will store the starting indexs of every rotten oranges 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==2){ // if it is an rotten orange add it to the  queue
                    que.add(new Pair(i,j));
                }
            }
        }
        int time = 0;
        while(que.size()>0){
            int size = que.size();
            while(size!=0){
                Pair rnode = que.remove(); 
                // removed the first parent and add its child
                int cr = rnode.row;
                int cc = rnode.col;
                //check for upper element
                if(cr-1>=0 && grid[cr-1][cc]==1){
                    grid[cr-1][cc]=2;
                    que.add(new Pair(cr-1,cc));
                }
                //check for lower element
                if(cr+1<n && grid[cr+1][cc]==1){
                    grid[cr+1][cc]=2;
                    que.add(new Pair(cr+1,cc));
                }
                //check for left element 
                if(cc-1>=0 && grid[cr][cc-1]==1){
                    grid[cr][cc-1]=2;
                    que.add(new Pair(cr,cc-1));
                }
                //check for right element 
                if(cc+1<m && grid[cr][cc+1]==1){
                    grid[cr][cc+1]=2;
                    que.add(new Pair(cr,cc+1));
                }

                size--;  // one parent added its all child completely 

            }
            time ++; // all parent of same priority done adding 
        }

        // if any orange is still fresh
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==1){ 
                    return -1;
                }
            }
        }
        if(time ==0){ // no oranges in grid
            return time; 
        }
        return time-1;

    }
}