package org.study.iie.wrapper;

import org.study.iie.base.IbeRequest;
import org.study.iie.base.IbeResponse;
import org.study.iie.base.Valve;

/**
 * 对象包装抽象类
 * @author ArnoldLee
 */
public abstract class BaseReqWrapper implements RequestWrapper{


    @Override
    public Valve getNext() {
        return null;
    }

    @Override
    public void setNext(Valve valve) {

    }

    @Override
    public IbeResponse execute(IbeRequest request) {
        return null;
    }
}
