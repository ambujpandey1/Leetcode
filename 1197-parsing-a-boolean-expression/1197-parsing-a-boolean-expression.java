class Solution {
    
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();

        for(char ch:expression.toCharArray()){
            
            if(ch!=')'){
                st.push(ch);
            }else{
                List<Character> values=new ArrayList<>();
                while(st.peek()!='('){
                    values.add(st.pop());
                }
                st.pop();

                char operator=st.pop();
                char result;

                if(operator=='!'){
                    result=(values.get(0)=='t')?'f':'t';
                }
                else if(operator=='&'){
                    result='t';
                    for(char val:values){
                        if(val=='f'){
                            result='f';
                            break;
                        }
                    }
                }
                else{
                    result='f';
                    for(char val:values){
                        if(val=='t'){
                            result='t';
                            break;
                        }
                    }
                }

                st.push(result);
            }
        }

        return st.pop()=='t';
    }
}