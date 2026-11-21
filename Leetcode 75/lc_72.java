public class lc_72 {
    class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][]dp=new int[m+1][n+1];

        for(int i=0;i<=m; i++)
        {
            dp[i][0]=1;

        }
        for(int j=0;j<=n;j++)
        {
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    int ins=dp[i][j-1];
                    int del=dp[i-1][j];
                    int replace=dp[i-1][j-1];
                    dp[i][j]=1+Math.min(ins,Math.min(del,replace));

                }
            }
        }
        return dp[m][n];
    }
}
}


//Optmized Version:

class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        
        if(n>m)
        {
            return minDistance(word2,word1);
        }
        int[]dp=new int[n+1];

        for(int j=0;j<=n;j++)
        {
            dp[j]=j;
        }
        for(int i=1;i<=m;i++)
        {
             int prev=dp[0];
                dp[0]=i;

                for(int j=1;j<=n;j++)
                {
                    int temp=dp[j];
                    if(word1.charAt(i-1)==word2.charAt(j-1))
                    {
                        dp[j]=prev;
                    }
                
                else
                {
                    int ins=dp[j-1];
                    int del=dp[j];
                    int replace=prev;
                    dp[j]=1+Math.min(ins,Math.min(del,replace));

                }
                prev=temp;
            }
        }
        return dp[n];
    }
}
