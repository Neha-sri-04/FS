package Day29;
/*
 * An 8th standard student has been assigned a task as part of punishment for his mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
kmec ngit colleges

Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17

 */
import java.util.*;
class Solution{
    public int[][] indexPairs(String text,String[] words){
        Trie trie=new Trie();
        for(String s:words){
            Trie curr=trie;
            for(char c:s.toCharArray()){
                if(curr.children[c-'a']==null){
                    curr.children[c-'a']=new Trie();
                }
                curr=curr.children[c-'a'];
            }
            curr.end=true;
        }
        int len=text.length();
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<len;i++){
            Trie curr=trie;
            char cc=text.charAt(i);
            int j=i;
            while(curr.children[cc-'a']!=null){
                curr=curr.children[cc-'a'];
                if(curr.end){
                    list.add(new int[]{i,j});
                }
                j++;
                if(j==len){
                    break;
                }
                else{
                    cc=text.charAt(j);  
                }
            }
        }
        int[][] res=new int[list.size()][2];
        int i=0;
        for(int[] a:list){
            res[i]=a;
            i++;
        }
        return res;
    }
}
class Trie{
    Trie[] children;
    boolean end;
    public Trie(){
        end=false;  
        children=new Trie[26];
    }
}
public class IndexPairs{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[] words=sc.nextLine().split(" ");
        int[][] res=new Solution().indexPairs(text,words);
        for(int[] arr:res){
            System.out.println(arr[0]+" "+arr[1]);
        }
        sc.close();
    }
}