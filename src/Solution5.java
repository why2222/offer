package src;

public class Solution5 {
    public static String replaceSpace(StringBuffer str){
        String target = "%20";
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                str.deleteCharAt(i);
                str.insert(i,target);
            }
        }
        return str.toString();
    }
}
