import java.util.Arrays;
import java.util.HashMap;

/**
 * 350
 * 1、无序情况下利用哈希表，为降低空间复杂度将长度小的放入哈希表内
 * 2、有序情况下利用双指针
 */
public class Intersect1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length > nums2.length) {
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int data : nums1) {
            int count = map.getOrDefault(data,0);
            map.put(data,++count);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (int data : nums2) {
            int count = map.getOrDefault(data,0);
            if (count > 0) {
                result[index++] = data;
                if (count == 1) {
                    map.remove(data);
                } else {
                    map.put(data,--count);
                }
            }
        }

        return Arrays.copyOfRange(result,0,index);
    }


}
