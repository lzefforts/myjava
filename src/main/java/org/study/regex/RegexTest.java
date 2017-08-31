package org.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ArnoldLee on 17/8/5.
 */
public class RegexTest {

    //1.(MS/MISS/MRS/MR) +空格+姓名(英文)
    private static String ruleOnePattern = "^((MRS |MISS |MS |MR ){1})LI YANJUN$";

    //1.(MS/MISS/MRS/MR) +空格+姓名(英文)
    private static String ruleOnePattern2 = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";


    private static String getRuleOnePattern3 = "^((Miss)?\\s)(LI YANJUN)$";


    public static boolean validateNameMatchesPattern(String name,String regex){
        System.out.println("输入的完整name为"+name);
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);//忽略大小写
        Matcher matcher = pattern.matcher(name);
        boolean isMatch = matcher.matches();
        System.out.println("匹配结果为:"+isMatch);
        return isMatch;
    }

    public static boolean validatePattern(String name,String regex){
        System.out.println("输入的完整name为"+name);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        boolean isMatch = matcher.matches();
        System.out.println("匹配结果为:"+isMatch);
        return isMatch;
    }


    public static void main(String[] args) {
        String name = "Mr Zhang San";
        validateNameMatchesPattern(name,ruleOnePattern);

        String name2 = "Miss LI YANJUN";
        validateNameMatchesPattern(name2,ruleOnePattern);

        String name3 = "Mrs LI YANJUN";
        validateNameMatchesPattern(name3,ruleOnePattern);

        String name4 = "Ms LI YANJUN";
        validateNameMatchesPattern(name4,ruleOnePattern);

        String name5 = "LI YANJUN";
        validateNameMatchesPattern(name5,ruleOnePattern);

        String name6 = " LI YANJUN";
        validateNameMatchesPattern(name6,ruleOnePattern);

        String name7 = "LI YANJUN Mr";
        validateNameMatchesPattern(name7,ruleOnePattern);

    }
}
