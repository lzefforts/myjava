package org.study.netty.juejin.ch9;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by ArnoldLee on 18/10/16.
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();
}
