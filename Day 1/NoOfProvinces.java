class Solution {
    public void dfs( ArrayList<ArrayList<Integer>> graph,int src ,boolean vis[]){
        vis[src] = true;
        for(int nbr : graph.get(src)){
            if(!vis[nbr]) dfs(graph,nbr,vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // create a graph which indicates which cities are connected to which 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        // graph created
        boolean vis[] = new boolean[n];
        int cnt =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(graph,i,vis);
                cnt++;
            }
        }
        return cnt;
    }
}