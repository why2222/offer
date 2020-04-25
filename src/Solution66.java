public class Solution66 {
    public static int[] multiply(int[] A) {
        if (A == null || A.length <= 0) {
            return null;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int temp = 1;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    temp *= A[j];
                }
                B[i] = temp;
            }
        }
        for (int n : B) {
            System.out.println(n);
        }
        return B;
    }
}
