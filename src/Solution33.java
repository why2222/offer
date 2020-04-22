
import java.util.Arrays;

public class Solution33 {
    public static boolean VerifySquenceOfBST(int[] squence) {
        if (squence == null || squence.length < 0) {
            return false;
        }
        int root = squence[squence.length - 1];
        // 搜索可能的左子节点
        int i = 0;
        for (; i < squence.length - 1; i++) {
            if (squence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < squence.length - 1; j++) {
            if (squence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > 0) {
            left = VerifySquenceOfBST(Arrays.copyOf(squence,i));
        }
        boolean right = true;
        if (i < squence.length - 1) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(squence, i, squence.length - 1));
        }
        return left && right;
    }
}
