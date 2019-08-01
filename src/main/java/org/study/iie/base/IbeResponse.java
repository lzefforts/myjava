package org.study.iie.base;

/**
 * 请求结果接口
 * @author ArnoldLee
 */
public interface IbeResponse {


    /**
     * @param key
     * @param value
     */
    void addParamter(String key, Object value);


    /**
     * @param key
     * @return
     */
    Object getParamter(String key);




}
