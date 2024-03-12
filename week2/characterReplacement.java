class Solution {
    public:
        int characterReplacement(string s, int k) {
        int[] count = new int[26]; // Frequency count of each letter
        int maxCount = 0; // Max frequency of any letter within the current window
        int start = 0; // Start index of the current window
        int maxLength = 0; // Result length

        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            // Current window size is end - start + 1
            // If the window size minus maxCount is greater than k, it means we can't make all letters in the window the same using k or fewer operations
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--; // Decrease the count of the leftmost letter
                start++; // Shrink the window from the left
            }
            // Update maxLength if the current window is larger
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test examples
        System.out.println(solution.characterReplacement("ABAB", 2)); // Output: 4
        System.out.println(solution.characterReplacement("AABABBA", 1)); // Output: 4
    }
}
