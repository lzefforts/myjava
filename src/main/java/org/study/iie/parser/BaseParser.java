package org.study.iie.parser;

import org.study.iie.base.IbeContext;
import org.study.iie.base.IbeRequest;
import org.study.iie.base.IbeResponse;
import org.study.iie.base.Valve;

import java.util.Objects;

/**
 * @author ArnoldLee
 */
public abstract class BaseParser implements Parser {

    private Valve valve;

    public abstract IbeResponse parseInternal(IbeRequest request);

    @Override
    public Valve getNext() {
        return this.valve;
    }

    @Override
    public void setNext(Valve valve) {
        this.valve = valve;
    }

    @Override
    public final IbeResponse parse(IbeRequest request) {
        return parseInternal(request);
    }



    @Override
    public IbeResponse execute(IbeRequest request) {
        IbeResponse response = parse(request);
        if(Objects.nonNull(getNext())){
            return getNext().execute(request);
        }
        return response;
    }
}
