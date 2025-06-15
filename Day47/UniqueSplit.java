package Day47;
/*
 * Captain Raynor is on a mission to decode an alien transmission.
The transmission contains a single long string S, and it is believed to be 
made up of multiple unique signal chunks, sent one after another with no spaces.

Your task is to help Captain Raynor split the transmission into the maximum 
number of non-empty, unique signal chunks such that when all chunks are 
concatenated in order, they exactly recreate the original transmission S.

Your goal is to maximize the number of unique chunks the message can be split into.

Input Format:
--------------
Line-1: A string S representing the alien transmission.

Output Format:
---------------
Line-1: Print a single integer – the maximum number of distinct chunks the string can be split into.

Sample Input-1:
---------------
banana

Sample Output-1:
----------------
4

Explanation: 
------------
One valid way to split the string is: "b", "a", "n", "ana".
This keeps all chunks unique.
Another way like "b", "a", "n", "an", "a" is invalid because "a" appears twice.


Sample Input-2:
---------------
mississippi

Sample Output-2:
----------------
7

Explanation: 
------------
One valid way to split it is: "m", "i", "s", "si", "ssi", "p", "pi".
All chunks are distinct and together recreate the original transmission.

NOTE: Only contiguous chunks (i.e., substrings) are allowed. Subsequence-based 
      splitting is not permitted.
 */

import java.util.*;
class UniqueSplit{
    static int count=0;
    public static void helper(String s,int index,List<String> h){
        if(index==s.length()){
            count=Math.max(count,h.size());
            return;
        }
        for(int i=index+1;i<=s.length();i++){
            if(!h.contains(s.substring(index,i))){
                h.add(s.substring(index,i));
                helper(s,i,h);
                h.remove(h.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        List<String> h=new ArrayList<>();
        helper(s,0,h);
        System.out.println(count);
        sc.close();
    }
}
