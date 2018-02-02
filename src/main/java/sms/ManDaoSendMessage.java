package sms;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zjm on 02/02/2018.
 */
public class ManDaoSendMessage {

    private static final String serviceURL = "http://sdk.entinfo.cn:8061/webservice.asmx";

    private static final Pattern patternMdget = Pattern.compile("<mdgetSninfoResult>(.*)</mdgetSninfoResult>");

    private static final Pattern patternMdgxsend = Pattern.compile("<mdgxsendResult>(.*)</mdgxsendResult>");

    private static final Pattern patternMdsmssend = Pattern.compile("<mdsmssendResult>(.*)</mdsmssendResult>");

    /**
     * 时间前缀
     */
    private final String DATA_FARMAT_PREFIX = "yyMMddHHmmss";

    /**
     * 日期格式化工具
     */
    private SimpleDateFormat sf = new SimpleDateFormat(DATA_FARMAT_PREFIX);

    private static Map<String, String> map = Authorilize.getMap();

    /**
     * 方法名称：getMD5 功 能：字符串MD5加密 参 数：待转换字符串 返 回 值：加密之后字符串
     */
    public String getMD5(String sourceStr) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("");
        try {
            byte[] temp = sourceStr.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(temp);
            byte[] b = md5.digest();
            for (int i = 0; i < b.length; i++) {
                char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
                        'D', 'E', 'F' };
                char[] ob = new char[2];
                ob[0] = digit[(b[i] >>> 4) & 0X0F];
                ob[1] = digit[b[i] & 0X0F];
                sb.append(ob);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 发送短信
     * @param phoneNos 手机号
     * @param content 短信内容
     * @param ext 扩展码
     * @param stime 定时时间
     * @param rrid 唯一标识
     * @param msgfmt 内容编码
     * @return
     * @throws IOException
     */
    public String sendSms(List<String> phoneNos, String content, String ext, String stime, String rrid, String msgfmt) throws Exception{
        StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        String result = "";
        StringBuilder phoneStr = new StringBuilder();
        for(String phone : phoneNos){
            phoneStr.append(phone + ",");
        }
        String soapAction = "http://entinfo.cn/mdsmssend";
        xml.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        xml.append("<soap:Body>");
        xml.append("<mdsmssend  xmlns=\"http://entinfo.cn/\">");
        xml.append("<sn>" + map.get("mandaoKey") + "</sn>");
        xml.append("<pwd>" + getMD5(map.get("mandaoKey") + map.get("mandaoPwd")) + "</pwd>");
        xml.append("<mobile>" + phoneStr.toString().substring(0, phoneStr.length() - 1) + "</mobile>");
        xml.append("<content>" + content + "</content>");
        xml.append("<ext>" + ext + "</ext>");
        xml.append("<stime>" + stime + "</stime>");
        xml.append("<rrid>" + rrid + "</rrid>");
        xml.append("<msgfmt>" + msgfmt + "</msgfmt>");
        xml.append("</mdsmssend>");
        xml.append("</soap:Body>");
        xml.append("</soap:Envelope>");
        ByteArrayOutputStream bout = null;
        OutputStream out = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
        try {
            URL url = new URL(serviceURL);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpconn = (HttpURLConnection) connection;
            bout = new ByteArrayOutputStream();
            bout.write(xml.toString().getBytes("GBK"));
            byte[] b = bout.toByteArray();
            httpconn.setRequestProperty("Content-Length", String.valueOf(b.length));
            httpconn.setRequestProperty("Content-Type", "text/xml; charset=gb2312");
            httpconn.setRequestProperty("SOAPAction", soapAction);
            httpconn.setRequestMethod("POST");
            httpconn.setDoInput(true);
            httpconn.setDoOutput(true);
            out = httpconn.getOutputStream();
            out.write(b);
            out.close();
            isr = new InputStreamReader(httpconn.getInputStream());
            in = new BufferedReader(isr);
            String inputLine;
            while (null != (inputLine = in.readLine())) {
                Matcher matcher = patternMdsmssend.matcher(inputLine);
                while (matcher.find()) {
                    result = matcher.group(1);
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("漫道发送短信出现错误：" + e);
            return "";
        } finally {
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param phoneNo 手机号
     * @param content 短信内容
     * @param sign 短信签名
     * @return
     * @throws IOException
     */
    public String sendSms(String phoneNo, String content, String sign)throws Exception{
        List<String> phoneNos = new ArrayList<>(1);
        phoneNos.add(phoneNo);
        return sendSms(phoneNos, content, "", "", assembleMsgId(), "");
    }

    /**
     * 组装msgid
     * @return
     */
    private String assembleMsgId(){
        return  sf.format(new Date()) + (new Random().nextInt(899999) + 100000);
    }

    public static void main(String[] args) throws Exception{
        ManDaoSendMessage mandao = new ManDaoSendMessage();
        String content = "邀请您游玩迪斯尼";
        try {
            content = URLEncoder.encode(content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("短信内容编码有误：" + e);
        }
        String phone1 = "18521701268";
        String phone2 = "15102128719";
        String phone3 = "17730686861";
        String sendResult = mandao.sendSms(phone1, content, "");
        System.out.println(sendResult);
    }
}
