package org.study.iie;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.iie.base.IbeRequest;
import org.study.iie.base.IbeResponse;
import org.study.iie.connector.Connector;
import org.study.iie.parser.Parser;
import org.study.iie.render.BaseRender;
import org.study.iie.wrapper.BaseReqWrapper;

/**
 * @author ArnoldLee
 */
public class Processer {

    @Autowired
    BaseRender baseRender;

    @Autowired
    private BaseReqWrapper baseReqWrapper;

    @Autowired
    private Connector connector;

    @Autowired
    private Parser parser;

    private void setExecuteChain(){
        baseRender.setNext(baseReqWrapper);
        baseReqWrapper.setNext(connector);
        connector.setNext(parser);
    }

    public IbeResponse process(IbeRequest request){
        setExecuteChain();
        return baseReqWrapper.execute(request);
    }


    public IbeResponse process(String reqJson){
        //1.根据productCode从redis中获取

        return null;
    }




}
