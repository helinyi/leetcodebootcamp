class Solution {
    public:
        vector<vector<int>> palindromePairs(vector<string>& words) {
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && isPalindrome(words[i] + words[j])) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = { "bat", "tab", "cat" };
        List<List<Integer>> result = solution.palindromePairs(words);

        for (List<Integer> pair : result) {
            System.out.println(pair.get(0) + ", " + pair.get(1));
        }
    }
}
