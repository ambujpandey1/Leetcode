class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])>(arr.length/4)){
                return arr[i];
            }
        }

        return -1;


    }
}