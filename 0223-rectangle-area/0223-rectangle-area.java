class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        // Area of Rectangle A
        int aWidth = ax2 - ax1;
        int aHeight = ay2 - ay1;
        int areaA = aWidth * aHeight;

        // Area of Rectangle B
        int bWidth = bx2 - bx1;
        int bHeight = by2 - by1;
        int areaB = bWidth * bHeight;

        // Overlapping width
        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));

        // Overlapping height
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        // Overlapping area
        int overlapArea = overlapWidth * overlapHeight;

        // Total covered area
        return areaA + areaB - overlapArea;
    }
}