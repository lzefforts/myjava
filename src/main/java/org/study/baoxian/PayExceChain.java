package org.study.baoxian;

import org.apache.http.util.Args;

/**
 * 支付
 * @author ArnoldLee
 * @date 2019/4/15
 */
public class PayExceChain implements ExecChain {

    private ExecChain execChain;

    public PayExceChain(ExecChain execChain) {
        this.execChain = execChain;
    }

    @Override
    public Response execute(final Request request,
                            final RequestContext requestContext) throws Exception {
        Args.notNull(request, "request");
        Args.notNull(requestContext, "requestContext");
        System.out.printf("######PayExceChain\n");


        return this.execChain.execute(request,requestContext);
    }
}
