public class Solution37 {
    static StringBuffer result = new StringBuffer();
    public static String Serialize(TreeNode root) {
        if (root == null) {
            result.append("#!");
            return null;
        }
        result.append(Integer.toString(root.val)+"!");
        Serialize(root.left);
        Serialize(root.right);
        return result.toString();
    }

    private static String deserializeStr;

    public static TreeNode Deserialize(String str) {
        // 注意这里！！！判断str是否为空(否则报错：java.lang.NullPointerException)
        if (str == null) {
            return null;
        }
        deserializeStr = str;
        return Deserialize();
    }

    public static TreeNode Deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf("!");
        String node = index == -1 ? "" : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode pNode = new TreeNode(val);
        pNode.left = Deserialize();
        pNode.right = Deserialize();
        return pNode;
    }
}
