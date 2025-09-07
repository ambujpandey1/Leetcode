class Solution {
    static long m=1_000_000_007;
    long findPow(long a, long b){
        if(b==0) return 1;
        long half=findPow(a,b/2);
        long res=(half*half) % m;

        if(b%2==1)
        {
            res=(res*a)%m;
        }
        return res;
    }
    public int countGoodNumbers(long n) {
    return (int)((findPow(5,(n+1)/2)*findPow(4,n/2))%m);

    }
}