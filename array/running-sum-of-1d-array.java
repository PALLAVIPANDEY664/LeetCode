class Solution {
public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];   // keep adding
            nums2[i] = sum;   // store cumulative sum
        }
        return nums2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = runningSum(nums);

        System.out.println("Running sum array: " + Arrays.toString(result));
    }
}
