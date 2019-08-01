package org.study.iie.connector;

import org.study.iie.base.IbeRequest;
import org.study.iie.base.IbeResponse;
import org.study.iie.base.Valve;

import java.util.Objects;

/**
 * @author ArnoldLee
 */
public abstract class BaseConnector implements Connector {

    private Valve valve;

    @Override
    public IbeResponse doRequest(IbeRequest request) {
        return null;
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
        IbeResponse response = doRequest(request);
        if(Objects.nonNull(getNext())){
            return getNext().execute(request);
        }
        return response;
    }
}
