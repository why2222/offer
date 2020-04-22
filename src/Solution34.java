import java.util.ArrayList;
import java.util.Stack;

public class Solution34 {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        FindPath(root,target,new ArrayList<Integer>());
        return result;
    }

    public void FindPath(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if (target == 0 && isLeaf) {
            result.add(new ArrayList<>(path));
        } else {
            FindPath(root.left, target, path);
            FindPath(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
