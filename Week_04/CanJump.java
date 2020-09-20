public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;

    }
}
