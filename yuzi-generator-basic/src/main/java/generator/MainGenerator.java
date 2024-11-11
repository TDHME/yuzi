package generator;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.MainTemplateConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        // E:\IDEAfileDemo\yuzi-generator
        String userDir = System.getProperty("user.dir");

        String inputStream = userDir+ File.separatorChar+"yuzi-generator-demo-projects";
        String outputStream = userDir + File.separatorChar+"generator-temple";

        StaticGenerator.staticCopy(inputStream,outputStream);

        // 指定模板文件所在的路径
        String rootDir = System.getProperty("user.dir") +  File.separatorChar + "yuzi-generator-basic";
        String inputPath = rootDir + File.separatorChar + "src\\main\\resources\\templates\\MainTemplate.java.ftl";
        String outputPath = "generator-temple/yuzi-generator-demo-projects/acm-template/src/com/yupi/acm/MainTemplate.java";

        // 编写数据
        MainTemplateConfig mainTemplateConfig = MainTemplateConfig.builder()
                .author("yupi")
                .loop(false)
                .outputText("求和结果")
                .build();

        DynamicGenerator.doGenerator(inputPath,outputPath,mainTemplateConfig);
    }

}
