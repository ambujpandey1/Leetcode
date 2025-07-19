class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(int i=0;i<operations.length;i++){
            String st=operations[i];
            if(st.equals("--X") || st.equals("X--")) x--;
            else  x++;
        }
        return x;
    }
}