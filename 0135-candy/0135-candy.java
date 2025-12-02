class Solution {
    public int candyBruteForce(int[] ratings) {
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
    public int candy(int[] ratings) {
    //    return candyBruteForce(ratings); Brute force
     

     int i=1; // starting from 2nd elemet
     int n=ratings.length;
     int candies=n;
     while(i<n){

        if(ratings[i]==ratings[i-1]){
             i++;
            continue;
           
        }

        int peak=0;
        while(i<n && ratings[i]>ratings[i-1]){
            peak++;
            candies+=peak;
            i++;
        }
       int velly=0;
        while(i<n && ratings[i]<ratings[i-1])
        {
            velly++;
            candies+=velly;
            i++;
        }

        // negtive of common pek velly
        candies-=Math.min(peak,velly);
     }

     return candies;

    }
}