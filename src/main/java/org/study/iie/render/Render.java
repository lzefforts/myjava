package org.study.iie.render;

import org.study.iie.base.IbeContext;
import org.study.iie.base.IbeRequest;
import org.study.iie.base.Valve;

/**
 * 1.解析配置的xml模板或者json格式模板
 * 2.把参数填充进xml模板或者json格式模板中
 * @author ArnoldLee
 */
public interface Render extends Valve {



    IbeContext render(IbeRequest request);

}
