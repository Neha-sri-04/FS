/*
 * In the ancient land of Palindoria, wizards write magical spells as strings of lowercase letters.
However, for a spell to be effective, each segment of the spell must read the same forward and backward.

Given a magical spell 'spell', your task is to partition it into sequences of valid magical spell segments. 

Your goal is to help the wizard discover all valid combinations of magical spell segmentations.

Sample Input-1:
---------------
aab
  
Sample Output-1:  
----------------
[[a, a, b], [aa, b]]

Sample Input-2:
--------------- 
a
  
Sample Output-2:  
----------------
[[a]]

Spell Constraints:
------------------
- The length of the spell is between 1 and 16 characters.  
- The spell contains only lowercase English letters.  
 
 */

import java.util.*;
class MagicalSpell{
    public static void helper(String s,List<List<String>> res,int index,List<String> l){
        if(index==s.length()){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=index+1;i<=s.length();i++){
            String temp=s.substring(index,i);
            if(palindrome(temp)){
                l.add(temp);
                helper(s,res,i,l);
                l.remove(l.size()-1);
            }
        }
    }
    public static boolean palindrome(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        List<List<String>> res=new ArrayList<>();
        helper(s,res,0,new ArrayList<>());
        System.out.println(res);
        sc.close();
    }
}