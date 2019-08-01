package org.study.iie.base;

import java.util.Map;

/**
 * 请求结果实体
 * @author ArnoldLee
 */
public class IbeBaseResponse implements IbeResponse{

    private Map<String,Object> paramMap;

    public void addParamter(String key, Object value){
        paramMap.put(key,value);
    }

    public Object getParamter(String key){
        return paramMap.get(key);
    }

}
