class Solution {


    private  int getMax(int [] piles){
        int max = 0;
        for(int p : piles){
            max = Math.max(max,p);

        }

        return max;



    }
    public int minEatingSpeed(int[] piles, int h) {
        int low  = 1 ;
        int high = getMax(piles);
        while(low < high){
            int mid = low + (high-low) / 2;
            int hours  = 0;
            for(int p : piles){
                hours+= (p+mid -1)/mid;
            }
            if(hours <= h){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;

        
    }
}