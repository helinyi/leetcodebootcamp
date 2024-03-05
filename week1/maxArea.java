class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max_area = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            max_area = Math.max(max_area, width * minHeight);
            while (left < right && height[left] <= minHeight) {
                left++;
            }
            while (left < right && height[right] <= minHeight) {
                right--;
            }
        }
        return max_area;
    }
}