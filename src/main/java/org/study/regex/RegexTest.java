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

    private static String combinTarBankAccName(String tarBankAccName,String currency,String sex){
        String patternStart = "^";
        String patternEnd = "$";

        String newTarBankAccName = "";

        int left1 = tarBankAccName.indexOf("(");
        int left2 = tarBankAccName.indexOf("（");
        int right1 = tarBankAccName.indexOf(")");
        int right2 = tarBankAccName.indexOf("）");

        int left = left1==-1?left2:left1;
        int right = right1==-1?right2:right1;

        System.out.println(left);
        System.out.println(right);


        if(left >=0 && right>=0 && right>left){
            newTarBankAccName = tarBankAccName.substring(0,left)+"(\\\\\\\\(|（)";
            newTarBankAccName += tarBankAccName.substring(left+1,right)+"(\\\\\\\\)|）)"+tarBankAccName.substring(right+1);
        }

//        tarBankAccName = tarBankAccName.replaceAll("\\(|（","(\\\\\\\\(|（)");
//        tarBankAccName = tarBankAccName.replaceAll("\\)|）","(\\\\\\\\)|）)");
        newTarBankAccName = newTarBankAccName.replaceAll("\\.","\\\\.");

        if ("0".equals(currency)) {
            String result = patternStart+newTarBankAccName+patternEnd;
            return result;
        }
        //用于美元等的匹配流水查询格式
        String patternUSDStart = "((MRS |MISS |MS )?)";
        if("0".equals(sex)){
            patternUSDStart = "((MR )?)";
        }
        String result = patternStart+patternUSDStart+newTarBankAccName+patternEnd;
        return result;
    }


    public static boolean checkChineseBrackets(String tarBankAccName,String investApplyBankAccountName){
        String newTarBankAccName = tarBankAccName.replace("（","(");
        newTarBankAccName = newTarBankAccName.replace("）",")");

        String newInvestApplyBankAccountName = investApplyBankAccountName.replace("（","(");
        newInvestApplyBankAccountName = newInvestApplyBankAccountName.replace("）",")");

        if(newTarBankAccName.equals(newInvestApplyBankAccountName)){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String testA = "哈哈（阿斯蒂芬撒好地方)";
        System.out.println(combinTarBankAccName(testA,"0","0"));
        String testB = "哈哈（阿斯蒂芬撒好地方）";
        String testC = "哈哈阿斯蒂芬撒好地方";
        System.out.println(checkChineseBrackets(testA,testB));
        System.out.println(testA+"#######"+testB);
        System.out.println(checkChineseBrackets(testB,testC));




//        String name = "Mr Zhang San";
//        validateNameMatchesPattern(name,ruleOnePattern);
//
//        String name2 = "Miss LI YANJUN";
//        validateNameMatchesPattern(name2,ruleOnePattern);
//
//        String name3 = "Mrs LI YANJUN";
//        validateNameMatchesPattern(name3,ruleOnePattern);
//
//        String name4 = "Ms LI YANJUN";
//        validateNameMatchesPattern(name4,ruleOnePattern);
//
//        String name5 = "LI YANJUN";
//        validateNameMatchesPattern(name5,ruleOnePattern);
//
//        String name6 = " LI YANJUN";
//        validateNameMatchesPattern(name6,ruleOnePattern);
//
//        String name7 = "LI YANJUN Mr";
//        validateNameMatchesPattern(name7,ruleOnePattern);

    }
}
