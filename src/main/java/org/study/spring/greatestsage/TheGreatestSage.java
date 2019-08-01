package org.study.spring.greatestsage;

import java.io.*;
import java.time.LocalDateTime;

/**
 *
 * 齐天大圣
 * Created by ArnoldLee on 18/11/21.
 */
public class TheGreatestSage extends Monkey implements Serializable {

    private static final long serialVersionUID = 1590762209060640450L;
    GoldRingedStaff goldRingedStaff;

    public TheGreatestSage() {
        this.goldRingedStaff = new GoldRingedStaff();
        this.birthday = LocalDateTime.now();
        this.height = 150;
        this.weight = 30;
    }

    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //序列化
            oos.writeObject(this);

            //反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            TheGreatestSage copy = (TheGreatestSage)ois.readObject();
            return copy;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //大圣七十二变
    public void change(){
        try {
            TheGreatestSage sage = (TheGreatestSage)this.clone();
            System.out.println("大圣本尊生日是:"+this.birthday);
            System.out.println("大圣七十二变后的生物的生日是:"+sage.birthday);
            System.out.println("大圣本尊是否等于变化后的生物:"+(this==sage));
            System.out.println("大圣本尊持有的金箍棒是否等于变化后的生物持有的:"+(this.goldRingedStaff==sage.goldRingedStaff));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public GoldRingedStaff getGoldRingedStaff() {
        return goldRingedStaff;
    }

    public void setGoldRingedStaff(GoldRingedStaff goldRingedStaff) {
        this.goldRingedStaff = goldRingedStaff;
    }

}
