package Day44;
/*
 * A text editor application allows users to perform automated corrections in documents. 
The feature scans the document and replaces every distinct instance of a specified incorrect phrase with a corrected one.
However, to avoid infinite loops and ambiguity, the editor replaces only non-overlapping occurrences of the phrase from left to right, one at a time.

Input Format:
-------------------------  
Line-1: A string `S` representing the original word
Line-2: A string `P` representing the pattern to be replaced
Line-3: A string `R` representing the replacement phrase (Special character) 

Output Format:
-------------------------
A string with all non-overlapping occurrences of `P` in `S` replaced with `R`

Example
--------
Input:
word = "ABCABCXABC";
pattern = "ABC";
ch = '@';
Explanation:
Original string:  A B C A B C X A B C
                  [ABC] [ABC]   [ABC] → all 3 are non-overlapping
Output:@ @ X @

Sample Input:
-------------------- 
ABABABAB
AB
@
Sample Output:
-----------------------
@@@@

 */

import java.util.*;
class Main{
    public static String helper(String word,String pattern,String ch){
        if(pattern.isEmpty()){
            return word;
        }
        int index=0;
        StringBuilder temp=new StringBuilder();
        while(index<word.length()){
            int ind=word.indexOf(pattern,index);
            if(ind==-1){
                temp.append(word.substring(index));
                break;
            }
            else{
                temp.append(word.substring(index,ind));
                temp.append(ch);
                index=ind+pattern.length();
            }
        }
        return temp.toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        String pattern=sc.nextLine();
        String ch=sc.nextLine();
        System.out.println(helper(word,pattern,ch));
    }
}
