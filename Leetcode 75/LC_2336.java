import java.util.*;;
class SmallestInfiniteSet {
    PriorityQueue<Integer> minHeap;
    int current;
    HashSet<Integer> addBack;

    public SmallestInfiniteSet() {
        current=1;
        minHeap=new PriorityQueue<>();
        addBack=new HashSet<>();
        
    }
    
    public int popSmallest() {
        if(!minHeap.isEmpty() && minHeap.peek()<current)
        {
            int num=minHeap.poll();
            addBack.remove(num);
            return num;
        }
        else
        {
            int num=current;
            current++;
            return num;
        }
        
    }
    
    public void addBack(int num) {
        if(num<current && !addBack.contains(num))
        {
            addBack.add(num);
            minHeap.offer(num);
        }
        
    }
}

