package org.study.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by ArnoldLee on 18/6/30.
 */
public class FastJsonTest {

    public static void main(String[] args) {
        String json =
                "{\n" +
//                "\t\"code\":0,\n" +
//                "\t\"msg\":\"未知错误\",\n" +
//                "\t\"data\":{\n" +
                        "\t\t\"policyholder\":{\n" +
                        "\t\t\t\"imgurl\":\"http://www.58jinrong.com/image/1.png\",\n" +
                        "\t\t\t\"titlelabel\":\"投保人\",\n" +
                        "\t\t\t\"items\":[\n" +
                        "\t\t\t\t{\n" +
                        "\t\t            \"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"policyname\",\n" +
                        "\t\t            \"label\": \"姓名\",\n" +
                        "\t\t            \"maxLength\": 10,\n" +
                        "\t\t            \"placeholder\": \"请输入投保人姓名\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"validateConf\": {\n" +
                        "\t\t              \t\"errMsg\": \"请填写真实姓名\",\n" +
                        "\t\t              \t\"rule\": \"isName\"\n" +
                        "\t\t            },\n" +
                        "\t\t            \"value\": \"张三\"\n" +
                        "\t\t        },{\n" +
                        "\t\t            \"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"policycard\",\n" +
                        "\t\t            \"label\": \"身份证号\",\n" +
                        "\t\t            \"maxLength\": 18,\n" +
                        "\t\t            \"placeholder\": \"请填写身份证号\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"validateConf\": {\n" +
                        "\t\t            \t\"errMsg\": \"请填写正确的身份证号\",\n" +
                        "\t\t            \t\"rule\": \"isIdCard\"\n" +
                        "\t\t            },\n" +
                        "\t\t            \"value\": \"510725198601047712\"\n" +
                        "\t          },{\n" +
                        "\t\t            \"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"policyphone\",\n" +
                        "\t\t            \"label\": \"手机号\",\n" +
                        "\t\t            \"maxLength\": 11,\n" +
                        "\t\t            \"placeholder\": \"请填写联系人手机号\",\n" +
                        "\t\t            \"type\": \"TEL\",\n" +
                        "\t\t            \"validateConf\": {\n" +
                        "\t\t              \"errMsg\": \"请填写联系人手机号\",\n" +
                        "\t\t              \"rule\": \"isMobilePhone\"\n" +
                        "\t\t            },\n" +
                        "\t\t            \"value\": \"18711234568\"\n" +
                        "\t          }\n" +
                        "\t\t\t]\n" +
                        "\t\t},\n" +
                        "\t\t\"insureder\":{\n" +
                        "\t\t\t\"imgurl\":\"http://www.58jinrong.com/image/1.png\",\n" +
                        "\t\t\t\"titlelabel\":\"被保人\",\n" +
                        "\t\t\t\"switchtype\":\"switch\",\n" +
                        "\t\t\t\"items\":[\n" +
                        "\t\t\t\t{\n" +
                        "\t\t            \"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"insurename\",\n" +
                        "\t\t            \"label\": \"姓名\",\n" +
                        "\t\t            \"maxLength\": 20,\n" +
                        "\t\t            \"placeholder\": \"请输入被保人姓名\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"validateConf\": {\n" +
                        "\t\t              \t\"errMsg\": \"请填写真实姓名\",\n" +
                        "\t\t              \t\"rule\": \"isName\"\n" +
                        "\t\t            },\n" +
                        "\t\t            \"value\": \"李四\"\n" +
                        "\t\t        },{\n" +
                        "\t\t            \"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"insurecard\",\n" +
                        "\t\t            \"label\": \"身份证号\",\n" +
                        "\t\t            \"maxLength\": 18,\n" +
                        "\t\t            \"placeholder\": \"请输入身份证号\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"validateConf\": {\n" +
                        "\t\t            \t\"errMsg\": \"请填写正确的身份证号\",\n" +
                        "\t\t            \t\"rule\": \"isIdCard\"\n" +
                        "\t\t            },\n" +
                        "\t\t            \"value\": \"510725198601047712\"\n" +
                        "\t          }\n" +
                        "\t\t\t]\n" +
                        "\t\t},\n" +
                        "\t\t\"insureancetime\":{\n" +
                        "\t\t\t\"imgurl\":\"http://www.58jinrong.com/image/1.png\",\n" +
                        "\t\t\t\"titlelabel\":\"保险起期\",\n" +
                        "\t\t\t\"items\":[\n" +
                        "\t\t\t\t{\n" +
                        "\t\t            \"eleKind\": \"DATEPICKER\",\n" +
                        "\t\t            \"id\": \"insuretime\",\n" +
                        "\t\t            \"label\": \"\",\n" +
                        "\t\t            \"type\":\"DATE\",\n" +
                        "\t\t            \"isdisabled\":true,\n" +
                        "\t\t            \"defaulttime\": \"2018-06-20\",\n" +
                        "\t\t            \"options\":{\n" +
                        "\t\t            \t\"maxDate\":\"2018-09-20\",\n" +
                        "\t\t            \t\"minDate\":\"2018-06-20\"\n" +
                        "\t\t            }\n" +
                        "\t\t        }\n" +
                        "\t\t\t]\n" +
                        "\t\t},\n" +
                        "\t\t\"ensureinfo\":{\n" +
                        "\t\t\t\"imgurl\":\"http://www.58jinrong.com/image/1.png\",\n" +
                        "\t\t\t\"titlelabel\":\"保障信息\",\n" +
                        "\t\t\t\"minlength\":1,\n" +
                        "\t\t\t\"items\":[\n" +
                        "\t\t\t\t{\n" +
                        "\t\t            \"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"accountmoney\",\n" +
                        "\t\t            \"label\": \"账户资金\",\n" +
                        "\t\t            \"isdisabled\":true,\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"value\": \"被保人 名下所有银行卡\"\n" +
                        "\t\t        },{\n" +
                        "\t\t            \"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"factorycard\",\n" +
                        "\t\t            \"label\": \"厂牌型号\",\n" +
                        "\t\t            \"maxLength\": 20,\n" +
                        "\t\t            \"placeholder\": \"请尽量填写车辆完整信息\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"value\": \"奥迪A6\",\n" +
                        "\t\t            \"ismust\":true\n" +
                        "\t\t        },{\n" +
                        "\t\t        \t\"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"vehiclecard\",\n" +
                        "\t\t            \"label\": \"车牌号\",\n" +
                        "\t\t            \"maxLength\": 20,\n" +
                        "\t\t            \"placeholder\": \"请尽量填写车辆完整信息\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"value\": \"京NP3566\"\n" +
                        "\t\t        },{\n" +
                        "\t\t        \t\"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"motorcard\",\n" +
                        "\t\t            \"label\": \"电动机号\",\n" +
                        "\t\t            \"maxLength\": 20,\n" +
                        "\t\t            \"placeholder\": \"请尽量填写车辆完整信息\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"value\": \"MP232617315261\"\n" +
                        "\t\t        },{\n" +
                        "\t\t        \t\"eleKind\": \"INPUT\",\n" +
                        "\t\t            \"id\": \"framecard\",\n" +
                        "\t\t            \"label\": \"车架号\",\n" +
                        "\t\t            \"maxLength\": 20,\n" +
                        "\t\t            \"placeholder\": \"请尽量填写车辆完整信息\",\n" +
                        "\t\t            \"type\": \"TEXT\",\n" +
                        "\t\t            \"value\": \"DK787675115\"\n" +
                        "\t\t        }\n" +
                        "\t\t        \n" +
                        "\t\t\t]\n" +
                        "\t\t}\n" +
//                "\t}\n" +
                        "}";

        //查询节点
        String propertyName = "policyholder";
        JSONObject obj = JSON.parseObject(json);
        String propertyValue = obj.get(propertyName).toString();
        System.out.println(propertyValue);

        //插入节点
        obj.put("code","0");
        System.out.println(obj.toJSONString());

        JSONObject newObject = new JSONObject();
        newObject.put("data",obj);
        newObject.put("code","0");
        System.out.println(newObject.toJSONString());

    }
}
