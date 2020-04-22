import javax.net.ssl.CertPathTrustManagerParameters;
import java.lang.invoke.MutableCallSite;

public class Solution51 {
    // 暴力法 复杂度过大 Fail
    public static int InversePairs(int[] array) {
        if (array == null && array.length <= 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    res++;
                }
            }
        }
        return res % 1000000007;
    }

    // 归并排序
    private static long res;
    private static int[] tmp;
    public static int InversePairs2(int[] array) {
        tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int) (res % 1000000007);
    }

    private static void mergeSort(int[] array, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    private static void merge(int[] array, int l, int mid, int r) {
        int i = l, j = mid + 1, k = l;
        while (i <= mid || j <= r) {
            if (i > mid) {
                tmp[k++] = array[j++];
            } else if (j > r) {
                tmp[k++] = array[i++];
            } else if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                res += mid - i + 1;
            }
        }
        for (k = l; k <= r; k++) {
            array[k] = tmp[k];
        }
    }
}
