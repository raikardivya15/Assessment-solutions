//search in rotated sorted array
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
