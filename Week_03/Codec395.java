import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Codec395 297
 * @Description TODO
 * @Date 2020/9/11 16:18
 * @Created by Michelangelo-apple
 */
public class Codec395 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return _serialize(root,"");
    }
    private String _serialize(TreeNode node,String str) {
        if (node == null) {
            return str + "null,";
        }
        str += String.valueOf(node.val) + ",";
        str = _serialize(node.left,str);
        str = _serialize(node.right,str);
        return  str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 ) {
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
            return  null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        list.remove(0);
        root.left = _deserialize(list);
        root.right = _deserialize(list);
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
