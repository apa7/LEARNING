package com.leetcode.io;

import java.io.*;

/**
 * Created by apa7 on 2020/6/1.
 */
public class BufferedWriterTest {

    public static void main(String[] args) throws IOException {
        print2();
    }

    public static void print() throws IOException {
        File file = new File("io.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功");
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "我叫XXX,性别:男,出生年月:XXXXX\\n我叫XXX,性别:男,出生年月:XXXXX";
        bw.write(str);
        bw.newLine();
        bw.close();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void print2() throws IOException {
        File file = new File("io.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功");
        }
        FileOutputStream fo = new FileOutputStream(file);
        BufferedOutputStream bo = new BufferedOutputStream(fo);
        String str = "我叫XXX,性别:男,出生年月:XXXXX\\n我叫XXX,性别:男,出生年月:XXXXX";
        bo.write(str.getBytes());
        bo.close();

        FileInputStream fi = new FileInputStream(file);
        BufferedInputStream bi = new BufferedInputStream(fi);
        byte[] buff = new byte[100];
        int len = -1;
        StringBuffer sb = new StringBuffer();
        while ((len = bi.read(buff, 0, buff.length)) != -1) {
            String r = new String(buff, 0, len);
            sb.append(r);
        }
        System.out.println(sb);
        bi.close();
    }

}