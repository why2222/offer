import com.sun.xml.internal.messaging.saaj.soap.ver1_2.BodyElement1_2Impl;

import java.util.Scanner;

/**
 * @auther why
 * @date 2019-11-18 - 17:13
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
//        String str = "12ere2";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int first = str.indexOf(ch);
            int last = str.lastIndexOf(ch);
            if (first == last || first == i) {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}
