class Solution {

    // public static void rotate(int[] nums, int k) {
    //     int temp[] = new int[nums.length];
    //     int n = nums.length;
    //     k = k % n;
    //     for (int i = 0; i < n; i++) {
    //         temp[(i + k) % n] = nums[i];
    //     }
    //     for (int i = 0; i < n; i++) {
    //         nums[i] = temp[i] ;
    //     }
    // }
    public static void rotate(int[] nums, int k){
        int n = nums.length; 
        k = k % n; 
        reverse(nums, 0 , n-1);
        reverse(nums, 0 , k-1);
        reverse(nums, k , n-1);
    }

    public static void reverse(int arr[], int Start , int End ){
     while(Start < End)
        {int temp = arr[Start]; 
        arr[Start] = arr[End]; 
        arr[End] = temp; 
        Start++; 
        End--;}
    }

}