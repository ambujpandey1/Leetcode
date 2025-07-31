class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       Set<Integer> st=new HashSet<>();
        int []ans=new int[2];
      
        int n=grid.length;
        int sum=((n*n)*(n*n+1))/2;
        int c=0;
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            c+=grid[i][j];
            if(st.contains(grid[i][j])){
                ans[0]=grid[i][j];
                
            }else{
            st.add(grid[i][j]);
            }
        }
      }
    
      ans[1]=sum-c+ans[0];
      
      return ans;

     
    }
}