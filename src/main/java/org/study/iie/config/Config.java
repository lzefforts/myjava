package org.study.iie.config;

/**
 * 配置信息接口
 * @author ArnoldLee
 */
public interface Config {


    void setRequestType(RequestTypeEnum requestTypeEnum);

    void setRequestUrl(String url);

    void setRequestContentTemplate(String template);

    void setResponseContentTemplate(String template);

}
