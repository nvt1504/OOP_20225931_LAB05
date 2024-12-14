package hust.soict.dsai.garbage;

import java.io.*;

public class NoGarbage {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try {
            // Đọc tệp "text.txt" sử dụng StringBuffer để nối chuỗi
            FileInputStream fileInputStream = new FileInputStream("text.txt");
            int content;
            while ((content = fileInputStream.read()) != -1) {
                sb.append((char) content); // Dùng StringBuffer để nối chuỗi
            }
            fileInputStream.close();
            // Chuyển StringBuffer thành String cuối cùng
            String result = sb.toString();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }
}
