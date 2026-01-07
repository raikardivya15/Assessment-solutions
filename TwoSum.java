//two summ
import java.util.*;

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
