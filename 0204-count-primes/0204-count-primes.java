class Solution {
    // boolean isPrime(int x) {
    //     if (x < 2) return false;
    //     if (x == 2) return true;
    //     if (x % 2 == 0) return false;

    //     // only check odd divisors up to sqrt(x)
    //     for (int i = 3; i * i <= x; i += 2) {
    //         if (x % i == 0) return false;
    //     }
    //     return true;
    // }

    public int countPrimes(int n) {
        // int count = 0;
        // for (int i = 2; i < n; i++) { // strictly less than n
        //     if (isPrime(i)) count++;
        // }
        // return count;

        if (n <= 2) return 0;
        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;

        
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        int count=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}
