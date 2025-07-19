class Solution {
    public String destCity(List<List<String>> paths) {
      Set<String> sourceP=new HashSet<>();
      for(int i=0;i<paths.size();i++){
        sourceP.add(paths.get(i).get(0));
      }  
       for(int i=0;i<paths.size();i++){
        String destination=paths.get(i).get(1);
        if(!sourceP.contains(destination)){
            return destination;
        }
      }  

      return "";
    }
}