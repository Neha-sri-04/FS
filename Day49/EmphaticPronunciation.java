/*
 * "Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
goood
good goodd

Sample Output-1:
----------------
1


Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2

 */

 import java.util.*;
class EmphaticPronunciation{
    public static boolean helper(String s,String e){
        int i=0,j=0;
        while(i<s.length() && j<e.length()){
            if(s.charAt(i)!=e.charAt(j)){
                return false;
            }
            int ec=0,sc=0;
            char echar=e.charAt(j);
            char schar=s.charAt(i);
            while(i<s.length() && s.charAt(i)==schar){
                sc++;
                i++;
            }
            while(j<e.length() && e.charAt(j)==echar){
                ec++;
                j++;
            }
            if((ec<3 && sc!=ec) || (ec>=3 && sc>ec)){
                return false;
            }
        }
        return i==s.length() && j==e.length();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String line=sc.nextLine();
        String[] arr=line.split(" ");
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(helper(arr[i],s)){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}