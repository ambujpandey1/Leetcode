class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String st = words[i];

            if (st.indexOf(x) != -1) { // Check if char exists in word
                arr.add(i);

            }
        }

        return arr;
    }
}