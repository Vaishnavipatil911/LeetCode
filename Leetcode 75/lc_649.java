class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer>radiant=new LinkedList<>();
        Queue<Integer>dire=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            char ch=senate.charAt(i);
            if(ch=='R')
            {
                radiant.add(i);
            }
            else
            {
                dire.add(i);
            }
        }

            while(!radiant.isEmpty() && !dire.isEmpty())
            {
                if(radiant.peek()<dire.peek())
                {
                    dire.poll();
                    int r=radiant.poll();
                    radiant.add(r+n);
                }
                else
                {
                    radiant.poll();
                    int d=dire.poll();
                    dire.add(d+n);
                }

            }
            if(radiant.isEmpty())
            {
                return "Dire";
            }
            else
            {
                return "Radiant";
            }



        
    }
}