class Solution {
       boolean isPalindrom(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

     List<List<String>> f(int i, String s, int n,List<List<String>> l,List<String> path) {
        if (i == n){
        l.add(new ArrayList<>(path));
        return l;
        }
        
    
        
        for (int j = i; j < n; j++) {
           
            if (isPalindrom(s, i, j)) {
                path.add(s.substring(i,j+1));
                 f(j + 1, s, n, l,path);
                  path.remove(path.size() - 1);
                
            }
          
        }
        return l;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> l=new ArrayList<>();
        int n=s.length();
        List<String> path=new ArrayList<>();
        return f(0,s,n,l,path);
    }
}