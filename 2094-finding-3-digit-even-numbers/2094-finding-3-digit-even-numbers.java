class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int freq[] = new int[10];
        for (int num : digits) {
            freq[num]++;
        }
        List<Integer> List = new ArrayList<>(); 
        for (int num = 100; num <= 998; num++) {
            if (num % 2 != 0) {
                continue;
            }
            boolean possible = true ; 
            int used[] = new int[10];
            int n = num;
            used[n % 10]++;
            n /= 10;
            used[n % 10]++;
            n /= 10;
            used[n % 10]++;
            for (int i = 0 ; i <= 9 ; i++){
                if (used[i] > freq[i]){
                    possible =  false ;
                    break ; 
                }
            }
            if (possible){
                List.add(num);
            }
        }
        return List.stream().mapToInt(Integer :: intValue).toArray();
    }
}