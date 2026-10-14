class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }
        int k = sum / 9;
        sum %= 9;
        StringBuilder sb = new StringBuilder("9".repeat(k));

        if (sum > 0) {
            sb.append(sum);
        }
        sb.append("0".repeat(num - sb.length()));
        return sb.toString();
    }
}