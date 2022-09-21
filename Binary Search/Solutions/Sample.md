
# Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

 

Example 1:

```
Input: n = 10, pick = 6
Output: 6
```
Example 2:
```
Input: n = 1, pick = 1
Output: 1
```
Example 3:
```
Input: n = 2, pick = 1
Output: 1
``` 

Constraints:

`1 <= n <= 231 - 1`
`1 <= pick <= n`

## Solution

```java
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(guess(mid) == -1){
              
              //if  api return -1 Number to be found is smaller than this mid and hence we change index to find in left side of current mid element
                end = mid - 1;
            }else if(guess(mid) == 1){
              
              //if  api return -1 Number to be found is greater than this mid and hence we change index to find in Right side of cuurent mid element
                start = mid + 1;
            }else{
              
              // if above 2 cases are False then the mid element will be the Number we are searching and we will return it as our answer
                return mid;
            }
        }
      
      //we will return start at end since after all the iterations start will be pointing to NUmber to be find.
        return start;
    }
}
```

