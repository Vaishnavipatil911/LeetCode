import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc_1657_other {
    class Solution {
    public boolean closeStrings(String word1, String word2) {
      if(word1.length() !=word2.length())
      {
        return false;
      }

    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2=new HashMap<>();
    HashSet<Character> set1=new HashSet<>();
    HashSet<Character> set2=new HashSet<>();

    for(char ch: word1.toCharArray())
    {
        map1.put(ch, map1.getOrDefault(ch,0)+1);
        set1.add(ch);
    }

    for(char i: word2.toCharArray())
    {
        map2.put(i,map2.getOrDefault(i,0)+1);
        set2.add(i);
    }

    if(!set1.equals(set2))
    {
        return false;
    }

    List<Integer> freq1=new ArrayList<>(map1.values());
    List<Integer> freq2=new ArrayList<>(map2.values());

    Collections.sort(freq1);
    Collections.sort(freq2);

    return freq1.equals(freq2);
        
    }
}
}
