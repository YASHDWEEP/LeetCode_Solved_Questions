// class Solution {
//     public int minimumSumSubarray(List<Integer> nums, int l, int r) {
//         int n = nums.size();
//         int res = Integer.MAX_VALUE;

//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = i; j < n && j < i + r; j++) {
//                 sum += nums.get(j);
//                 int len = j - i + 1;
//                 if (sum > 0 && len >= l && len <= r) {
//                     res = Math.min(res, sum);
//                 }
//             }
//         }
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
// }
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefix = new int[nums.size()+1];
        for(int i = 0;i<nums.size();i++){
            prefix[i+1] = prefix[i] + nums.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<nums.size();i++){
            for(int len = l;len<=r;len++){
                int j = i+ len;
                
                if (j > prefix.length-1) {
                    break;
                }
                int sum = prefix[j] - prefix[i];
                if(sum>0){
                    ans = Math.min(ans,sum);
                }
            }
        }
        return ans==Integer.MAX_VALUE ? -1: ans;
    }
}