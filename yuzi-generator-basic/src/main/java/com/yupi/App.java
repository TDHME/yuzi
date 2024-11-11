package com.yupi;

import cn.hutool.core.io.resource.ClassPathResource;

import java.io.*;

/**
 * Hello world!
 */
public class App {
    // 动态文件和静态文件的生成
    // ----> 静态文件的生成
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("E:\\IDEAfileDemo\\yuzi-generator\\yuzi-generator-demo-projects\\acm-template\\README.md");
            FileOutputStream fos = new FileOutputStream("E:\\IDEAfileDemo\\yuzi-generator\\yuzi-generator-basic\\src\\main\\resources\\README.md");

            byte[] bytes = fis.readAllBytes();
            fos.write(bytes);
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
