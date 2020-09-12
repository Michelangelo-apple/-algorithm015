/**
 * @Classname ConstructFromPreInOrder 105
 * @Description TODO
 * @Date 2020/9/12 13:58
 * @Created by Michelangelo-apple
 */
public class ConstructFromPreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _constructFromPreInOder(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode _constructFromPreInOder(int[] pre, int preL, int preR, int[] inOrder, int inOrderL, int inOrderR) {
        if (preL == preR) {
            return new TreeNode(pre[preL]);
        }
        if (preL > preR){
            return null;
        }
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);
        int root_post_index = findRootFormPost(inOrder,inOrderL,inOrderR,rootVal);
        int len_left = root_post_index - inOrderL;
        int len_right = inOrderR - root_post_index;
        root.left = _constructFromPreInOder(pre,preL+1,preL+len_left,inOrder,inOrderL,root_post_index-1);
        root.right = _constructFromPreInOder(pre,preR-len_right+1,preR,inOrder,root_post_index+1,inOrderR);
//        root.right = _constructFromPreIn(pre,preL+len_left+1,preR,post,root_post_index+1,postR);
        return root;
    }

    private int findRootFormPost(int[] post, int postL, int postR, int val) {
        for (int i = postL; i <= postR; i++) {
            if (post[i] == val) {
                return i;
            }
        }
        return -1;
    }

}
