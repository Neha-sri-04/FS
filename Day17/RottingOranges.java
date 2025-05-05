/*
 * You are given an m x n grid where each cell can have one of three values:
-> 0 representing an empty cell,
-> 1 representing a fresh orange, or
-> 2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1.


Input Format:
-------------
Line-1: Two integers, m and n, represents grid[] sizes
Line-2 to m: n Space separated integers, represents grid[i][j]

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation: 
-------------
The orange in the bottom left corner (row 2, column 0) is never rotten, 
because rotting only happens 4-directionally.

Sample Input-3:
---------------
1 1
0 2

Sample Output-3:
----------------
0

Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
------------
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */

 import java.util.*;
 class RottingOranges{
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int m=sc.nextInt();
         int n=sc.nextInt();
         int[][] arr=new int[m][n];
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 arr[i][j]=sc.nextInt();
             }
         }
         System.out.println(bfs(arr));
         sc.close();
     }
     public static int bfs(int[][] arr){
         Queue<int[]> q=new LinkedList<>();
         int fresh=0;
         for(int i=0;i<arr.length;i++){
             for(int j=0;j<arr[0].length;j++){
                 if(arr[i][j]==2){
                     q.offer(new int[]{i,j});
                 }
                 else if(arr[i][j]==1){
                     fresh++;
                 }
             }
         }
         if(fresh==0){
             return 0;
         }
         int[] dx={-1,0,1,0};
         int[] dy={0,-1,0,1};
         int count=0;
         while(!q.isEmpty()){
             int n=q.size();
             count++;
             for(int k=0;k<n;k++){
                 int[] curr=q.poll();
                 for(int p=0;p<4;p++){
                     int newi=curr[0]+dx[p];
                     int newj=curr[1]+dy[p];
                     if(newi>=0 && newi<arr.length && newj>=0 && newj<arr[0].length && arr[newi][newj]==1){
                         arr[newi][newj]=2;
                         q.offer(new int[]{newi,newj});
                         fresh--;
                     }
                 }
             }
         }
         if(fresh==0){
             return count-1;
         }
         else{
             return -1;
        }
    }
}