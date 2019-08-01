package org.study.spi;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Created by ArnoldLee on 2019/1/12.
 */
public class SpiMain {

    public static void main(String[] args) {
        ServiceLoader<ICard> serviceLoader = ServiceLoader.load(ICard.class);
        Map<String,Object> beanMap = new HashMap<>();
        for (ICard card : serviceLoader){
            card.display();
            System.out.printf("SimpleName:%s\n",card.getClass().getSimpleName());
            beanMap.put(card.getClass().getSimpleName(),card);
        }
        System.out.printf("beanMap:%s\n",beanMap.size());
    }

}
