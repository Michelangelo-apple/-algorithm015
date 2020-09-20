public class FindMinFromR_Array {
    //153
    public int findMin(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0,right = nums.length -1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return  nums[mid];
            }
            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
