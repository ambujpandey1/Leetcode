class Solution {
     public int largestRectangleArea(int[] heights) {
       Stack<Integer> st=new Stack<>();
       int maxA=0;
       int n=heights.length;
       for(int i=0;i<=n;i++){
         while(!st.empty() && (i==n || heights[st.peek()]>=heights[i])){
            int higt=heights[st.peek()];
            st.pop();
            int width;
            if(st.empty()) width=i;
            else width=i-st.peek()-1;

            maxA=Math.max(maxA,width*higt);
         }
         st.push(i);
       } 
       return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int maxArea=0;
        int n=matrix.length;
        int m=matrix[0].length;

        // List<Integer> height=new ArrayList<>();
        int[] height=new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            int area=largestRectangleArea(height);
            maxArea=Math.max(maxArea,area);
        }

        return maxArea;
    }
}