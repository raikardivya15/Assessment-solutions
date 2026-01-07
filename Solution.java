import java.util.*;

//product of array
class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int n = nums.length, res[] = new int[n], p = 1;
        //left products
        for (int i = 0; i < n; i++) {
            res[i] = p;
            p *= nums[i];
        }
        //right products
        p = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= p;
            p *= nums[i];
        }
        return res;
    }

//
//
//sort character

    public String frequencySort(String s) 
    {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> pq =
            new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();
    }
}
//
//
//two summ


    public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                int j = map.get(need);
                return new int[]{Math.min(i, j), Math.max(i, j)};
            }
            map.put(nums[i], i);
        }
        return new int[0]; // never reached
    }

//
//last stone weight


    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int s : stones) pq.add(s);

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y != x) pq.add(y - x);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

//
//search in rotated sorted array

    public int search(int[] nums, int target) 
    {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            //left
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1; 
                }
            }
            //right
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }
        }

        return -1; 
    }

//
//longest substring without repeating char

    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int l = 0, max = 0;

        for (int r = 0; r < s.length(); r++) 
        {
            freq[s.charAt(r)]++;
            while (freq[s.charAt(r)] > 1)
                freq[s.charAt(l++)]--;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

//
//jump game

    public int jump(int[] nums) 
    {
        int jumps = 0, end = 0, far = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                jumps++;
                end = far;
            }
        }
        return jumps;
    }

//add two nos
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }

            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }

        return dummy.next;
    }
}

