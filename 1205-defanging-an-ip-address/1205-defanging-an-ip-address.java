class Solution {
    public String defangIPaddr(String address) {
        String[] each=address.split("\\.");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<each.length-1;i++){
            sb.append(each[i]);
            sb.append("[.]");
        }
        sb.append(each[each.length-1]);
        return sb.toString();

    }
}