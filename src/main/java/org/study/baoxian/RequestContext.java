package org.study.baoxian;

/**
 * 请求上下文
 * @author ArnoldLee
 * @date 2019/4/15
 */
public interface RequestContext {

    /**
     * 根据id获取属性
     */
    Object getAttribute(String id);

    /**
     * 设置属性
     */
    void setAttribute(String id, Object obj);

    /**
     * 删除属性
     */
    Object removeAttribute(String id);

}
