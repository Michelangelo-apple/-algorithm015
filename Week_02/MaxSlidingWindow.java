import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指offer 59-1
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int j = k; j < nums.length; j++) {
//            if (deque.peekFirst() == j) {
            if (!deque.isEmpty() && deque.peekFirst() == j - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(j);
            result[j - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

}
