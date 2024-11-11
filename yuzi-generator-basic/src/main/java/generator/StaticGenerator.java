package generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String inputStream = userDir+ File.separatorChar+"yuzi-generator-demo-projects";
        String outputStream = userDir + File.separatorChar+"generator-temple";

        staticCopy(inputStream,outputStream);

    }

    /**
     * 静态的复制文件
     * @param inputStream
     * @param outputStream
     */
    public static void staticCopy(String inputStream,String outputStream){
        FileUtil.copy(inputStream,outputStream,false);
    }
}
