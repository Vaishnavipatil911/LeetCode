class Solution {
    public int largestRectangleArea(int[] heights) {

        int n=heights.length;
        int[] left=previousSmaller(heights);
        int[] right=nextSmaller(heights);
        int maxArea=0;

        for(int i=0; i<n; i++)
        {
            int width=right[i]-left[i]-1;
            int area=heights[i] * width;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
        
    }

    public int[] previousSmaller(int[] heights)
    {
        int n=heights.length;
        int left[]=new int[n];
        Stack<Integer>stack=new Stack<>();
        

        for(int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
                stack.pop();
            }

            if(stack.isEmpty())
            {
                left[i]=-1;
            }
            else
            {
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        return left;
    }

    public int[] nextSmaller(int[] heights)
    {
        int n=heights.length;
        int right[]=new int[n];
        Stack<Integer>stack=new Stack<>();
      

        for(int i=n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
                stack.pop();
            }

            if(stack.isEmpty())
            {
                right[i]=n;
            }
            else
            {
                right[i]=stack.peek();
            }
            stack.push(i);
        }
        return right;
    }


}