class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res=new ArrayList<>();
        Set<Float> set=new HashSet<>();
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                float fr=(float) i/j;
                if(!set.contains(fr)){
                    String r=i+"/"+j;
                    res.add(r);
                    set.add(fr);
                }
            }
        }
        return res;
    }
}