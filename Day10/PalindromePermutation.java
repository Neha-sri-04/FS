package Day10;
/* AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false
 */

 import java.util.*;
class PalindromePermutation{
    public static boolean help(String s){
        int bitmask=0;
        for(int i=0;i<s.length();i++){
            int ascii=s.charAt(i)-'a';
            bitmask^=1<<ascii;
        }
        if(bitmask==0){
            return true;
        }
        else{
            int mask=bitmask&(bitmask-1);
            if(mask==0){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(help(s));
        sc.close();
    }
}