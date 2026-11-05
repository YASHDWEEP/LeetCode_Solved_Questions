class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, element = 0;
        for (int n : nums) {
            if (count == 0) {
                element = n;
            }
            if (element == n) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}