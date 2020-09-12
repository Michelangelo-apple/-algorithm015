/**
 * @Classname LowestCommonAncestor 236
 * @Description TODO
 * @Date 2020/9/12 9:29
 * @Created by Michelangelo-apple
 */
public class LowestCommonAncestor_3 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;

    }
}
