import java.util.*;

// 1. Products of Array Except Self
class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length, res[] = new int[n], p = 1;
        for (int i = 0; i < n; i++) {
            res[i] = p;
            p *= nums[i];
        }
        p = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= p;
            p *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}

// 2. Sort Characters by Frequency
class FrequencySort {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char c = pq.poll();
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}

// 3. Two Sum
class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                int j = map.get(need);
                return new int[]{Math.min(i,j), Math.max(i,j)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,6};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

// 4. Last Stone Weight
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

// 5. Search in Rotated Sorted Array
class SearchRotated {
    public static int search(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m]==target) return m;

            if(nums[l]<=nums[m]){
                if(nums[l]<=target && target<nums[m]) r=m-1;
                else l=m+1;
            } else {
                if(nums[m]<target && target<=nums[r]) l=m+1;
                else r=m-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {3,4,5,6,1,2};
        int target = 1;
        System.out.println(search(nums, target));
    }
}

// 6. Longest Substring Without Repeating Characters
class LongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        int[] freq = new int[128];
        int l=0, max=0;
        for(int r=0; r<s.length(); r++){
            freq[s.charAt(r)]++;
            while(freq[s.charAt(r)]>1) freq[s.charAt(l++)]--;
            max = Math.max(max, r-l+1);
        }
        return max;
    }

    public static void main(String[] args){
        String s = "zxyzxyz";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

// 7. Jump Game II (Minimum Jumps)
class JumpGame {
    public static int jump(int[] nums){
        int jumps=0, end=0, far=0;
        for(int i=0;i<nums.length-1;i++){
            far = Math.max(far, i + nums[i]);
            if(i == end){
                jumps++;
                end = far;
            }
        }
        return jumps;
    }

    public static void main(String[] args){
        int[] nums = {2,4,1,1,1,1};
        System.out.println(jump(nums));
    }
}

// 8. Add Two Numbers (Linked List)
class ListNode {
    int val; ListNode next;
    ListNode() {}
    ListNode(int val){ this.val = val; }
}

class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0), curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=carry;
            if(l1!=null){ sum+=l1.val; l1=l1.next; }
            if(l2!=null){ sum+=l2.val; l2=l2.next; }

            curr.next = new ListNode(sum%10);
            carry = sum/10;
            curr=curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }
}
