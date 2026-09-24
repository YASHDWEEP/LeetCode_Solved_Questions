class Solution {

    public int reflection(int n) {
        String binary = Integer.toBinaryString(n);
        String rev = new StringBuilder(binary).reverse().toString();
        return Integer.parseInt(rev, 2);
    }

    public int[] sortByReflection(int[] nums) {

        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int ra = reflection(a);
            int rb = reflection(b);

            if (ra != rb) {
                return Integer.compare(ra, rb);
            }

            // If reflection values are equal,
            // sort by original number.
            return Integer.compare(a, b);
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}