//last stone weight

import java.util.*;

class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) pq.add(s);

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            if(x!=y) pq.add(y-x);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,3,6,2,4};
        System.out.println(lastStoneWeight(stones));
    }
}
