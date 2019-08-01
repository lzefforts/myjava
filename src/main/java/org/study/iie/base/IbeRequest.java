package org.study.iie.base;

import org.study.iie.config.Config;

/**
 * 请求实体接口
 * @author ArnoldLee
 */
public interface IbeRequest {


    public void setConfig(Config config);

    public Config getConfig(Config config);

    public void addParamter(String key, Object value);

    public Object getParamter(String key);

    public void setContext(IbeContext ibeContext);

    public IbeContext getContext();

}
