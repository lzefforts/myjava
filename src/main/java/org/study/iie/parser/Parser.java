package org.study.iie.parser;

import org.study.iie.base.IbeRequest;
import org.study.iie.base.IbeResponse;
import org.study.iie.base.Valve;

/**
 * @author ArnoldLee
 */
public interface Parser extends Valve {


    IbeResponse parse(IbeRequest request);

}
