class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length; // Number of ROWS
        int m = mat.length; //Number of COLUMNS
        int sRow = 0; // Lower Bound for Binary Search along Rows
        int eRow = n - 1; // Upper Bound for Binary Search along Rows
        
        while (sRow <= eRow){
            int midRow = sRow + (eRow - sRow)/2; // Middle Row
            int maxCol = findCol(mat[midRow]); // Maximum Element Column in Middle Row
            
            // if mid row is 1st  Row
            if (midRow == 0){
                if (mat[midRow][maxCol] > mat[midRow+1][maxCol]) return new int[]{midRow,maxCol};
            }
            // if mid row is last Row
            if (midRow == n-1){
                if (mat[midRow][maxCol] > mat[midRow-1][maxCol]) return new int[]{midRow,maxCol};
            }
            //  if mid Row is somewhere between 1st and Last Row
            if(mat[midRow][maxCol] > mat[midRow+1][maxCol] && mat[midRow][maxCol] > mat[midRow-1][maxCol]){
                return new int[]{midRow,maxCol};
            }
            // CONDITION to decrease Search Space
            if (mat[midRow][maxCol] < mat[midRow+1][maxCol]){
                sRow = midRow + 1;
            }else {
                eRow = midRow - 1;
            }
        }
        // if No Peak ELEMENT exist, then return {-1,-1}
        return new int[]{-1,-1};
    }
    
    // Funtion to find Column Number of Max Element in Mid Row
    public int findCol(int[] arr){
        int max = 0, ans = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i] > max) {
                max = arr[i];
                ans = i;
            }
        }
        return ans;
    }
    
}
