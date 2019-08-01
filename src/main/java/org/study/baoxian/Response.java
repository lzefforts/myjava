package org.study.baoxian;

/**
 * 请求结果
 * @author ArnoldLee
 * @date 2019/4/15
 */
public interface Response {


    void setErrorMsg(String msg);

    String getErrorMsg();

    boolean success();

}
