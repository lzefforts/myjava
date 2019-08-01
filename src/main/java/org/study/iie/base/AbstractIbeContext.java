package org.study.iie.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArnoldLee
 */
public abstract class AbstractIbeContext implements IbeContext{

    /**
     * 上下文参数Map
     **/
    public Map<String,Object> paramMap = new HashMap<>();

    @Override
    public void setRequestId(String requestId) {
        paramMap.put("requestId",requestId);
    }

    @Override
    public String getRequestId() {
        return paramMap.get("requestId")==null?null:paramMap.get("requestId").toString();
    }

    @Override
    public void addParamter(String key, Object value) {
        paramMap.put(key,value);
    }

    @Override
    public Object getParamter(String key) {
        return paramMap.get(key);
    }
}
