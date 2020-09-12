import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Codec395 297
 * @Description TODO
 * @Date 2020/9/11 16:18
 * @Created by Michelangelo-apple
 */
public class Codec395_2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        StringBuilder sb = new StringBuilder();
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                sb.append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null").append(",");
            }


        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strs));
        return _deserialize(list);
    }

    private TreeNode _deserialize(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        String str = list.get(0);
        if ("null".equals(list.get(0))) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        list.remove(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tmp = null;
        String strTmp = null;
        while (list.size() >0) {
            tmp = queue.poll();
            strTmp = list.remove(0);
            if ("null".equals(strTmp)) {
                tmp.left = null;
            } else {
                tmp.left = new TreeNode(Integer.parseInt(strTmp));
                queue.offer(tmp.left);
            }

            strTmp = list.remove(0);
            if ("null".equals(strTmp)) {
                tmp.right = null;
            } else {
                tmp.right = new TreeNode(Integer.parseInt(strTmp));
                queue.offer(tmp.right);
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
