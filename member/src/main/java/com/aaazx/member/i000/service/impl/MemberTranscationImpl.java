package com.aaazx.member.i000.service.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.aaazx.member.i000.service.IMemberTranscation;


/**
 * @Project: member
 * @package: com.aaazx.member.i000.service.impl
 * @filename: GetStudentNameImpl
 * @date：2013-05-20
 * @author: guoruijun
 * @desc: 实现会员余额网上消费功能,
 * 理发店顾客进入理发店消费时,
 * 其中一种消费方式是办会员卡消费,
 * 顾客在会员卡存值后，会员卡有余额,
 * 顾客利用余额在指定的网上消费,
 * 消费时会员卡金额实现自动扣除。
 */
@Service
public class MemberTranscationImpl extends JdbcDaoSupport implements
  IMemberTranscation {
    /**
     * @param memberId
     *            会员卡号
     * @param amount
     *            消费金额
     *  @param time          
     *            消费时间
     *  @param content          
     *            消费内容
     * @return result 
     *            返回结果
     */
    private static Logger LOG  = Logger.getLogger(MemberTranscationImpl.class);
    @SuppressWarnings("unchecked")
	public    List<String>    memberTranscation(
    		String memberId, //会员卡号
    		String amount,   //消费金额
    		String time,     //消费时间
    		String content   //消费内容
        ) {
    	/* 以下是  数据库访问  Mysql 版本     */
    	String sql = "select mbalance  from member where mid = ? ";
	        List<String>   balance = new ArrayList<String>();
	        try {
	        	balance = getJdbcTemplate().query(sql,
	                    new Object[] { memberId }, new RowMapper() {
	                        public Object mapRow(ResultSet rs, int rows)
	                                throws SQLException {
	                            String str = new String();
	                            str = rs.getString("mbalance");
	                            return str;
	                        }
	                    });
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	        }
	        if(balance.size()==0){
	        	List<String>   balance2 = new ArrayList<String>();
    	        balance2.add(0, "failure");
            	return balance2;
	        }else{
		        Double temp1 = Double.parseDouble( balance.get(0).toString())-Double.parseDouble(amount);
		        String sql1 = "update  member  set mbalance= "+ temp1+ " where mid = '"+memberId+"'"  ;
		        try {
		        	int	status = getJdbcTemplate().update(sql1);
		        } catch (Exception e) {
		            LOG.error(e.getMessage());
		        }
		        return balance; 
	        }
	        
	        /* 以下是  数据库访问  SqlServer 版本  
	        //加载驱动程序
	        try {
	            //直接连接
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        } catch (ClassNotFoundException ex) {
	        }
	        String[]temp3 =new String[10];
	        int i=0;
	        //连接字符串
	        String str = "jdbc:sqlserver://192.168.0.101:1433;DatabaseName=BHairDB";
	        try {
	            Connection con = DriverManager.getConnection(str,"sa","123");
	            Statement sta = con.createStatement();
	            ResultSet res = sta.executeQuery("select mbalance from member where mid = " +memberId +"");
	            while(res.next()) {
	            	temp3[i]= res.getBigDecimal("mbalance").toString();
	            	i++;
	            }
	            if(i==2){
		            Double temp1 = Double.parseDouble(temp3[0] )-Double.parseDouble(amount);
		            sta.execute("update  member  set mbalance= "+ temp1+ " where mid = '"+memberId+"'" );
	            }
	            res.close();
	            sta.close();
	            con.close();
	        } catch (SQLException ex1) {
	            ex1.printStackTrace();
	        }
            if(i!=2){
            	List<String>   balance1 = new ArrayList<String>();
    	        balance1.add(0, "failure");
            	return balance1;
            }else{
    	        List<String>   balance2 = new ArrayList<String>();
    	        balance2.add(0, "success");
                return balance2 ;      	
            }*/ 
	}
    //15049173633
	
}