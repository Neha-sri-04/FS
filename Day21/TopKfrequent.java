package Day21;
/*
 * You are given an integer array containing numbers, and an integer k. 
Your task is to return the k most frequent elements in the array.

If multiple elements have the same frequency, the element with the higher value should be prioritized.
The output should be printed in descending order of frequency.

Input Format:
-------------
Line-1: An integer N, representing the number of elements in the array.
Line-2: A line with N space-separated integers representing the elements of the array.
Line-3: An integer k, representing the number of most frequent elements to return.

Output Format:
--------------
Line-1: An array, comma-separated integers in descending order of frequency. 
If two elements have the same frequency, the higher number should appear first.


Sample Input-1:
--------------
6
1 1 1 2 2 3
2

Sample Output-1:
----------------
[1, 2]


Sample Input-2:
--------------
1
1
1

Sample Output-2:
----------------
[1]
 */
import java.util.*;
class TopKfrequent{
    public static String frequencies(int[] arr,int n,int k){
        Map<Integer,Integer> m=new HashMap<>();
        int[] freq=new int[k];
        for(int i=0;i<n;i++){
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
        }
        int[][] arr2=new int[m.size()][2];
        int index=0;
        for(Map.Entry<Integer,Integer> e:m.entrySet()){
            arr2[index][0]=e.getKey();
            arr2[index][1]=e.getValue();
            index++;
        }
        Arrays.sort(arr2,(a,b)->(b[1]==a[1])?b[0]-a[0]:b[1]-a[1]);
        for(int i=0;i<k;i++){
            freq[i]=arr2[i][0];
        }
        return Arrays.toString(freq);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(frequencies(arr,n,k));
        sc.close();
    }
}