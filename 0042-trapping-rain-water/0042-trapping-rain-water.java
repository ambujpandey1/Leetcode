class Solution {
    public int trap(int[] height) {
    //    int left=0;
    //    int right=height.length-1;
    //    int leftMax=0;
    //    int rightMax=0;
    //    int waterCount=0;

    //    while(left<right){
    //     int min=Math.min(height[left],height[right]);
    //     if(min==height[left]){
    //        leftMax=min; 
    //     }else{
    //       rightMax=min;  
    //     }
    //    }
    
    int n=height.length;
     int []leftMax=new int[n];
     int []rightMax=new int[n];
     leftMax[0]=height[0];
     rightMax[n-1]=height[n-1];
    int count=0;
    
    for(int i=1;i<height.length;i++){
        leftMax[i]=Math.max(leftMax[i-1],height[i]);
       
        
    }
     for(int i=n-2;i>=0;i--){
        rightMax[i]=Math.max(rightMax[i+1],height[i]);   
        
    }
    for(int i=0;i<height.length;i++){
        int c=Math.min(leftMax[i],rightMax[i]);
        int ct=c-height[i];
        count+=ct;
    }
return count;
    }
}