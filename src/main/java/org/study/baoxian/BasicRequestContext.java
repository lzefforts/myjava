package org.study.baoxian;

import org.apache.http.util.Args;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * basic的请求上下文
 * @author ArnoldLee
 * @date 2019/4/15
 */
public class BasicRequestContext implements RequestContext {

    private final RequestContext parentContext;
    private final Map<String, Object> map;

    public BasicRequestContext() {
        this(null);
    }

    public BasicRequestContext(final RequestContext parentContext) {
        super();
        this.map = new ConcurrentHashMap<String, Object>();
        this.parentContext = parentContext;
    }

    @Override
    public Object getAttribute(final String id) {
        Args.notNull(id, "Id");
        Object obj = this.map.get(id);
        if (obj == null && this.parentContext != null) {
            obj = this.parentContext.getAttribute(id);
        }
        return obj;
    }

    @Override
    public void setAttribute(final String id, final Object obj) {
        Args.notNull(id, "Id");
        if (obj != null) {
            this.map.put(id, obj);
        } else {
            this.map.remove(id);
        }
    }

    @Override
    public Object removeAttribute(final String id) {
        Args.notNull(id, "Id");
        return this.map.remove(id);
    }

    public void clear() {
        this.map.clear();
    }

    @Override
    public String toString() {
        return this.map.toString();
    }

}
