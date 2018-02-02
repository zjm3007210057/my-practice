package sms;

import com.opg.dahan.json.JSONHttpClient;
import org.apache.commons.httpclient.URIException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * send message
 * Created by zjm on 02/02/2018.
 */
public class DaHanSendMessage {

    /**
     * 大汉三通发送短信的url
     */
    private static final String DAHAN_SMS_URL = "http://www.dh3t.com";

    private static JSONHttpClient jsonHttpClient;

    private static Map<String, String> map;

    static {
        try {
            jsonHttpClient = new JSONHttpClient(DAHAN_SMS_URL);
            jsonHttpClient.setRetryCount(1);
            map = Authorilize.getMap();
        } catch (URIException e) {
            System.out.println("创建JSONHttpClient失败，url存在错误：" + e);
        }
    }

    private static final SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");

    public static String sendSms(String phone, String content){
        return jsonHttpClient.sendSms(map.get("dahanKey"), map.get("dahanPwd"), phone, content, map.get("signName"), "", assembleMsgId());
    }

    public static String getReport(){
        return jsonHttpClient.getReport(map.get("dahanKey"), map.get("dahanPwd"));
    }

    /**
     * 组装msgid
     * @return
     */
    private static String assembleMsgId(){
        return  sf.format(new Date()) + (new Random().nextInt(899999) + 100000);
    }

    public static void main(String[] args) {
        String content = "邀请您游玩迪斯尼";
        String phone1 = "18521701268";
        String phone2 = "15102128719";
        String phone3 = "17730686861";
        String sendResult = sendSms(phone2, content);
        String report = getReport();
        System.out.println(sendResult);
        System.out.println(report);
    }
}
