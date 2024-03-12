Class Solution {
    public:
        int myAtoi(string s) {
        if (s == null || s.length() == 0) {
            return 0; // Return 0 if the string is empty or null
        }

        s = s.trim(); // Step 1: Ignore leading whitespace
        if (s.length() == 0) {
            return 0; // Return 0 if the string becomes empty after trimming
        }

        int index = 0;
        int total = 0;
        int sign = 1;

        // Step 2: Check for sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // Step 3 & 4: Convert number and avoid overflow
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break; // Not a digit, stop processing
            }

            // Check for overflow and underflow
            if (total > Integer.MAX_VALUE / 10 ||
                (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test examples
        System.out.println(solution.myAtoi("42")); // Output: 42
        System.out.println(solution.myAtoi("   -42")); // Output: -42
        System.out.println(solution.myAtoi("4193 with words")); // Output: 4193
    }
}
