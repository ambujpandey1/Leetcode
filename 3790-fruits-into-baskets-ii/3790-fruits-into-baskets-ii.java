class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
       int n=baskets.length;
       int c=0;
      Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){

            if(fruits[i]<=baskets[j]){
                      c++;
                      baskets[j]=-1;
                      break;
            } 
        }
       } 
       return n- c;
    }
}