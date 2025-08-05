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
}