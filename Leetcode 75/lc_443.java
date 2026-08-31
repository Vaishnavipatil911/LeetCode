public class lc_443 {
 class Solution {
    public int compress(char[] chars) {
        int read=0;
        int write=0;

        while(read<chars.length)
        {
            char currentChar=chars[read];
            int count=0;
            while(read<chars.length && chars[read]==currentChar)
            {
                read++;
                count++;
            }
            chars[write++]=currentChar;
            if(count>1)
            {
                String countstr=String.valueOf(count);

                for(char c:countstr.toCharArray())
                {
                    chars[write++]=c;

                }
            }
        }
        return write;
        
    }
}   
}
