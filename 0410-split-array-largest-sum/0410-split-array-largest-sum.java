// class Solution {
//     public int splitArray(int[] nums, int k) {

//         int left = 0;
//         int right = 0;

//         // Find maximum element and total sum
//         for (int num : nums) {
//             left = Math.max(left, num);
//             right += num;
//         }

//         // Binary Search
//         while (left < right) {

//             int mid = left + (right - left) / 2;

//             // Check how many subarrays are required
//             int subarrays = 1;
//             int currentSum = 0;

//             for (int num : nums) {

//                 if (currentSum + num > mid) {
//                     subarrays++;
//                     currentSum = num;
//                 } else {
//                     currentSum += num;
//                 }
//             }

//             // Too many subarrays -> mid is too small
//             if (subarrays > k) {
//                 left = mid + 1;
//             }
//             // We can use k or fewer subarrays -> try smaller
//             else {
//                 right = mid;
//             }
//         }

//         return left;
//     }
// }
// class Solution {
//     public int splitArray(int[] nums, int k) {
//         int slarge = sum(nums);
//         int smin = max(nums);
//         int mid =0;
//         while(smin <= slarge){
//             mid = (smin + slarge)/2;
//             if(isSplitPossible(nums,k,mid)){
//                 slarge = mid -1;
//             }else{
//                 smin = mid +1 ;
//             }
//         }
//         return smin;
//     }
//     private boolean isSplitPossible(int[] nums,int k,int sum){
//         int sub = 1;
//         int curSum = 0;
//         for(int i=0;i<nums.length;i++){
//             if(curSum+nums[i] <=sum){
//                 curSum += nums[i];
//             }else{
//                 sub++;
//                 curSum = nums[i];
//             }
//         }
//         return sub <= k;
//     }
//     private int max(int[] nums){
//         int max = nums[0];
//         for(int i =1;i<nums.length; i++){
//             if(nums[i] > max){
//                 max = nums[i];
//             }
//         }
//         return max;
//     }
//     private int sum(int[] nums){
//         int sum =0;
//         for(int x : nums){
//             sum += x;
//         }
//         return sum;
//     }
// }
class Solution {
    public int splitArray(int[] nums, int k) {

        long low = nums[0];
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > low) {
                low = nums[i] ;
            }
        }
        
        long high = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            high = high + nums[i] ;
        }
         
         long ans = -1 ;
        
        while(low <= high) {
             
            long mid = low + ( high - low) / 2 ;
            
              int count = 1 ;
              long sum = 0 ;
              for( int i = 0 ; i < nums.length ; i++) {
                 if(sum + nums[i] > mid) {
                     count++;
                     sum = 0 ;
                 }
                 sum += nums[i] ;
              }         
            if(count <= k) {
                ans = mid;
                high = mid - 1 ;
            }
            
            else{
                low = mid + 1 ;
            }
         }  
        
        return (int) ans;  
    }
}