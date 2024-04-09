class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // Build the multiplier for the next encoded string
            } else if (ch == '[') {
                // Push the current state onto the stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the next encoded string
                k = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // Pop the multiplier and the previous string
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                // Append the current encoded string, repeated k times, to the previous string
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString; // Set the currentString to the newly formed string
            } else {
                currentString.append(ch); // Append the current character to the current string
            }
        }
        return currentString.toString();
    }
}