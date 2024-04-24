package io;

import java.io.*;

public class Test1 {


    void copy_pdf_to_another_pdf_buffer_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\fxk\\Desktop\\myGithub\\javaGuide\\src\\io\\EasyRL_v1.0.6.pdf"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("EasyRL_v1.0.6_2.pdf"))) {
            int content;
            while ((content = bis.read()) != -1) {
                bos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    void copy_pdf_to_another_pdf_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\fxk\\Desktop\\myGithub\\javaGuide\\src\\io\\EasyRL_v1.0.6.pdf");
             FileOutputStream fos = new FileOutputStream("EasyRL_v1.0.6_3.pdf")) {
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    void copy_pdf_to_another_pdf_with_byte_array_buffer_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\fxk\\Desktop\\myGithub\\javaGuide\\src\\io\\EasyRL_v1.0.6.pdf"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("EasyRL_v1.0.6_4.pdf"))) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    void copy_pdf_to_another_pdf_with_byte_array_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\fxk\\Desktop\\myGithub\\javaGuide\\src\\io\\EasyRL_v1.0.6.pdf");
             FileOutputStream fos = new FileOutputStream("EasyRL_v1.0.6_5.pdf")) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }



    public static void main(String[] args) {
//        new Test1().copy_pdf_to_another_pdf_buffer_stream();
//        new Test1().copy_pdf_to_another_pdf_stream();
        new Test1().copy_pdf_to_another_pdf_with_byte_array_buffer_stream();
        new Test1().copy_pdf_to_another_pdf_with_byte_array_stream();
    }


}
