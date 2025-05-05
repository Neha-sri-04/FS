/*A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Sample Input-1:
---------------
xyzzaz

Sample Output-1:
----------------
1

Explanation: 
------------
There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Sample Input-2:
---------------
aababcabc

Sample Output-2:
----------------
4

Explanation: 
------------
There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".*/

import java.util.*;
class GoodStrings{
    public static int helper(char[] arr,int n){
        Map<Character,Integer> h=new HashMap<>();
        int count=0;
        for(int i=0;i<3;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        if(h.size()==3){
            count++;
        }
        int k=3;
        for(int i=k;i<n;i++){
            int x=h.get(arr[i-k]);
            if(x==1){
                h.remove(arr[i-k]);
            }
            else{
                h.put(arr[i-k],x-1);
            }
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
            if(h.size()==3){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char[] arr=s.toCharArray();
        System.out.println(helper(arr,arr.length));
        sc.close();
    }
}
