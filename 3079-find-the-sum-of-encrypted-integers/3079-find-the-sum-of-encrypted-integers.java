class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int lar = 0;
            int num = 0;
            while (nums[i] > 0) {
                int dig = nums[i] % 10;
                nums[i] /= 10;
                if (dig > lar) lar = dig;
                num *= 10;
                num += 1;
            }
            sum += num * lar;
        }
        return sum;
    }
}