
public class Balance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String place = GetService.getServiceResult("http://service.i000.member.aaazx.com",//���ʰ���
			   "http://127.0.0.1:8080/member/webservice/IMemberTranscation", //URL��ַ
			   "memberTranscation", //���ʷ�����
			   "1586", //��Ա����
			   "5",//���ѽ��
			   "1",//����ʱ��
			   "1.2"//��������
	     );
		System.out.println("place"+place.toString());
	}
}
