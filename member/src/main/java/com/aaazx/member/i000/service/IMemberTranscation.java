package com.aaazx.member.i000.service;

import java.util.List;

/**
 * @Project: member
 * @package: com.aaazx.member.i000.service
 * @filename: MemberTranscation
 * @date：2015-05-19
 * @author: guoruijun
 * @desc: 实现会员余额网上消费功能,
 * 理发店顾客进入理发店消费时,
 * 其中一种消费方式是办会员卡消费,
 * 顾客在会员卡存值后，会员卡有余额,
 * 顾客利用余额在指定的网上消费,
 * 消费时会员卡金额实现自动扣除。
 */
public interface IMemberTranscation {

    /**
     * @param memberId
     *            会员卡号
     * @param amount
     *            消费金额
     *  @param time          
     *            消费时间
     *  @param content          
     *            消费内容
     */
    public  List<String> memberTranscation( 
	    		String memberId, //会员卡号
	    		String amount,   //消费金额
	    		String time,     //消费时间
	    		String content   //消费内容
    		);
}
