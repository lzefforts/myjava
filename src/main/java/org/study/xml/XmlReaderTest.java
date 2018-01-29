package org.study.xml;

import org.study.lombok.ShowVo;

import java.util.TreeMap;

/**
 * Created by ArnoldLee on 17/9/11.
 */
public class XmlReaderTest {
    public class showVo{
        private String accNo;
        private String transId;

        public String getAccNo() {
            return accNo;
        }

        public void setAccNo(String accNo) {
            this.accNo = accNo;
        }

        public String getTransId() {
            return transId;
        }

        public void setTransId(String transId) {
            this.transId = transId;
        }
    }


    public enum TestEnum{
        AA("1","aa"),
        BB("2","bb");

        private String code;
        private String name;

        TestEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }


    public static void main(String[] args) {
//        XmlReaderUtils<ShowVo> utils = new XmlReaderUtils<ShowVo>();
//
//        utils.parseXmlPojo("classpath:xml/noMatchArrivalFlowList.xml",ShowVo.class,"column");


//        int result = (int)((Math.random()*9+1)*100000);
//        System.out.println(result);
//
//
//        String str = TestEnum.AA.toString();
//        System.out.println(str);

        TreeMap<String,TestEnum> treeMap = new TreeMap<>();
        treeMap.put("12",TestEnum.BB);

        treeMap.put("1",TestEnum.AA);
        for(String code : treeMap.keySet()){
            TestEnum testEnum = treeMap.get(code);
            System.out.println(testEnum.getName());
        }


    }
}
