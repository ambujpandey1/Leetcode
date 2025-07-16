class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            int target= k-nums[i];
            if(map.containsKey(target)){
                count++;
               if(map.get(target)==1){
                map.remove(target);
               }else{
                map.put(target,map.get(target)-1);
               }
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}