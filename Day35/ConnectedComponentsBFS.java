/*
 * There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 */

 import java.util.*;
 class ConnectedComponentsBFS {
     public int countComponents(int n, int[][] edges) {
         //Write your code here and return an integer
         List<List<Integer>> adj=new ArrayList<>();
         for(int i=0;i<n;i++){
             adj.add(new ArrayList<>());
         }
         for(int[] edge:edges){
             int e1=edge[0];
             int e2=edge[1];
             adj.get(e1).add(e2);
             adj.get(e2).add(e1);
         }
         boolean[] visit=new boolean[n];
         int comp=0;
         for(int i=0;i<n;i++){
             if(!visit[i]){
                 bfs(i,visit,adj);
                 comp++;
             }
         }
         return comp;
     }    
    //Any supporting functinalities, write here
    public void bfs(int index,boolean[] visit,List<List<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        q.add(index);
        visit[index]=true;
        while(!q.isEmpty()){
            int num=q.poll();
            for(int i:adj.get(num)){
                if(!visit[i]){
                    visit[i]=true;
                    q.add(i);
                }
            }
        }
    }
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int e = sc.nextInt();
         int[][] edges = new int[e][2];        
         for (int i = 0; i < e; i++) {
             for (int j = 0; j < 2; j++) {
                 edges[i][j] = sc.nextInt();
             }
         }        
         int result = new ConnectedComponentsBFS().countComponents(n, edges);
         System.out.println(result);
         sc.close();
     }
 }
 