import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
  public static void main(String[] args) {
    int[] nums = {4,1,-1,2,-1,2,3};
    int k = 2;
    int[] result = topKFrequent(nums,k);
    print(result);
  }
  public static void print(int[] nums) {
    for (int i : nums) {
      System.out.print(i);
      System.out.print(" ");
    }
  }
  public static int[] topKFrequent (int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int data : nums) {
      map.put(data,map.getOrDefault(data,0) + 1);
    }
    PriorityQueue<Map.Entry<Integer,Integer>> minHeap =
            new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
    for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
      if(minHeap.size() < k){
        minHeap.offer(entry);
      } else {
        if (entry.getValue() > minHeap.peek().getValue()) {
          minHeap.poll();
          minHeap.offer(entry);
        }
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll().getKey();
    }
    return result;
  }
}
