class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // We are in the ascending part
                start = mid + 1;
            } else {
                // We are in the descending part or at peak
                end = mid;
            }
        }
        return start;  // or end (both are same)
    }
}
