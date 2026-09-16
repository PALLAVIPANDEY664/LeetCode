class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int left = 0;
        int right = n-1;
        int current = 0;
        int maxScore = 0;
        while(left <= right){
            if(power >= tokens[left]){
                current += 1;
                power -= tokens[left];
                left++;
                maxScore = Math.max(maxScore, current);
            }
            else if(current > 0){
                power += tokens[right];
                current--;
                right--;
            }
            else{
                break;
            }

        }
        return maxScore;

    }
}