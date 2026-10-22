
// class Solution {
//     public int minOperations(int[] nums) {
//         int n = nums.length;
//         int zero = 0;

//         for (int i = 0; i < n; i++) {
//             if (nums[i] == 0) {
//                 zero = i;
//                 break;
//             }
//         }

//         int ans = Integer.MAX_VALUE;

//         if (check(nums, zero, 1)) {
//             ans = Math.min(ans, zero);
//             ans = Math.min(ans, n - zero + 2);
//         }

//         if (check(nums, zero, -1)) {
//             ans = Math.min(ans, zero + 2);
//             ans = Math.min(ans, n - zero);
//         }

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }

//     private boolean check(int[] nums, int zero, int step) {
//         int n = nums.length;

//         for (int i = 1; i < n; i++) {
//             int prev = (zero + (i - 1) * step + n) % n;
//             int curr = (zero + i * step + n) % n;

//             if (nums[prev] > nums[curr]) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }
class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1)return 0;
        //check for inc
        int dec=-1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]+1){
                if(dec!=-1){
                    dec=n+1;
                    break;
                }
                dec=i;
            }
        }
        if(dec==-1)return 0;
        if(dec<n)return Math.min(dec,2+(n-dec));
        //check for dec
        int inc=-1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]-1){
                if(inc!=-1){
                    inc=n+1;
                    break;
                }
                inc=i;
            }
        }
        if(inc==-1)return 1;
        if(inc<n){
            return Math.min(inc,n-inc)+1;
        }
        return -1;
    }
}