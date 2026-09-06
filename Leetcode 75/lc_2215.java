import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc_2215 {
    class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer>set1=new HashSet<>();
        HashSet<Integer>set2=new HashSet<>();
        ArrayList<Integer>answer1=new ArrayList<>();
        ArrayList<Integer>answer2=new ArrayList<>();

        for(int m:nums1)
        {
            set1.add(m);
        }

        for(int n:nums2)
        {
            set2.add(n);
        }

        for(int x:set1)
        {
            if(!set2.contains(x))
            answer1.add(x);
        }

        for(int i:set2)
        {
            if(!set1.contains(i))
            answer2.add(i);
        }
        return Arrays.asList(answer1,answer2);
    }
}
}
