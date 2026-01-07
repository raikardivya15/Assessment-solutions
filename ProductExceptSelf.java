//product of array
import java.util.*;
class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) 
    {
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
        int[] nums = {1, 2, 4, 6};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}

