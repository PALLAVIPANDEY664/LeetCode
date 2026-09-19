class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the point (nearestX, nearestY) on/inside rectangle closest to circle center
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate the squared distance between the circle center and the nearest point
        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;
        
        int squaredDistance = distX * distX + distY * distY;
        
        // Check if the closest point lies within or on the boundary of the circle
        return squaredDistance <= radius * radius;
    }
}