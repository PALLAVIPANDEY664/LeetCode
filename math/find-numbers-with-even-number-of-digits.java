class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }

    public boolean even(int num){
        int digits=digit(num);
        if(digits%2==0){
            return true;
        }
        return false;
    }

    public int digit(int num){
        int count=0;
        while(num>0){
            count++;
            num=num/10;

        }
        return count;
    }
}