package org.study.netty.juejin.ch9;


import lombok.Data;

import static org.study.netty.juejin.ch9.Command.LOGIN_RESPONSE;
/**
 * Created by ArnoldLee on 18/10/16.
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
