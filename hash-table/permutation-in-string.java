class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int [] freq = new int [26];
        for (int i =0; i< s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }
        int windowSize = s1.length();
        for(int i =0; i< s2.length(); i++){
            int windIdx = 0;
            int idx = i;
            int [] windFreq = new int [26];
            while(windIdx < windowSize && idx < s2.length()){
                windFreq[s2.charAt(idx) - 'a']++;
                windIdx++;
                idx++;
            }

            if(windIdx == windowSize && matches(freq, windFreq)){
                return true;
            }
        }
        return false;

    }

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
