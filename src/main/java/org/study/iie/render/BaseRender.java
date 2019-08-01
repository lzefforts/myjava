package org.study.iie.render;

import org.study.iie.base.IbeContext;
import org.study.iie.base.IbeRequest;
import org.study.iie.base.IbeResponse;
import org.study.iie.base.Valve;

/**
 * @author ArnoldLee
 */
public abstract class BaseRender implements Render {


    private Valve valve;

    public abstract IbeContext analysis(IbeRequest request);

    public abstract IbeContext renderParam(IbeRequest request);

    @Override
    public final IbeContext render(IbeRequest request) {
        this.analysis(request);
        IbeContext context = this.renderParam(request);
        return context;
    }

    @Override
    public Valve getNext() {
        return this.valve;
    }

    @Override
    public void setNext(Valve valve) {
        this.valve = valve;
    }

    @Override
    public IbeResponse execute(IbeRequest request) {
        render(request);
        return getNext().execute(request);
    }
}
