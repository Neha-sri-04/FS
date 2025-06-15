package Day41;
/*
 * A secret agent receives a list of encrypted codewords. 
Each codeword must follow the same symbol sequence as a given prototype code. 
Your mission is to find which codewords follow the same symbol arrangement.

NOTE:
Matching is not about the actual characters, but how they repeat.
For example, “moon” = m o o n → pattern: first letter, two repeated letters, and a unique last letter.

Input Format:
-------------
Line-1: A space-separated list of words 
Line-2: A string representing the reference pattern

Output Format:
---------------------
Line-1: A list of words that follow the same pattern, if not found print -1


Sample Input-1:
---------------
Leet abcd loot geek cool for peer dear seed meet noon mess loss
moon

Sample Output-1:
----------------
leet loot geek cool peer seed meet


Sample Input-2:
----------------
leet abcd loot geek cool for peer dear
lamp

Sample Output-2:
----------------
abcd dear

 */

import java.util.*;
class Main{
    public static boolean helper(String s,String p){
        if(s.length()!=p.length()){
            return false;
        }
        Map<Character,Character> m1=new HashMap<>();
        Map<Character,Character> m2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=p.charAt(i);
            if(m1.containsKey(ch1)){
                char ch=m1.get(ch1);
                if(ch!=ch2){
                    return false;
                }
            }
            else{
                m1.put(ch1,ch2);
            }
            if(m2.containsKey(ch2)){
                char ch=m2.get(ch2);
                if(ch!=ch1){
                    return false;
                }
            }
            else{
                m2.put(ch2,ch1);
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(" ");
        String pattern=sc.nextLine();
        List<String> l=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(helper(arr[i],pattern)){
                l.add(arr[i]);
            }
        }
        if(l.isEmpty()){
            System.out.println(-1);
        }
        else{
            for(int i=0;i<l.size();i++){
                System.out.print(l.get(i)+" ");
            }
        }
        sc.close();
    }
}
