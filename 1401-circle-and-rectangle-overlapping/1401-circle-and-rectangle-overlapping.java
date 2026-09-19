class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x_closest = Math.max(x1, Math.min(xCenter, x2));
        int y_closest = Math.max(y1, Math.min(yCenter, y2));
        double closest_dis = Math.sqrt(Math.pow((x_closest - xCenter), 2) + Math.pow((y_closest - yCenter), 2));
        return closest_dis <= radius ? true : false;

    }
}