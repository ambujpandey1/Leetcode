class Solution {
    public void nextPermutation(int[] nums) {
      int pivot=-1;
    int n=nums.length;
      for(int i=n-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            pivot=i;
            break;
        }
      }  
      
      if(pivot==-1){
        reverse(nums,0,n-1);
        return;
      }
    for(int i=n-1;i>pivot;i--){
        if(nums[i]>nums[pivot]){
          swap(nums,i,pivot);
          break;
        }
    }

    int i=pivot+1;
    int j=n-1;
    while(i<j){
        swap(nums,i++,j--);
    }

    }

    private void swap(int []nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }

    private void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
}