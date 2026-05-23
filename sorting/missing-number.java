import java.util.Scanner;

class Solution {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // XOR from 0 to n
        for (int i = 0; i <= n; i++) {
            xor = xor ^ i;
        }

        // XOR with all elements in nums
        for (int num : nums) {
            xor = xor ^ num;
        }

        return xor; // final result is the missing number
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = missingNumber(nums); // ✅ updated method name
        System.out.println("Missing number is: " + result);

        sc.close();
    }
}
