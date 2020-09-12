/**
 * 判断一棵树是否为二叉搜索树可以通过中序遍历、前后序遍历实现
 * 1、中序遍历 为升序
 * 2、前后序遍历 需要设置 当前节点值的范围
 * @Classname ValidBST98
 * @Description TODO
 * @Date 2020/9/10 20:31
 * @Created by Michelangelo-apple
 */
public class ValidBST98 {
//    Integer pre = Integer.MIN_VALUE;
    long pre = Long.MIN_VALUE;//设置一个比整形最小值小的数，类型为long int可以向上转为long
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        if (!isValidBST(root.right)) return false;

        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return _isValidBST2(root,null,null);
    }
    private boolean _isValidBST2(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        int currentVal = root.val;
        if(!_isValidBST2(root.left, low, currentVal)) {
            return false;
        }
        if (low != null && currentVal <= low) {
            return false;
        }
        if (high !=null && currentVal >= high) {
            return false;
        }
        return _isValidBST2(root.right, currentVal,high);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

