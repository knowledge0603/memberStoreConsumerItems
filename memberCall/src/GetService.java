import java.io.IOException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;



public class GetService {
	/**
	 * 调用webservice，获取服务器端返回题目数据
	 * @param NAMESPACE 访问的方法名
	 * @param URL 接口地址
	 * @param METHODNAME 域名空间
	 * @param grade 年级
	 * @param subject 科目
	 * @param teacherId 教师id号
	 * @return String
	 */
	public static String getServiceResult(String nameSpace, String url,
			String methodName, String grade,String classNo, String subject,
			String teacherId) {
		String result = null;
		SoapObject soapobj;
		soapobj = new SoapObject(nameSpace, methodName);
		soapobj.addProperty("grade", grade);	
		soapobj.addProperty("classNo", classNo);
		soapobj.addProperty("subject", subject);
		soapobj.addProperty("userId", teacherId);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.bodyOut = soapobj;
		HttpTransportSE ht = new HttpTransportSE(url);
		ht.debug = true;
		try {
			ht.call(nameSpace + methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
		try {
			soapobj = (SoapObject) envelope.getResponse();
			result = soapobj.toString();
		
		} catch (SoapFault e) {			
			e.printStackTrace();
		}
		return result;
	}
}
