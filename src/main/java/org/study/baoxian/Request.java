package org.study.baoxian;

/**
 * 保险请求接口
 * @author ArnoldLee
 * @date 2019/4/15
 */
public interface Request<T> {


    void setEntity(T t);

    T getEntity();

    void setHolderInfo(HolderInfo holderInfo);

    HolderInfo getHolderInfo();

    void setInsuredInfo(InsuredInfo insuredInfo);

    InsuredInfo getInsuredInfo();

}
