package org.study.baoxian;

/**
 * Created by ArnoldLee on 2019/4/15.
 */
public class EmptyExecChain implements ExecChain {

    private ExecChain execChain;
    public EmptyExecChain() {
        System.out.printf("do nothing...\n");
    }

    @Override
    public Response execute(Request request, RequestContext requestContext) throws Exception {
        if(this.execChain == null){
            return null;
        }
        return this.execChain.execute(request,requestContext);
    }
}
