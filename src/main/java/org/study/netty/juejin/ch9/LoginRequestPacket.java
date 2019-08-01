package org.study.netty.juejin.ch9;

import lombok.Data;

import static org.study.netty.juejin.ch9.Command.LOGIN_REQUEST;

/**
 * Created by ArnoldLee on 18/10/16.
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }
}
