package org.study.iie.base;

import org.study.iie.config.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求实体
 * @author ArnoldLee
 */
public class IbeBaseRequest implements IbeRequest{

    /**
     * 请求参数Map
     **/
    public Map<String,Object> paramMap = new HashMap<>();

    /**
     * 配置信息
     **/
    public Config config;

    private IbeContext ibeContext;

    @Override
    public void setConfig(Config config){
        this.config = config;
    }

    @Override
    public Config getConfig(Config config) {
        return this.config;
    }

    @Override
    public void addParamter(String key, Object value){
        paramMap.put(key,value);
    }

    @Override
    public Object getParamter(String key){
        return paramMap.get(key);
    }

    @Override
    public void setContext(IbeContext ibeContext) {
        this.ibeContext = ibeContext;
    }

    @Override
    public IbeContext getContext() {
        return this.ibeContext;
    }

}
