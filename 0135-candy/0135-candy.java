class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
         Arrays.fill(candies,1);
        boolean update=true;

        while(update){

            update=false;

            // left pass
            for(int i=1;i<n;i++){
                if(ratings[i]>ratings[i-1] && candies[i]<=candies[i-1]){
                    candies[i]=candies[i-1]+1;
                    update=true;
                }
            }

            for(int i=n-2;i>=0;i--){
                 if(ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]){
                    candies[i]=candies[i+1]+1;
                    update=true;
                }
            }
        }

        int ans=0;
        for(int can:candies){
            ans+=can;
        }
        return ans;
    }
}