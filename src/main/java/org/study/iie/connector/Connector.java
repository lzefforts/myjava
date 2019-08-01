package org.study.iie.connector;

import org.study.iie.base.IbeRequest;
import org.study.iie.base.IbeResponse;
import org.study.iie.base.Valve;

/**
 * 1.发送http请求
 * 2.失败重试
 * @author ArnoldLee
 */
public interface Connector extends Valve {


    IbeResponse doRequest(IbeRequest request);

}
