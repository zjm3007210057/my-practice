package socket;

import java.net.InetAddress;
import java.util.Arrays;

/**
 * Created by zhangjianming on 2016/9/21.
 */
public class InetAddressDemo1 {

    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名称：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println("字节数组形式的IP：" + Arrays.toString(bytes));
        System.out.println("直接形式的IP：" + address);
        //根据主机名获取InetAddress实例
//        InetAddress address1 = InetAddress.getByName("ZHANGJM-NB");
        //根据IP获取InetAddress实例
        InetAddress address1 = InetAddress.getByName("192.168.99.1");
        //或者,因为byte的范围是-128~127，所以99和1不用byte修饰
        InetAddress address2 = InetAddress.getByAddress(new byte[]{(byte)192, (byte)168, 99, 1});
        System.out.println("计算机名称：" + address2.getHostName());
        System.out.println("IP地址：" + address2.getHostAddress());
    }
}
