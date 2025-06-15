package Day48;
/*
 * You are given a crystal with an energy level n. Your goal is to discover all the different ways this crystal could have been created by combining smaller shards.

Each combination must:
- Use only shards with energy values between 2 and n - 1.
- Be represented as a list of shard values whose product equals n.
- Use any number of shards (minimum 2), and the order is ascending order.

Your task is to return all unique shard combinations that can multiply together to recreate the original crystal.

Input Format:
-------------
Line-1: An integer

Output Format:
--------------
Line-1: List of all unique shard combinations

Sample Input-1:
---------------
28

Sample Output-1:
----------------
[[2, 14], [2, 2, 7], [4, 7]]

Sample Input-2:
---------------
23

Sample Output-2:
----------------
[]


Constraints:
- 1 <= n <= 10^4
- Only shards with energy between 2 and n - 1 can be used.

 */

import java.util.*;
class ShardCombinations{
    public static void helper(int target,List<List<Integer>> res,List<Integer> l,int start){
        if(target==1){
            if(l.size()>1){
                res.add(new ArrayList<>(l));
            }
            return;
        }
        for(int i=start;i<=target;i++){
            if(target%i==0){
                l.add(i);
                helper(target/i,res,l,i);
                l.remove(l.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>> l=new ArrayList<>();
        helper(n,l,new ArrayList<>(),2);
        System.out.println(l);
        sc.close();
    }
}