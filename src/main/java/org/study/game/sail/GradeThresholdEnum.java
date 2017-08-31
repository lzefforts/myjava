package org.study.game.sail;

/**
 * Created by ArnoldLee on 17/6/25.
 */
public enum GradeThresholdEnum {

    ZERO("0","0级"),

    FIFTEEN("15","15级"),

    TWENTY_FIVE("25","25级"),

    THIRTY_FIVE("35","35级"),

    FORTY_FIVE("45","45级"),

    FIFTY_FIVE("55","55级"),

    SIXTY_FIVE("65","65级"),

    SENVENTY_FIVE("75","75级"),

    EIGHTY_FIVE("85","85级"),

    NINTY_FIVE("95","95级");


    private String grade;
    private String name;

    private GradeThresholdEnum(String grade,String name){
        this.grade = grade;
        this.name = name;
    }

}
