'''
You're playing a number card game.
You have a bunch of number cards with values written on them, possibly repeated and out of order.
Your goal is to find all unique pairs of cards (a, b) such that:
b - a = k
Output the pairs in any order, but each on a new line.

Input Format:
-------------
Line-1: An integer n — the number of number cards
Line-2: n space-separated integers — the values on the number cards
Line-3: An integer k — the target difference

Output Format:
-------------
Print each valid unique pair (a, b) such that b - a = k, one per line
Format: (b, a)

Constraints:
-------------
-> 1 ≤ n ≤ 10^5
-> 0 ≤ arr[i] ≤ 10^9
-> 0 ≤ k ≤ 10^9
-> Input array may contain duplicates
-> No extra space is allowed (excluding input array and recursion/sorting stack)
-> Output must contain only unique pairs (no duplicates)

Sample Input-1:
-------------
8
1 5 2 2 2 5 5 4
3

Sample Output-1:
-------------
(4, 1)
(5, 2)

Sample Input-2:
-------------
6
1 3 5 7 9 11
2

Sample Output-2:
-------------
(3, 1)
(5, 3)
(7, 5)
(9, 7)
(11, 9)

Sample Input-3:
-------------
8
1 2 3 4 5 6 7 8
1

Sample Output-3:
-------------
(2, 1)
(3, 2)
(4, 3)
(5, 4)
(6, 5)
(7, 6)
(8, 7)
'''
def difference(arr,k):
    arr.sort()
    n=len(arr)
    res=[]
    for i in range(n):
        target=arr[i]+k
        left=i+1
        right=n-1
        while left<=right:
            mid=(left+right)//2
            if arr[mid]==target:
                res.append((arr[mid],arr[i]))
                break
            elif arr[mid]<target:
                left=mid+1
            else:
                right=mid-1
    result=sorted((set(res)))
    for a,b in result:
        print(a,b)
n=int(input())
arr=list(map(int,input().split()))
k=int(input())
difference(arr,k)