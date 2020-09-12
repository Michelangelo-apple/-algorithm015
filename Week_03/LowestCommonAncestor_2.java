/**
 * @Classname LowestCommonAncestor 236
 * @Description TODO
 * @Date 2020/9/12 9:29
 * @Created by Michelangelo-apple
 */
public class LowestCommonAncestor_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        TreeNode result = null;
        _dfs(root,p,q,result);
        return result;
    }
    private boolean _dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode result) {
        if (root == null) {
            return false;
        }
        boolean left = _dfs(root.left, p, q, result);
        boolean right = _dfs(root.right, p, q, result);
        if ((left && right) || ((root.val == q.val || root.val == p.val) && (left || right))) {
            result.val = root.val;
        }
        return left || right || (root.val == q.val || root.val == p.val);
    }

}
