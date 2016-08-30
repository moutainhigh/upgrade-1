package com.qtz.ht.order.spi.rpt.common;

/**
 * Created by thunder on 2016/3/17.
 */
public enum RptStatTypeEnum {
    /**
     * 统计类型0天,1周,2月,3年
     */
    DAY(0),
    WEEK(1),
    MONTH(2),
    YEAR(3);

    private int val;

    RptStatTypeEnum(int _val){
        this.val = _val;
    }

    public int value(){
        return this.val;
    }

    @Override
    public String toString() {
        return "RptStatTypeEnum{" +
                "val=" + val +
                '}';
    }
}
