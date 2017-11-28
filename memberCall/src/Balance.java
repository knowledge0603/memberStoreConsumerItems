
public class Balance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String place = GetService.getServiceResult("http://service.i000.member.aaazx.com",//访问包名
			   "http://127.0.0.1:8080/member/webservice/IMemberTranscation", //URL地址
			   "memberTranscation", //访问方法名
			   "1586", //会员卡号
			   "5",//消费金额
			   "1",//消费时间
			   "1.2"//消费内容
	     );
		System.out.println("place"+place.toString());
	}
}
