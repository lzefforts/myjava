package org.study.iie.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArnoldLee
 */
public abstract class AbstractConfig implements Config {

    private Map<String,Object> configMap = new HashMap<>();

    @Override
    public void setRequestType(RequestTypeEnum requestTypeEnum) {

    }

    @Override
    public void setRequestUrl(String url) {

    }

    @Override
    public void setRequestContentTemplate(String template) {

    }

    @Override
    public void setResponseContentTemplate(String template) {

    }
}
