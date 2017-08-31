package org.study.game.sail;

import java.math.BigDecimal;

/**
 * 商品种类
 * Created by ArnoldLee on 17/6/25.
 */
public enum GoodsEnum {

    PEEK("0","猪肉",BigDecimal.valueOf(234.23)),

    DIAMOND("1","钻石",BigDecimal.valueOf(3503));


    private String code;
    private String name;
    private BigDecimal price;

    GoodsEnum(String code, String name, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
}
