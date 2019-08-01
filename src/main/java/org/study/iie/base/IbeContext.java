package org.study.iie.base;

/**
 * 上下文信息
 * 存储的信息为：{
 *     1.requestId（请求唯一id）
 *     2.解析后的模板
 *     3.拼装参数后的字符串
 *     4.加密后的请求内容
 *     5.签名
 *     6.
 * }
 * @author ArnoldLee
 */
public interface IbeContext {


    void setRequestId(String requestId);

    String getRequestId();

    public void addParamter(String key, Object value);

    public Object getParamter(String key);

}
