/*
 * You are a stealthy archaeologist exploring a circular ring of ancient tombs 
located deep within a jungle. 
Each tomb holds a certain number of precious artifacts. 
However, these tombs are protected by an ancient magical curse: 
if you disturb two adjacent tombs during the same night,
the entire ring activates a trap that seals you in forever.

The tombs are arranged in a perfect circle, meaning the first tomb is adjacent to the last. 
You must plan your artifact retrieval carefully to maximize the number of artifacts 
collected in a single night without triggering the curse.

Given an integer array  artifacts  representing the number of artifacts in each tomb, 
return the   maximum   number of artifacts you can collect without disturbing 
any two adjacent tombs on the same night.

Sample Input-1:  
---------------
2 4 3

Sample Output-1:
----------------  
4   

Explanation:   You cannot loot tomb 1 (artifacts = 2) and tomb 3 (artifacts = 3), as they are adjacent in a circular setup.

Sample Input-2:
---------------
1 2 3 1

Sample Output-2:
----------------  
4

Explanation:   You can loot tomb 1 (1 artifact) and tomb 3 (3 artifacts) without breaking the ancient rule.  
Total = 1 + 3 = 4 artifacts.

Sample Input-3:
---------------
1 2 3

Sample Output-3:
----------------  
3 

Constraints:  
-  1 <= artifacts.length <= 100 
-  0 <= artifacts[i] <= 1000 
 */

import java.util.*;
class TombLoot{
    public static int helper(int[] arr,int start,int end,int[] dp){
        if(start>end){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int pick=arr[start]+helper(arr,start+2,end,dp);
        int not_pick=helper(arr,start+1,end,dp);
        return dp[start]=Math.max(pick,not_pick);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(" ");
        int[] a=new int[arr.length];
        for(int i=0;i<a.length;i++){
            a[i]=Integer.parseInt(arr[i]);
        }
        if(a.length==1){
            System.out.println(a[0]);
            return;
        }
        int n=a.length;
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        int[] dp2=new int[n];
        Arrays.fill(dp2,-1);
        int c1=helper(a,0,n-2,dp1);
        int c2=helper(a,1,n-1,dp2);
        System.out.println(Math.max(c1,c2));
        sc.close(); 
    }
}