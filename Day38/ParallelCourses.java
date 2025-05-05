/*
 * You are given an integer N which denotes the number of courses numbered from 1 to N and a matrix ‘prerequisites’,
in which each row contains exactly two integers ‘A’ and ‘B’ which represents the course ‘A’ 
has to be studied in some semester before studying course ‘B’.

In one semester, you can take at most k courses as long as you have taken all the prerequisites in the 
previous semesters for the courses you are taking.

You are supposed to find the minimum number of semesters required to study all the courses. 
If it is impossible to study all the courses, then return -1.

Input Format:
-------------
The first line represents N, which denotes the number of courses
The second line represents M, which denotes the number of rows of the matrix prerequisites.
The next M lines contain two integers, prerequisites[i][0] and prerequisites[i][1], 
denoting that prerequisites[i][0] has to be studied before prerequisites[i][1].
Last line k, denotes number of courses can be taken in a semester.

Output Format:
---------------
Print the minimum number of semesters required to study all the courses

Sample Input 1
--------------
4
3
2 1
3 1
4 1
2

Sample output 1
---------------
3


Explanation: 
------------
In the first semester, you can take courses 2 and 3.
In the second semester, you can take course 4.
In the third semester, you can take course 1.

Sample input 2
--------------
4
3
1 3
2 3
3 1
3
Sample output 2
----------------
-1

Constraints:
1<= N <= 50
1<=k<=N
1 <= prerequisites[i][0], prerequisites[i][1] <= N
Prerequisites[i][0] != prerequisites[i][1], for any valid i
 */
