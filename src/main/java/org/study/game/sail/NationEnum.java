package org.study.game.sail;

/**
 * 国家
 * Created by ArnoldLee on 17/6/25.
 */
public enum NationEnum {

    ENGLAND("0","英格兰"),

    SPAIN("1"," 西班牙"),

    PORTUGAL("2","葡萄牙"),

    HOLLAND("3","荷兰"),

    FRANCE("4","法国"),

    OTTOMAN("5","奥斯曼土耳其");


    private String code;
    private String name;

    NationEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
