import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/9/6 22:14
 * @Created by Michelangelo-apple
 */
public class Test {
    public static int[] findKMax(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);//队列默认自然顺序排列，小顶堆，不必重写compare

        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {//如果堆顶元素 < 新数，则删除堆顶，加入新数入堆
                pq.poll();//peek 和 poll 可能不是一个元素
                pq.offer(num);
            }
//            pq.offer(num);
        }

        int[] result = new int[k];
        for (int i = 0; i < k&&!pq.isEmpty(); i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[]arr=new int[]{1, 6, 2, 3, 5, 4, 8, 7, 9};
        System.out.println(Arrays.toString(findKMax( arr,5)));
        System.out.println(Arrays.toString(getLeastNumbers( arr,5)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(arr.length);
        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]  = heap.poll();
        }
        return ans;
    }
}
