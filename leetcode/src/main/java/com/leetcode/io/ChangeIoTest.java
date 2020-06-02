package com.leetcode.io;

import java.io.*;

/**
 * 字节流转换
 * Created by apa7 on 2020/6/1.
 */
public class ChangeIoTest {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(isr);
        System.out.println("请输入一行文字：");
        String line = bufferedReader.readLine();
        System.out.println(line);


        FileOutputStream fo = new FileOutputStream("changeio.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fo, "utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(line);
        bw.close();
    }

    /*public static void main(String[] args) throws IOException {//数据的方向：标准输入---》内存InputStream is = System.in;//System.in已经是描述好的标准输入流对象//转换InputStreamReader ir = new InputStreamReader(is, "utf-8");//加缓冲BufferedReader bfr = new BufferedReader(ir);
        System.out.println("请输入一行文字：");
        String msg = bfr.readLine();//保存到文件中//创建原始流FileOutputStream fos = new FileOutputStream("E:\\save.txt");//转换成字符输出流OutputStreamWriter ops = new OutputStreamWriter(fos, "utf-8");//加入缓冲功能BufferedWriter bfw = new BufferedWriter(ops);
        bfw.write(msg);
        bfw.close();
    }*/


    /*public static void main(String[] args) throws IOException {
        String srcFilePath ="E:\\code.java";//1.用FileInputStream创建数据通路    FileInputStream fis = new FileInputStream(srcFilePath);//2.用转换流将字节流转换成字符流:参数二是指定的字符编码集的名称    InputStreamReader ir = new InputStreamReader(fis,"unicode");//3.用缓冲流包装字符流    BufferedReader bfr = new BufferedReader(ir);
        String line = bfr.readLine();
        System.out.println(line);
        bfr.close();
    }*/
}