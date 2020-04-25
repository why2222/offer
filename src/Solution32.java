import java.util.*;

public class Solution32 {
    /**
     * 不分行从上到下打印二叉树
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode pNode = nodeQueue.poll();
            if (pNode == null) {
                continue;
            }
            result.add(pNode.val);
            nodeQueue.add(pNode.left);
            nodeQueue.add(pNode.right);
        }
        return result;
    }

    /**
     * 分行从上到下打印二叉树
     * nextLevel:下一层的节点个数
     * toBePrinted:待打印节点个数
     * @param root
     */
    public static void PrintByRow(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode pNode = nodeQueue.peek();
            System.out.printf("%d", pNode.val);
            if (pNode.left != null) {
                nodeQueue.add(pNode.left);
                nextLevel++;
            }
            if (pNode.right != null) {
                nodeQueue.add(pNode.right);
                nextLevel++;
            }
            nodeQueue.poll();
            toBePrinted--;
            if (toBePrinted == 0) {
                System.out.printf("\n");
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    /*
    分行打印--剑指offer
     */
    static ArrayList<ArrayList<Integer> > PrintByLayer(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(pRoot);
        while (!treeNodes.isEmpty()) {
            int count = treeNodes.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (count > 0) {
                TreeNode node = treeNodes.poll();
                temp.add(node.val);
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
                count--;
            }
            res.add(temp);
        }
        return res;
    }

    public static void PrintByZhi(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> levels[] = new Stack[2];
        int current = 0;
        int next = 1;
        // 注意这里要创建levels[current]和levels[next]，否则会出现空指针异常【Error】。
        levels[current] = new Stack<>();
        levels[next] = new Stack<>();
        levels[current].push(root);
        while (!levels[0].isEmpty() || !levels[1].isEmpty()) {
            TreeNode pNode = levels[current].peek();
            levels[current].pop();
            System.out.printf("%d", pNode.val);
            if (current == 0) {
                if (pNode.left != null) {
                    levels[next].push(pNode.left);
                }
                if (pNode.right != null) {
                    levels[next].push(pNode.right);
                }
            }
            if (current == 1) {
                if (pNode.right != null) {
                    levels[next].push(pNode.right);
                }
                if (pNode.left != null) {
                    levels[next].push(pNode.left);
                }
            }
            if (levels[current].isEmpty()) {
                System.out.printf("\n");
                current = 1 - current;
                next = 1 - next;
            }
        }
    }

    /**
     * 之字形打印二叉树--剑指offer
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> trees = new LinkedList<>();
        trees.add(pRoot);
        boolean flag = true;
        while (!trees.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int count = trees.size();
            while (count > 0) {
                TreeNode node = trees.poll();
                temp.add(node.val);
                if (node.left != null) {
                    trees.add(node.left);
                }
                if (node.right != null) {
                    trees.add(node.right);
                }
                count--;
            }
            if (flag) {
                res.add(temp);
            } else {
                Collections.reverse(temp);
                res.add(temp);
            }
            flag = !flag;
        }
        return res;
    }
}
