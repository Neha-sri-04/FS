package Day13;
/*
 * Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.

Input Format:
-------------
Line-1: An integer N
Line-2: N space seperated integers

Output Format:
--------------
Line-1: A list of integers

Sample Input-1:
---------------
5
-4 -1 0 3 10

Sample Output-1: 
----------------
[0, 1, 9, 16, 100]

 */

 import java.util.*;
 class squares{
     public static String square(int n,int[] arr){
         int left=0;
         int right=n-1;
         int[] arr1=new int[n];
         int num=n-1;
         while(left<=right){
             if(Math.abs(arr[left])<Math.abs(arr[right])){
                 arr1[num]=arr[right]*arr[right];
                 right--;
                 num--;
             }
             else{
                 arr1[num]=arr[left]*arr[left];
                 left++;
                 num--;
                 
             }
         }
         return Arrays.toString(arr1);
     }
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int[] arr=new int[n];
         for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();
         }
         System.out.println(square(n,arr));
         sc.close();
     }
 }
 
