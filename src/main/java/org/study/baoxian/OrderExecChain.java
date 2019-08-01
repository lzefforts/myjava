package org.study.baoxian;

import org.apache.http.util.Args;

/**
 * 下单
 * @author ArnoldLee
 * @date 2019/4/15
 */
public class OrderExecChain implements ExecChain {

    private ExecChain execChain;

    public OrderExecChain(ExecChain execChain) {
        this.execChain = execChain;
    }

    @Override
    public Response execute(final Request request,
                            final RequestContext requestContext) throws Exception {
        Args.notNull(request, "request");
        Args.notNull(requestContext, "requestContext");
        System.out.printf("######OrderExecChain\n");

        return this.execChain.execute(request, requestContext);
    }
}
