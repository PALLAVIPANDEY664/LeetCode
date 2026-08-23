class Solution {
    private boolean canEatAllBananas(int[] piles, int mid, int h){
        int actualHours = 0;
        for(int pile : piles){
            actualHours += pile/mid;
            if(pile % mid != 0){
                actualHours++;
            }
        }
        return actualHours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int r = 0;
        for(int pile : piles){
            r = Math.max(r, pile);
        }
        while(l < r){
           int mid = l +(r-l)/2;
            if(canEatAllBananas(piles, mid, h)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}