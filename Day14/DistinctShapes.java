/*
 * Viraj Aanand is a wedding planner, He ordered his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


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
 class DistinctShapes{
     static int baseRow,baseCol;
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
         Set<String> h=new HashSet<>();
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(arr[i][j]==1){
                     baseRow=i;
                     baseCol=j;
                     arr[i][j]=0;
                     StringBuilder s=new StringBuilder();
                     bfs(i,j,s,arr);
                     h.add(s.toString());
                 }
             }
         }
         System.out.println(h.size());
         sc.close();
     }
     public static void bfs(int i,int j,StringBuilder s,int[][] arr){
         Queue<int[]> q=new LinkedList<>();
         q.offer(new int[]{i,j});
         
         int[] dx={-1,0,1,0};
         int[] dy={0,-1,0,1};
         while(!q.isEmpty()){
             int[] current=q.poll();
             s.append(baseRow-current[0]);
             s.append(baseCol-current[1]);
             for(int dir=0;dir<4;dir++){
                 int newi=current[0]+dx[dir];
                 int newj=current[1]+dy[dir];
                 if(newi>=0 && newi<arr.length && newj>=0 && newj<arr[0].length && arr[newi][newj]==1){
                     q.offer(new int[]{newi,newj});
                     arr[newi][newj]=0;
                 }
             }
         }
     }
 }