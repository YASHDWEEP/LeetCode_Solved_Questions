class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> A  =  new ArrayList<>(); 
        List<int[]> B =  new ArrayList<>(); 
        for (int i = 0 ;i < img1.length ; i++ ){
            for (int j = 0 ; j < img2.length ; j++){
                if (img1[i][j] == 1){
                    A.add(new int[] {i,j});
                }
                
                if (img2[i][j] == 1){
                    B.add(new int[] {i,j});
                }
            }
        }     
        int ans = 0;    
        Map<String,Integer> Map = new HashMap<>(); 
        for (int p[] : A){
            for (int q[] : B){
                int dr = q[0] - p[0];
                int dc = q[1] - p[1];
                String key = dr + "," + dc; 
                int count = Map.getOrDefault(key,0)+1; 
                Map.put(key, count);

                ans = Math.max(ans, count);

            }
        }
        return ans ; 
    }
}