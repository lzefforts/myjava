package org.study.game.sail;

/**
 * 港口
 * Created by ArnoldLee on 17/6/25.
 */
public enum PortEnum {
    Sevilla("0","塞维利亚",NationEnum.SPAIN,PortAttributeEnum.NATIVE),

    Barcelona("1","巴塞罗那",NationEnum.SPAIN,PortAttributeEnum.NATIVE),

    Malaga("2","马拉加",NationEnum.SPAIN,PortAttributeEnum.NATIVE),

    Valencia("3","瓦伦西亚",NationEnum.SPAIN,PortAttributeEnum.NATIVE),

    Mallorca("4","马洛卡",NationEnum.SPAIN,PortAttributeEnum.ALLIANCE),





    ;


    private String code;
    private String name;
    private NationEnum nationEnum;
    private PortAttributeEnum portAttributeEnum;

    PortEnum(String code, String name, NationEnum nationEnum, PortAttributeEnum portAttributeEnum) {
        this.code = code;
        this.name = name;
        this.nationEnum = nationEnum;
        this.portAttributeEnum = portAttributeEnum;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public NationEnum getNationEnum() {
        return nationEnum;
    }

    public PortAttributeEnum getPortAttributeEnum() {
        return portAttributeEnum;
    }

    private enum  PortAttributeEnum {

        NATIVE("0","本土领地"),

        ALLIANCE("1","同盟港");


        private String code;
        private String name;

        PortAttributeEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
