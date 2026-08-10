class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0;
        int maxfreq=0;
        int maxwindow=0;

        for(int right=0; right < s.length(); right++)
        {
            freq[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
            int windowLength= right-left+1;

            while(windowLength-maxfreq>k)
            {
                freq[s.charAt(left)-'A']--;
                left++;
                windowLength=right-left+1;
                
             }
             maxwindow=Math.max(maxwindow, windowLength);
        }

            return maxwindow;
        }
    
}