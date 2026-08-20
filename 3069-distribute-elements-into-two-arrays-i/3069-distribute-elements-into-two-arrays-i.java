class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> L1 = new ArrayList<>(); 
        List<Integer> L2 = new ArrayList<>(); 
        L1.add(nums[0]);
        L2.add(nums[1]);
        for (int i = 2 ; i < nums.length ; i++){
            if (L1.getLast() > L2.getLast()){
                L1.add(nums[i]); 
            }else {
                L2.add(nums[i]); 
            }
        }
        int index = 0 ; 
        for (int i = 0  ; i < L1.size()  ; i++ ){
            nums[index] = L1.get(i);
            index++;  
        }
        for (int i = 0  ; i < L2.size()  ; i++ ){
            nums[index] = L2.get(i);
            index++;  
        }
        return nums;
        // L1.addAll(L2); 
        // return L1.stream().mapToInt(Integer::intValue).toArray();
    }
}