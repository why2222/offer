
import java.util.Arrays;

public class Solution7 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        //  判断前序中序序列是否为空
        if (pre == null || in == null || pre.length == 0 || in.length  == 0 || pre.length != in.length){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0;i < pre.length;i++){
            if (pre[0] == in[i]){
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length)
                );
            }
        }
        return  root;
    }
}
