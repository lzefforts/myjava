package org.study.baoxian;

/**
 * 抽象调用链
 * @author ArnoldLee
 * @date 2019/4/15
 */
public abstract class AbstractExecChain implements ExecChain{


    private ExecChain nextExecChain;

    public AbstractExecChain() {
    }

    public ExecChain nextExecChain(ExecChain nextExecChain){
        this.nextExecChain = nextExecChain;
        return nextExecChain;
    }

    protected ExecChain getNextExecChain(){
        return nextExecChain;
    }


}
