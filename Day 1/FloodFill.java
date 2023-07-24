import java.util.* ;
import java.io.*; 


/*
psudocode :
 1) get that co-ordinate
 2) change its value
 3) apply dfs and change all its nbr value with the speific value
 4) convert that whole patch 
 5) return the new image 

*/
public class Solution {
    public static void dfs(int [][]image,int x,int y,int color,int currVal){
        image[x][y] = color;

        int row[] = {-1,0,+1,0}; // u,r,d,l
        int col[] ={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int newX = row[i]+x;
            int newY = col[i]+y;
            if((newX >=0 && newX < image.length)  && (newY >=0 && newY < image[0].length) && (image[newX][newY]==currVal)){
                dfs(image,newX,newY,color,currVal);
            }
        }

    }
    public static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
       
        int currVal = image[x][y];
        if(currVal == p) return image;
        dfs(image,x,y,p,currVal);
        return image;
    }
}