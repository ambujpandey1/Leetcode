class Solution {
      List<List<Integer>> permutaionRec(int idx,int[] nums,List<List<Integer>>ans){
        if(idx==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int num:nums) ds.add(num);
            ans.add(new ArrayList<>(ds));
            return ans;
        }
        for(int i=idx;i<nums.length;i++){
           int temp=nums[i];
           nums[i]=nums[idx];
           nums[idx]=temp;
           permutaionRec(idx+1,nums,ans);
            temp=nums[i];
           nums[i]=nums[idx];
           nums[idx]=temp;

        }
        
        return ans;

      }
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>(); 
        return permutaionRec(0,nums,ans);
    }
}











// Method 1

// class Solution {
//     List<List<Integer>> permutaionRec(int[] nums,List<Integer> ds,List<List<Integer>>ans, boolean[] freq ){
//       if(ds.size()==nums.length){
//         ans.add(new ArrayList<>(ds));
//         return ans;
//       }  

//       for(int i=0;i<nums.length;i++){
//         if(!freq[i]){
//             freq[i]=true;
//             ds.add(nums[i]);
//             permutaionRec(nums,ds,ans,freq);
//             ds.remove(ds.size()-1);
//             freq[i]=false;
//         }
//       }
//       return ans;
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans=new ArrayList<>();
//         List<Integer> ds=new ArrayList<>();
//         boolean freq[]=new boolean[nums.length];
//         return permutaionRec(nums,ds,ans,freq);
//     }
// }