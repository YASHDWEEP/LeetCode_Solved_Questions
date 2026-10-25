class Solution {
    public static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int a_Alice = total_days(arriveAlice);
        int l_Alice = total_days(leaveAlice);
        int a_Bob = total_days(arriveBob);
        int l_Bob = total_days(leaveBob);
        int c_start = Math.max(a_Alice, a_Bob);
        int c_end = Math.min(l_Alice, l_Bob);
        return Math.max(0, c_end - c_start + 1);

    }

    public int total_days(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }
        return day;
    }
}