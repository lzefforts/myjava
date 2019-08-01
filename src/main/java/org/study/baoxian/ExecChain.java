package org.study.baoxian;

/**
 * 责任链接口
 *
 * @author ArnoldLee
 * @date 2019/4/15
 */
public interface ExecChain {


    Response execute(Request request,
                     RequestContext requestContext) throws Exception;

}
