package org.study.clone;

/**
 * Created by ArnoldLee on 18/6/5.
 */
public class Card implements Cloneable{

    private String cardNo;

    public Card(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }


}
