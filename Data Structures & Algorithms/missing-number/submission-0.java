class Solution {
    public int missingNumber(int[] nums) {
      
        int xor = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= nums.length; i++) {
            xor = xor ^ i;
        }

        // XOR all array elements
        for (int num : nums) {
            xor = xor ^ num;
        }

        return xor;
    }
}
