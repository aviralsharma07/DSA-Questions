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

