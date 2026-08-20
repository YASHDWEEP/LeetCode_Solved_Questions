// class Solution {
//     public int[] resultArray(int[] nums) {
//         List<Integer> L1 = new ArrayList<>(); 
//         List<Integer> L2 = new ArrayList<>(); 
//         L1.add(nums[0]);
//         L2.add(nums[1]);
//         for (int i = 2 ; i < nums.length ; i++){
//             if (L1.getLast() > L2.getLast()){
//                 L1.add(nums[i]); 
//             }else {
//                 L2.add(nums[i]); 
//             }
//         }
//         int index = 0 ; 
//         for (int i = 0  ; i < L1.size()  ; i++ ){
//             nums[index] = L1.get(i);
//             index++;  
//         }
//         for (int i = 0  ; i < L2.size()  ; i++ ){
//             nums[index] = L2.get(i);
//             index++;  
//         }
//         return nums;
//         // L1.addAll(L2); 
//         // return L1.stream().mapToInt(Integer::intValue).toArray();
//     }
// }

class Solution {
    static {
        for(int i = 0; i <= 500; i++) {
            resultArray(new int[2]);
        }
    }
    public static int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n-1];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        // Like a stack pointer
        int arr1Pointer = 0;
        int arr2Pointer = 0;
        for(int i = 2; i < n; i++) {
            if(arr1[arr1Pointer] > arr2[arr2Pointer]) {
                arr1[++arr1Pointer] = nums[i];
            } else {
                arr2[++arr2Pointer] = nums[i];
            }
        }
        for(int i = 0; i <= arr2Pointer; i++) {
            arr1[++arr1Pointer] = arr2[i];
        }
        return arr1;
    }

    // Idea 1: Instead of using arr1 and arr2, we can directly create a result array and address arr1 via indexes 0 to n/2 and arr2 via n/2 to n-1

    // BUT: Will this work? Because we don't know the resulting length of each array.

    // Idea 2: BUT what actually works is, that we don't need a result array. We can just move elements from arr2 to arr1 to save memory

    // Idea 3: Potentially save more memory by using a single result array of size n. Then reverse the arr2 part. This way we can go from O(2n) -> O(n) space
}