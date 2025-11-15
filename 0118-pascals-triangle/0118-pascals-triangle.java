class Solution {
     List<Integer> printRow(int n){
        int ans=1;
        List<Integer> row=new ArrayList<>();
        row.add(ans);
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/(i);
            row.add(ans);
        }
        return row;
     }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=1;i<=numRows;i++)
        {
            ans.add(printRow(i));
        }
        return ans;
    }
}