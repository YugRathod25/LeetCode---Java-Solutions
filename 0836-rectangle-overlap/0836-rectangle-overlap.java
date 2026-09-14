class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // for x axis
        int a1 = rec1[0];
        int a2 = rec1[2];
        int b1 = rec2[0];
        int b2 = rec2[2];
        boolean xOverlap = (a1 < b2  &&  a2 > b1);

        // now for y axis
        int c1 = rec1[1];
        int c2 = rec1[3];
        int d1 = rec2[1];
        int d2 = rec2[3];
        boolean yOverlap = (c1 < d2  &&  c2 > d1);

        return xOverlap && yOverlap;
    }
}