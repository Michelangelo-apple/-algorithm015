/**
 * @Classname LowestCommonAncestor 236
 * @Description TODO
 * @Date 2020/9/12 9:29
 * @Created by Michelangelo-apple
 */
public class LowestCommonAncestor {
    //    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        TreeNode result = null;
        Boolean over = false;
        _dfs(root,p,q,result,over);//在递归过程中改变result的指向，及over的值并不能在递归完成后保存下来
        //但是 改变result的属性值，可以 保存下来。因为函数调用时，参数都复制了一份，复制的是对象所在的地址。
        System.out.println("结束后Over:" + over);
        return result;
    }
    private boolean _dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode result,Boolean over) {
        if (root == null) {
            return false;
        }
        boolean left = _dfs(root.left, p, q, result,over);
        boolean right = _dfs(root.right, p, q, result,over);
        if ((left && right) || ((root.val == q.val || root.val == p.val) && (left || right))) {
//            if (!over) {//如果已经找到最近公共祖先，则不再赋值
//                result = root; 跳出递归后，并不能改变result的指向，result仍为初始值null.
            result.val = root.val;
            over = true;
//            }

        }
        boolean returnVal = left || right || (root.val == q.val || root.val == p.val);
        System.out.println(root == null ? "kong2" : root.val+" "+(returnVal?"true":"false")
                +" "+(over?"true":"false"));
//        System.out.println(result == null ? "kong" : "result:"+result.val);
        return returnVal;
    }
}
