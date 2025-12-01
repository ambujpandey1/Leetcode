class Solution {
    // brute force
    public static boolean f(String s,int idx, int cnt){
        int n=s.length();
        if(cnt<0) return false;
        if(idx==n) return cnt==0;

        if(s.charAt(idx)=='(') return f(s,idx+1,cnt+1);
        if(s.charAt(idx)==')') return f(s,idx+1,cnt-1);

        return f(s,idx+1,cnt+1)|| f(s,idx+1,cnt-1)|| f(s,idx+1,cnt);
    }
    public boolean checkValidString(String s) {
    //    return f(s,0,0); 
    // optimal way

    int n= s.length();
        int min=0;
        int max=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                min=min+1;
                max=max+1;
            }
            else if( s.charAt(i)==')'){
                min=min-1;
                max=max-1;
            }
            else{
                min=min-1;
                max=max+1;
            }

            if(min<0) min=0;
            if(max<0) return false;
        }

        return min==0;
    }
}