class Solution {
    public int arrangeCoins(int n) {
        if(n == 1) return 1;
        long s = 2;
        long e = n;
            while (s<=e){
                long m = s + (e-s)/2;
                // we will take sum of coins i.e filled coins as long because sum of int can be more than size of int i.e 10^9
                long filledCoins = (m*(m+1))/2;
              
                if (filledCoins<n){
                  // if the total coins filled till Ith position i.e till mid is less than n
                  // than we will check further ahead after mid by changing start pointer to 1 more than mid.
                    s = m + 1;
                }
              
                else if(filledCoins == n){
                  // if filledcoins == n then no row is left unfilled so we will return mid as ans;
                    return (int)m;
                }
              
                else{
                    e = m - 1;
                }
            }
      // start will be more than end after all the iterations and will be not pointing to desired number.
        return (int)e;
    }
}
