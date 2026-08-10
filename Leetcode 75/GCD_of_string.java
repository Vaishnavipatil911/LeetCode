public class GCD_of_string {
    
    class Solution {
    public String gcdOfStrings(String str1, String str2) {

        if((str1+str2).equals(str2+str1))
        {
            int length=gcd(str1.length(), str2.length());
            return str1.substring(0, length);

        }
        return "";
        
    }

    private int gcd(int a,int b)
    {
        while(b!=0)
        {
        int m=a%b;
        a=b;
        b=m;
        }
        return a;
    }
}
}
