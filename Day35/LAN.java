/*
 * In your computer lab, network switches are connected using Ethernet cables to form a LAN. 
However, a new hardware technician inadvertently connected switches in a way that created a cycle,
resulting in a network loop. 
As a consequence, the network has become unstable. You need to identify and remove the specific cable that 
is causing the loop. 
If there are multiple cables contributing to the loop, you should remove the one that was most recently added

Sample Input-1:
---------------
3
0 1
0 2
1 2

Sample Output-1:
----------------
[1 2]

Sample Input-2:
---------------
5
0 1
1 2
2 3
0 3
0 4

Sample Output-2:
----------------
[0,3]
 

Constraints:
------------
-> n == edges.length
-> 3 <= n <= 1000
-> edges[i].length == 2
-> 1 <= ai < bi <= edges.length
-> ai != bi
-> There are no repeated edges.
-> The given graph is connected.
 */

 import java.util.*;
 class LAN{
     int[] parent;
     LAN(int n){
         parent=new int[n];
         for(int i=0;i<n;i++){
             parent[i]=i;
         }
     }
     public int find(int index){
         if(parent[index]==index){
             return index;
         }
         return parent[index]=find(parent[index]);
     }
     public void union(int i,int j){
         int p1=find(i);
         int p2=find(j);
         parent[p2]=p1;
     }
     public int[] help(int[][] edges,int n){
         for(int[] edge:edges){
             int e1=edge[0];
             int e2=edge[1];
             int p1=find(e1);
             int p2=find(e2);
             if(p1==p2){
                 return edge;
             }
             union(e1,e2);
         }
         return new int[0];
     }
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int[][] edges=new int[n][2];
         for(int i=0;i<n;i++){
             for(int j=0;j<2;j++){
                 edges[i][j]=sc.nextInt();
             }
         }
         LAN l=new LAN(n);
         int[] res=l.help(edges,n);
         System.out.println(Arrays.toString(res));
         sc.close();
     }
 }