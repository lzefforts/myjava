package org.study.game.sail;

/**
 * 帆船的类型
 * Created by ArnoldLee on 17/6/25.
 */
public enum ShipTypeNum {

    FISHER("0","小型渔船",GradeThresholdEnum.ZERO),

    CARAVEL("1","卡拉维尔帆船",GradeThresholdEnum.FIFTEEN),

    SLOOP("2","单桅纵帆船",GradeThresholdEnum.FIFTEEN),

    CARRACK("3","卡拉克帆船",GradeThresholdEnum.TWENTY_FIVE),

    LIGHT_GALLEY("4","轻型桨帆船",GradeThresholdEnum.TWENTY_FIVE),

    ARABIA_SAILING_LIGHT("5","轻型阿拉伯帆船",GradeThresholdEnum.THIRTY_FIVE),

    RETURN_VESSEL("6","樽回船",GradeThresholdEnum.THIRTY_FIVE),

    HOLLAND_SAILING("7","荷兰式帆船",GradeThresholdEnum.THIRTY_FIVE),

    DE_ROMON_GALLEY("8","德罗蒙桨帆船",GradeThresholdEnum.FORTY_FIVE),

    CHOONER_DRAGULESCU("9","斯库纳纵帆船",GradeThresholdEnum.FORTY_FIVE),

    SEBEK_SAILING("10","谢贝克帆船",GradeThresholdEnum.FORTY_FIVE),

    LARGE_JUNK("11","沙船",GradeThresholdEnum.FORTY_FIVE),

    GALLEON("12","盖伦帆船",GradeThresholdEnum.FIFTY_FIVE),

    LIGHT_SAILING("13","轻型雷萨帆船",GradeThresholdEnum.FIFTY_FIVE),

    GUANG_CHUAN("14","广船",GradeThresholdEnum.FIFTY_FIVE),

    FRIGATE("15","护卫舰",GradeThresholdEnum.SIXTY_FIVE),

    NAPLES_GALLEY("15","那不勒斯桨帆船",GradeThresholdEnum.SIXTY_FIVE),

    ATAKEBUNE("16","安宅船",GradeThresholdEnum.SIXTY_FIVE),

    BATTLE_SHIP("17","战列舰",GradeThresholdEnum.SENVENTY_FIVE),

    GIANT_CALAIS_GALLEY("18","巨型加莱桨帆船",GradeThresholdEnum.SENVENTY_FIVE),

    LARGE_SCHOONER("19","大型斯库纳纵帆船",GradeThresholdEnum.EIGHTY_FIVE),

    HEAVY_SEBEK("20","重型谢贝克战舰",GradeThresholdEnum.EIGHTY_FIVE),

    FU_CHUAN("21","福船",GradeThresholdEnum.EIGHTY_FIVE),

    ARMORED_BATTLE_SHIP("22","装甲战列舰",GradeThresholdEnum.NINTY_FIVE),

    VENICE_SAIL_SHIP("23","威尼斯桨帆战舰",GradeThresholdEnum.NINTY_FIVE),

    TURTLE_SHIP("24","龟甲船",GradeThresholdEnum.NINTY_FIVE);


    private String code;
    private String description;
    private GradeThresholdEnum gradeThresholdEnum;


    private ShipTypeNum(String code,String description,GradeThresholdEnum gradeThresholdEnum){
        this.code = code;
        this.description = description;
        this.gradeThresholdEnum = gradeThresholdEnum;
    }

}
