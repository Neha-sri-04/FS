package Day33;

/*
* Ibrahim is an interior designer wants to color wall of size M*N. 
He plans to color the wall and put lights of two different colors

The designer can lit the wall using M*N lights.The lights are Blue or pink
in color. Blue colored lights represented with digit-1 and pink colored lights 
represented with digit-0.

The Blue colored lights forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
count the unique shapes formed by blue colored lights.

You will be given the decorated wall as a matrix wall[][].
Your task is to help Ibrahim to count the unique shapes by the lights.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by Blue Lights.


Sample Input-1:
---------------
4 5
1 1 0 1 1
1 1 0 0 1
0 0 0 0 0
1 1 0 0 0

Sample Output-1:
----------------
3


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

 */

 import java.util.*;

 class Solution 
 {    
     private static final int[] dRow = {-1, 1, 0, 0};
     private static final int[] dCol = {0, 0, -1, 1};
     
     private class DisjointSet 
     {
         private int[] parent;
         private int[] size;
         
         public DisjointSet(int V) 
         {
             parent = new int[V];
             size = new int[V];
             for (int i=0; i<V; i++) {
                 size[i] = 1;
                 parent[i] = i;
             }
         }
         
         public int find(int u) {
             return parent[u] == u ? u : (parent[u] = find(parent[u]));
         }
         
         public void union(int u, int v) 
         {
             int p1 = find(u);
             int p2 = find(v);
             if (p1 == p2) 
                 return;
 
             if (size[p1] < size[p2]) 
             {
                 parent[p1] = p2;
                 size[p2] += size[p1];
             } else {
                 parent[p2] = p1;
                 size[p1] += size[p2];
             }
         }
     }
     
     public int numDistinctIslands(int[][] grid) 
     {
         //Write your code here and return an integer, number of distinct shapes formed
         int m = grid.length;
         int n = grid[0].length;
         DisjointSet ds = new DisjointSet(m * n);
         for (int i = 0; i < m; i++){
             for (int j = 0; j < n; j++){
                 if (grid[i][j] == 1){
                     for (int d = 0; d < 4; d++){
                         int ni = i + dRow[d];
                         int nj = j + dCol[d];
                         if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1){
                             int cell1 = i * n + j;
                             int cell2 = ni * n + nj;
                             ds.union(cell1, cell2);
                         }
                     }
                 }
             }
         }
         Set<String> uniqueIslands = new HashSet<>();
         Map<Integer, List<int[]>> islandCells = new HashMap<>();
         for (int i = 0; i < m; i++){
             for (int j = 0; j < n; j++){
                 if (grid[i][j] == 1){
                     int root = ds.find(i * n + j);
                     islandCells.putIfAbsent(root, new ArrayList<>());
                     islandCells.get(root).add(new int[]{i, j});
                 }
             }
         }
         for (Map.Entry<Integer, List<int[]>> entry : islandCells.entrySet()){
             List<int[]> cells = entry.getValue();
             List<int[]> normalizedShape = new ArrayList<>();
             int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
             for (int[] cell : cells){
                 minX = Math.min(minX, cell[0]);
                 minY = Math.min(minY, cell[1]);
             }
             for (int[] cell : cells){
                 normalizedShape.add(new int[]{cell[0] - minX, cell[1] - minY});
             }
             Set<String> shapeSet = new HashSet<>();
             for (int[] coord : normalizedShape){
                 shapeSet.add(coord[0] + "," + coord[1]);
             }
             uniqueIslands.add(shapeSet.toString());
         }
         return uniqueIslands.size();
     }
 }
 
 public class DistinctIslands
 {
     public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         int m=sc.nextInt();
         int n=sc.nextInt();
         int grid[][]=new int[m][n];
         for(int i=0;i<m;i++)
             for(int j=0;j<n;j++)
                 grid[i][j]=sc.nextInt();
                 
         System.out.println(new Solution().numDistinctIslands(grid));
         sc.close();
     }
 }
