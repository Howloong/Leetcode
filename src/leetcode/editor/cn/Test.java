package leetcode.editor.cn;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName: Test
 * @Package: leetcode.editor.cn
 * @Description:
 * @Datetime: 2022/8/16   18:09
 * @Author: YuHan.Kang@outlook.com
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/kangyuhan/1356.txt")));
        String temp;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int line=0;
        while ((temp = bufferedReader.readLine() )!= null) {
            hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
            line++;
        }

        bufferedReader.close();


    }

    public static void store(Object obj, OutputStream out) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(obj);
        outputStream.flush();
        outputStream.close();
    }

}
