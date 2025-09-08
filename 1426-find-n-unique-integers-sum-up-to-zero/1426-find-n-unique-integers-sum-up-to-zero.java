class Solution {
    public int[] sumZero(int n) {
       List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n/2;i++){
          ans.add(i);
          ans.add(-i);
        }
        if(n%2!=0){
            ans.add(0);
        }

       int[] arr=new int[n];
       for(int i=0;i<ans.size();i++){
        arr[i]=ans.get(i);
       }
       return arr;
    }
}