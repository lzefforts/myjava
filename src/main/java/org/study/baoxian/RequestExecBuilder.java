package org.study.baoxian;

import java.util.Deque;
import java.util.Iterator;

/**
 * 执行链的构造者
 * @author ArnoldLee
 * @date 2019/4/15
 */
public class RequestExecBuilder {


    private Request request;
    private RequestContext requestContext;


    public static RequestExecBuilder create(){
        return new RequestExecBuilder();
    }


    /**
     * 默认流程为 下单-核保-支付
     *
     **/
    public Response buildDefault(){
        //下单
        ExecChain execChain = new EmptyExecChain();

        //支付
        execChain = new PayExceChain(execChain);

        //核保
        execChain = new UnderWriteExecChain(execChain);

        //下单
        execChain = new OrderExecChain(execChain);



        this.request = new Request() {
            @Override
            public void setEntity(Object o) {
            }

            @Override
            public Object getEntity() {
                return null;
            }

            @Override
            public void setHolderInfo(HolderInfo holderInfo) {
            }

            @Override
            public HolderInfo getHolderInfo() {
                return null;
            }

            @Override
            public void setInsuredInfo(InsuredInfo insuredInfo) {
            }

            @Override
            public InsuredInfo getInsuredInfo() {
                return null;
            }
        };
        this.requestContext = new BasicRequestContext();
        Response response = null;
        try {
            response = execChain.execute(request,requestContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public ExecChain buildCustom(Deque<AbstractExecChain> execChains){
        Iterator iterator = execChains.iterator();
        AbstractExecChain execChain = null;
        while (iterator.hasNext()){
            if(execChain == null){
                execChain = execChains.pollLast();
            }
            if(execChain != null){
                execChain.nextExecChain(execChains.pollLast());
            }
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            RequestExecBuilder.create().buildDefault();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
