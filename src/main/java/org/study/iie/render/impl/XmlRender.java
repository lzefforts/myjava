package org.study.iie.render.impl;

import org.study.iie.base.IbeContext;
import org.study.iie.base.IbeRequest;
import org.study.iie.base.Valve;
import org.study.iie.render.BaseRender;

public class XmlRender extends BaseRender {
    @Override
    public IbeContext analysis(IbeRequest request) {
        return null;
    }

    @Override
    public IbeContext renderParam(IbeRequest request) {
        return null;
    }

    @Override
    public void setNext(Valve valve) {
        super.setNext(valve);

    }
}
