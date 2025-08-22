class Solution {
   double epsilon=1e-6;

   boolean solve(List<Double> cards){
    if(cards.size()==1){
        return Math.abs(cards.get(0)-24)<=epsilon;
    }
    
    for(int i=0;i<cards.size();i++){
        for(int j=0;j<cards.size();j++){
            if(i==j) continue;

            List<Double> temp=new ArrayList<>();
            for(int k=0;k<cards.size();k++){
                if(k!=i && k!=j){
                    temp.add(cards.get(k));
                }
            }
            double a=cards.get(i);
            double b=cards.get(j);
            List<Double> possible=new ArrayList<>();
            possible.add(a+b);
            possible.add(a-b);
            possible.add(b-a);
            possible.add(a*b);
            if(Math.abs(a)>0.0) possible.add(b/a);
            if(Math.abs(b)>0.0) possible.add(a/b);

            for(double val:possible){
                temp.add(val);
                if(solve(temp)==true) return true;
                temp.remove(temp.size()-1);
            }
        }
    }
    return false;

   }

    public boolean judgePoint24(int[] cards) {
        List<Double> list=new ArrayList<>();
        for(int i=0;i<cards.length;i++){
            list.add(1.0*cards[i]);
        }

        return solve(list);
    }
}