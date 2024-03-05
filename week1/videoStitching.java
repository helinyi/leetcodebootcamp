class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int count = 1;
        int start = 0;
        int end = 0;
        int i = 0;
        if (clips[0][0] != 0) {
            return -1;
        }
        while (i < clips.length - 1 && end < time) {
            if (clips[i][0] == start) {
                end = clips[i][1];
            } else if (clips[i][0] > end) {
                return -1;
            } else if (clips[i + 1][0] > end) {
                start = clips[i][0];
                end = clips[i][1];
                count++;
            }
            i++;
        }
        if (end < time) {
            if (clips[clips.length - 1][1] < time || clips[i][0] > end) {
                return -1;
            }
            count++;
        }
        return count;
    }
}