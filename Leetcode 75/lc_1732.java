public class lc_1732 {
    class Solution {
    public int largestAltitude(int[] gain) {
        int highAltitude=0;
        int currentAltitude=0;

        for(int i=0; i<gain.length; i++)
        {
            currentAltitude +=gain[i];
            highAltitude=Math.max(currentAltitude,highAltitude);
        }
        return highAltitude;

    }
}
}
