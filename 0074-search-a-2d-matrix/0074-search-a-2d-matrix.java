class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int r=matrix.length;
      int c=matrix[0].length;

     int s=0;
     int e=r-1;
     while(s<=e){
        int mid=s+(e-s)/2;
        if(matrix[mid][0] <=target && matrix[mid][c-1]>=target){
            int se=0;
            int ee=c-1;
            while(se<=ee){
                int m=se+(ee-se)/2;
                if(matrix[mid][m]==target) return true;
                else if(matrix[mid][m]<target) se=m+1;
                else ee=m-1;
            }
            return false;
        }
        else if(target >matrix[mid][c-1]){
            s=mid+1;
        }else{
            e=mid-1;
        }
     }
     return false;
    }
}