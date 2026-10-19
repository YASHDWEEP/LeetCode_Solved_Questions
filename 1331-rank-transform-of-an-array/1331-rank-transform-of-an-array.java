class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        HashMap<Integer, Integer> Hs = new HashMap<>();
        int rank = 1;
        for (int num : temp) {
            if (!Hs.containsKey(num)) {
                Hs.put(num, rank++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Hs.get(arr[i]);
        }
        return arr;
    }
}