package com.qtz.ht.order.spi.rpt.common;

/**
 * Created by thunder on 2016/3/12.
 */
public class RptConstans {

    /** 最开始的付款时间2015年10月11日9时 */
    public static final Long MINTIMESTAMP = 1444525200000L;

    /** 2016/3/20 16:3:31  超过该时间接单后，钱包记录要从其他表查找*/
    public static final Long THRESHOLDTIME = 1458461011903L;

    /** 一周的毫秒数 */
    public static final Long MILLISECONDPERWEEK = 7*24*60*60*1000L;

    /** 每次处理多少个订单*/
    public static final int STATNUM = 1000;

    /** 每次处理多少个提现*/
    public static final int STATDRAWNUM = 1000;

    /** 一天多少毫秒 */
    public static final Long MILLISECONDPERDAY = 24*60*60*1000L;

    /** 一级分润比例 */
    public static final double FIRSTPROFIT = 0.05d;

    /** 二级分润比例 */
    public static final double SECONDPROFIT = 0.06d;

    /** 三级分润比例 */
    public static final double THIRDPROFIT = 0.09d;

    /** 代理商分润比例 */
    public static final double AGENTPROFIT = 0.35d;

}
