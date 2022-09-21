public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1; // s = start
        int e = n; // e = end
        while (s<=e){
            int m = s + (e-s)/2;
            if(isBadVersion(m)){
              // if the current version is Bad then all the next version will also be bad.
              // Hence we will only search in values before the current Mid.
                e = m - 1;
            }
            else if (!(isBadVersion(m))){
              // if the current version is not bad then First Bad version exist the current mid
              // Hence, we will increment the start value to search in next right window.
                s = m + 1;
            }
        }
       // After all the iterations are finished, the start will point to the First Bad Version
       return s;
    }    
}
