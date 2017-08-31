package org.study.rpc;

import java.math.BigDecimal;

/**
 * Created by ArnoldLee on 16/12/29.
 */
public class OutPut {

    public BigDecimal getResult(BigDecimal result){
        return result.multiply(new BigDecimal("2"));
    }
}
