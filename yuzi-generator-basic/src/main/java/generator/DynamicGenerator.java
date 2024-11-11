package generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.MainTemplateConfig;

import java.io.*;

public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {


        // 指定模板文件所在的路径
        String rootDir = System.getProperty("user.dir") +  File.separatorChar + "yuzi-generator-basic";
        String inputPath = rootDir + File.separatorChar + "src\\main\\resources\\templates\\MainTemplate.java.ftl";
        String outputPath = rootDir + File.separatorChar + "MainTemplate.java";

        System.err.println(inputPath);
        System.err.println(outputPath);

        // 编写数据
        MainTemplateConfig mainTemplateConfig = MainTemplateConfig.builder()
                .author("yupi")
                .loop(true)
                .outputText("求和结果")
                .build();

        doGenerator(inputPath,outputPath,mainTemplateConfig);
    }

    public static void doGenerator(String inputPath,String outputPath,Object module) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templeDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templeDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        configuration.setNumberFormat("0.######");

        // 创建模版对象,加载指定模版
        Template template = configuration
                .getTemplate(new File(inputPath).getName());

        Writer fw = new FileWriter(outputPath);

        template.process(module,fw);

        fw.close();
    }


}
