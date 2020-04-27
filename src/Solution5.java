/**
 * # 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 1.直接在输入str进行改造
 * 2.构造新的String str
 */
public class Solution5 {
    /**
     * 1.直接在输入str进行改造
     * StringBuffer 方法：
     *  * str.length:长度
     *  * str.deleteCharAt(i):删除下标为i的元素。
     *  * str.insert(i,"abc"):从下标为i开始进行插入"abc"。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        String target = "%20";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, target);
            }
        }
        return str.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res += "%20";
            } else {
                res += str.charAt(i);
            }
        }
        return res;
    }
}
