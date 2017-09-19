package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * 读取resources目录下面的文件
 * Created by zjm on 06/08/2017.
 */
public class ResourcesFileRead {

    public static void readFile(String pathName) {
        File file = null;
        InputStream in = null;
        try {
            file = new File("" + pathName);
            in = new FileInputStream(file);
            Properties pros = new Properties();
            /*Path path = new File(pathName).toPath();
            if (Files.isReadable(path)) {
                in = new FileInputStream(path.toFile());
            }*/
            pros.load(in);
            System.out.println("");
        } catch (Exception e) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    public static void main(String[] args) {
//        Properties p = ResourceUtils.readConfigFile("", new Properties());
        String path = System.getProperty("user.dir");
        readFile(path + "/src/main/resources/test.properties");
    }
}
