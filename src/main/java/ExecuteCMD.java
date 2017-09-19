import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by zjm on 2017/3/15.
 */
public class ExecuteCMD {

    public static void exeCmd()throws IOException{
        ProcessBuilder pb = new ProcessBuilder("/bin/bash", "netstat", "-a");
        Process process = pb.start();
        InputStream is = process.getInputStream();
        Files.copy(is, Paths.get("netstat.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) throws InterruptedException {
        String str = "({\"key\" : \"value\"})";
        str = str.substring(str.indexOf("{"), str.indexOf("}") + 1);
        System.out.println(str);
        try{
            exeCmd();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
