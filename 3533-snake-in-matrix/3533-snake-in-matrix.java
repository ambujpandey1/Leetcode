class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int pos=0;
        for(String st:commands){
            if(st.equals("RIGHT")) pos+=1;
            else if(st.equals("LEFT")) pos-=1;
            else if(st.equals("UP")) pos-=n;
            else if(st.equals("DOWN")) pos+=n;
        }
        return pos;
    }
}